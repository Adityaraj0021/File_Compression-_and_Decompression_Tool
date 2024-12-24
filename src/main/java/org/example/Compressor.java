package org.example;

//package com.filecompression;

import java.io.*;
import java.util.zip.*;

public class Compressor {

    public void compressToZip(String sourceDir, String zipFilePath) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            File sourceFile = new File(sourceDir);
            zipFile(sourceFile, zipOut, "");
        }
    }

    private void zipFile(File fileToZip, ZipOutputStream zipOut, String parentDir) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (!parentDir.isEmpty()) {
                zipOut.putNextEntry(new ZipEntry(parentDir + "/"));
                zipOut.closeEntry();
            }
            for (File file : fileToZip.listFiles()) {
                zipFile(file, zipOut, parentDir + "/" + file.getName());
            }
            return;
        }
        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            zipOut.putNextEntry(new ZipEntry(parentDir + "/" + fileToZip.getName()));
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }

    public void compressToGzip(String sourceFilePath, String gzipFilePath) throws IOException {
        try (GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(gzipFilePath));
             FileInputStream fis = new FileInputStream(sourceFilePath)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }
        }
    }
}

