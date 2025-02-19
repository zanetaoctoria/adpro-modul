package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    // In-memory storage for products
    private List<Product> productData = new ArrayList<>();

    // Create a new product and add it to the list
    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    // Return an iterator for all products
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    // Find a product by its productId.
    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId() != null && product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;  // or throw an exception if preferred
    }

    // Update a product. Returns true if update was successful.
    public boolean update(Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            Product product = productData.get(i);
            if (product.getProductId() != null && product.getProductId().equals(updatedProduct.getProductId())) {
                productData.set(i, updatedProduct);
                return true;
            }
        }
        return false;
    }

}