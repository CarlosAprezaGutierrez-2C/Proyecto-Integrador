package com.example.integradora.services;
import com.example.integradora.Models.Producto;
import com.example.integradora.repositories.ProductRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductRepository repo = new ProductRepository();

    public List<Producto> loadProducts() throws IOException {
        List<String> lines = repo.readAllLines();
        List<Producto> result = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            if (parts.length >= 5) {
                result.add(new Producto(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        Integer.parseInt(parts[3]),
                        parts[4]
                ));
            }
        }
        return result;
    }

    public void saveAllProducts(List<Producto> productos) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Producto p : productos) {
            String line = String.format("%s,%s,%.2f,%d,%s",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getStock(), p.getCategoria());
            lines.add(line);
        }
        repo.saveAllLines(lines);
    }
}