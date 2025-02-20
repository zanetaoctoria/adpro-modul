package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    // We need the repository to reset the in-memory data between tests.
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        // Reset the internal productData list so that each test starts with an empty repository.
        ReflectionTestUtils.setField(productRepository, "productData", new ArrayList<Product>());
    }

    // Test that creating a product generates an ID if none is provided.
    @Test
    void testCreateProductGeneratesId() {
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(10);
        // productId is not set, so the service should generate one.
        Product created = productService.create(product);

        assertNotNull(created.getProductId(), "Product ID should be generated if not provided");
        assertEquals("Test Product", created.getProductName());
        assertEquals(10, created.getProductQuantity());
    }

    @Test
    void testCreateProductWithId() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Test Product");
        product.setProductQuantity(10);
        // productId is not set, so the service should generate one.
        Product created = productService.create(product);

        assertEquals(created.getProductId(), "1");
        assertEquals("Test Product", created.getProductName());
        assertEquals(10, created.getProductQuantity());
    }

    @Test
    void testCreateProductWithIdEmpty() {
        Product product = new Product();
        product.setProductId("");
        product.setProductName("Test Product");
        product.setProductQuantity(10);
        // productId is not set, so the service should generate one.
        Product created = productService.create(product);

        assertNotEquals(created.getProductId(), "");
        assertEquals("Test Product", created.getProductName());
        assertEquals(10, created.getProductQuantity());
    }


    // Test that findAll returns an empty list when no products have been added.
    @Test
    void testFindAllEmpty() {
        List<Product> products = productService.findAll();
        assertTrue(products.isEmpty(), "Product list should be empty initially");
    }

    // Test that findAll returns all added products.
    @Test
    void testFindAllNonEmpty() {
        Product product1 = new Product();
        product1.setProductName("Product 1");
        product1.setProductQuantity(10);
        productService.create(product1);

        Product product2 = new Product();
        product2.setProductName("Product 2");
        product2.setProductQuantity(20);
        productService.create(product2);

        List<Product> products = productService.findAll();
        assertEquals(2, products.size(), "Should return two products");
    }

    // Test that findById returns the product when it exists.
    @Test
    void testFindByIdExisting() {
        Product product = new Product();
        product.setProductName("Existing Product");
        product.setProductQuantity(15);
        Product created = productService.create(product);

        Product found = productService.findById(created.getProductId());
        assertNotNull(found, "Product should be found by its ID");
        assertEquals(created.getProductId(), found.getProductId());
        assertEquals("Existing Product", found.getProductName());
    }

    // Test that findById returns null for a non-existent product.
    @Test
    void testFindByIdNonExisting() {
        Product found = productService.findById("non-existent-id");
        assertNull(found, "findById should return null when no product exists with the given ID");
    }

    // Test that update returns true and correctly updates an existing product.
    @Test
    void testUpdateExistingProduct() {
        Product product = new Product();
        product.setProductName("Original Name");
        product.setProductQuantity(10);
        Product created = productService.create(product);

        // Update the product details.
        created.setProductName("Updated Name");
        created.setProductQuantity(25);
        boolean updated = productService.update(created);

        assertTrue(updated, "Update should succeed for an existing product");

        Product updatedProduct = productService.findById(created.getProductId());
        assertNotNull(updatedProduct, "Updated product should be found");
        assertEquals("Updated Name", updatedProduct.getProductName());
        assertEquals(25, updatedProduct.getProductQuantity());
    }

    // Test that update returns false when trying to update a product that doesn't exist.
    @Test
    void testUpdateNonExistingProduct() {
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(50);

        // would return false if product is not updated or fail to update when update(product) is called
        boolean updated = productService.update(product);
        assertFalse(updated, "Update should fail for a nen-existing product");
    }

    // Test that delete returns true and removes an existing product.
    @Test
    void testDeleteExistingProduct() {
        Product product = new Product();
        product.setProductName("Product to Delete");
        product.setProductQuantity(15);
        Product created = productService.create(product);

        boolean deleted = productService.delete(created.getProductId());
        assertTrue(deleted, "Delete should succeed for an existing product");

        Product found = productService.findById(created.getProductId());
        assertNull(found, "Product should no longer exist after deletion");
    }

    // Test that delete returns false when trying to delete a non-existent product.
    @Test
    void testDeleteNonExistingProduct() {
        boolean deleted = productService.delete("non-existent-id");
        assertFalse(deleted, "Delete should fail for a non-existing product");
    }
}