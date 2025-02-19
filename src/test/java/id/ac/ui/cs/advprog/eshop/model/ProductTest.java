package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product;

    @BeforeEach
    void setup() {
        this.product = new Product();
        this.product.setProductId("980f0dd8-e1ce-494f-b1ba-a7e7238c24f6");
        this.product.setProductName("Nasi Uduk Pak Gemblong");
        this.product.setProductQuantity(100);
    }

    @Test
    public void testGetProductId() {
        assert(this.product.getProductId().equals("980f0dd8-e1ce-494f-b1ba-a7e7238c24f6"));
    }

    @Test
    public void testGetProductName() {
        assert(this.product.getProductName().equals("Nasi Uduk Pak Gemblong"));
    }

    @Test
    public void testGetProductQuantity() {
        assert(this.product.getProductQuantity() == 100);
    }
}