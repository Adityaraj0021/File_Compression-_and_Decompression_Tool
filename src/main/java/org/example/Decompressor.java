package org.example;


import java.io.*;
import java.util.zip.*;

public class Decompressor {

    public void decompressZip(String zipFilePath, String destDir) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                File newFile = new File(destDir, entry.getName());
                new File(newFile.getParent()).mkdirs();
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile))) {
                    byte[] bytesIn = new byte[1024];
                    int read;
                    while ((read = zis.read(bytesIn)) != -1) {
                        bos.write(bytesIn, 0, read);
                    }
                }
                zis.closeEntry();
            }
        }
    }

    public void decompressGzip(String gzipFilePath, String destFilePath) throws IOException {
        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(gzipFilePath));
             FileOutputStream fos = new FileOutputStream(destFilePath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}

