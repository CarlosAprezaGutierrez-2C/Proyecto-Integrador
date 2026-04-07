package com.example.integradora.services;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class productService {



public class ProductRepository {

    
        private final String FILE_PATH = "data/productos.csv";

        public ProductRepository() {
            try {
                Files.createDirectories(Paths.get("data"));
                Path path = Paths.get(FILE_PATH);
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de base de datos.");
            }
        }

        public List<String> readAllLines() throws IOException {
            Path path = Paths.get(FILE_PATH);
            if (!Files.exists(path)) return List.of();
            return Files.readAllLines(path);
        }

        public void saveAllLines(List<String> lines) throws IOException {
            Files.write(Paths.get(FILE_PATH), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

}
