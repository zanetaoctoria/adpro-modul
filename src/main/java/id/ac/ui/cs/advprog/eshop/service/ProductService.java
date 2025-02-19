package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> findAll();

    // New methods for editing a product
    Product findById(String productId);
    boolean update(Product product);

    // Existing delete method
    boolean delete(String productId);
}