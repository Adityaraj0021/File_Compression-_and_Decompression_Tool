package org.example;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compressor compressor = new Compressor();
        Decompressor decompressor = new Decompressor();

        System.out.println("File Compression and Decompression Tool");
        System.out.println("Choose an option:");
        System.out.println("1. Compress File");
        System.out.println("2. Decompress File");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            if (choice == 1) {
                System.out.println("Enter source file or directory path:");
                String sourcePath = scanner.nextLine();
                System.out.println("Enter output compressed file path:");
                String outputPath = scanner.nextLine();
                compressor.compressToZip(sourcePath, outputPath); // Use zip or gzip depending on user choice
                System.out.println("Compression successful!");
            } else if (choice == 2) {
                System.out.println("Enter compressed file path:");
                String compressedPath = scanner.nextLine();
                System.out.println("Enter output directory path:");
                String outputDir = scanner.nextLine();
                decompressor.decompressZip(compressedPath, outputDir); // Use decompression method based on file type
                System.out.println("Decompression successful!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
