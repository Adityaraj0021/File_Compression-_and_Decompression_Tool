package org.example;


import java.io.File;

public class FileUtils {

    public static boolean isZipFile(String filePath) {
        return filePath.endsWith(".zip");
    }

    public static boolean isGzipFile(String filePath) {
        return filePath.endsWith(".gz");
    }

    public static void createDirectoryIfNotExist(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
}

