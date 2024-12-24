
# File Compression and Decompression Tool

This is a simple Java-based tool for compressing and decompressing files and directories. It supports compression formats like **ZIP** and **GZIP**. The tool allows users to compress files to save space and decompress them back to their original format.

## Features
- **Compress files**: Compress individual files or entire directories into ZIP or GZIP formats.
- **Decompress files**: Decompress ZIP and GZIP files back into their original files.
- **User-friendly interface**: Command-line interface (CLI) to interact with the tool.
- **Error handling**: Handles unsupported file types and other errors gracefully.

## Requirements
- **Java** (JDK 8 or higher)
- Maven (if you're using Maven for dependency management)

## Getting Started

### 1. Clone the repository:
```bash
git clone https://github.com/your-username/file-compression-tool.git
```

### 2. Navigate to the project directory:
```bash
cd file-compression-tool
```

### 3. Compile and run the project:

If you're using Maven:
```bash
mvn clean install
mvn exec:java
```

Alternatively, if you're using a traditional Java setup, compile the project using your IDE or terminal.

### 4. Running the Program
Once the program is compiled and set up, you can run it. The CLI will prompt you to choose between compression or decompression and will ask for the file paths accordingly.

### Example CLI Interaction:

```
File Compression and Decompression Tool
Choose an option:
1. Compress File
2. Decompress File
```

**Compress a File**:
- Enter the path of the source file or directory to compress.
- Enter the path of the output compressed file (ZIP or GZIP).

**Decompress a File**:
- Enter the path of the compressed file.
- Enter the output directory where you want the decompressed files to be stored.

## File Format Support
- **ZIP**: `.zip` format
- **GZIP**: `.gz` format

## Project Structure

```
FileCompressionTool
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── filecompression
│   │   │   │       ├── Compressor.java        // Handles file compression
│   │   │   │       ├── Decompressor.java      // Handles file decompression
│   │   │   │       ├── FileUtils.java         // Utility functions for file handling
│   │   │   │       ├── CompressionException.java // Custom exception class
│   │   │   │       └── Main.java              // Main entry point for the program
│   │   ├── resources
│   │
├── pom.xml                                      // Maven configuration file
└── README.md                                    // This file
```

## Dependencies

- **Java**: Java Development Kit (JDK 8 or higher)
- **Maven**: For managing dependencies (optional, can be skipped if managing manually)
- **Apache Commons Compress**: For extended file compression support (optional)

## Custom Exceptions

This tool includes a custom exception, `CompressionException`, that is thrown when an error occurs during compression or decompression. It provides more detailed error messages related to the process.

## Troubleshooting

- **Error: Unsupported file type**: Ensure that the file you are trying to compress or decompress is of a supported format (ZIP or GZIP).
- **Compression fails**: Check that the source file exists and the destination directory is writable.
- **Decompression fails**: Ensure that the file is a valid ZIP or GZIP file.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, feel free to fork the repository and submit a pull request. Please make sure to follow the existing code style and write meaningful commit messages.
