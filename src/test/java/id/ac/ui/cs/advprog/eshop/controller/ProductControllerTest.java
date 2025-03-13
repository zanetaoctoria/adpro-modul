package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@Import(ProductControllerTest.TestConfig.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Inject  custom-mocked ProductService.
    @Autowired
    private ProductService productService;

    // Test configuration to create and register a mock for ProductService
    static class TestConfig {
        @Bean
        public ProductService productService() {
            return Mockito.mock(ProductService.class);
        }
    }

    // Test for GET /product/create
//    @Test
//    void testCreateProductPage() throws Exception {
//        mockMvc.perform(get("/product/create"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("createProduct"))
//                .andExpect(model().attributeExists("product"));
//    }

    // Test for POST /product/create
    @Test
    void testCreateProductPost() throws Exception {
        // sample product
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Test Product");
        product.setProductQuantity(100);

        // Whenever any Product is passed to create(), return the sample product.
        when(productService.create(ArgumentMatchers.any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/product/create")
                        .param("productName", "Test Product")
                        .param("productQuantity", "100"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));

        // Verify that the create method was invoked with any Product.
        verify(productService).create(ArgumentMatchers.any(Product.class));
    }

    // Test for GET /product/list
//    @Test
//    void testProductListPage() throws Exception {
//        // sample product
//        List<Product> products = new ArrayList<>();
//        Product product = new Product();
//        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
//        product.setProductName("Test Product");
//        product.setProductQuantity(100);
//        products.add(product);
//
//        // When findAll() is called, return the list of products.
//        when(productService.findAll()).thenReturn(products);
//
//        mockMvc.perform(get("/product/list"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("productList"))
//                .andExpect(model().attribute("products", products));
//    }

//    // Test for GET /product/edit/{id} when the product exists
//    @Test
//    void testEditProductPageExists() throws Exception {
//        // sample product.
//        Product product = new Product();
//        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
//        product.setProductName("Test Product");
//        product.setProductQuantity(100);
//
//        // Mock the service to return the sample product for the given ID.
//        when(productService.findById("123e4567-e89b-12d3-a456-556642440000")).thenReturn(product);
//
//        mockMvc.perform(get("/product/edit/123e4567-e89b-12d3-a456-556642440000"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("editProduct"))
//                .andExpect(model().attribute("product", product));
//    }
//
    // Test for GET /product/edit/{id} when the product does not exist.
    @Test
    void testEditProductPageNotFound() throws Exception {
        // Mock the service to return null when a product with the given ID is requested because there has not been any product made
        when(productService.findById("123e4567-e89b-12d3-a456-556642440000")).thenReturn(null);

        mockMvc.perform(get("/product/edit/123e4567-e89b-12d3-a456-556642440000"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));
    }

    // Test for POST /product/edit
    @Test
    void testEditProductPost() throws Exception {
        // When update() is called, simulate a successful update.
        when(productService.update(ArgumentMatchers.any(Product.class))).thenReturn(true);

        mockMvc.perform(post("/product/edit")
                        .param("productId", "123e4567-e89b-12d3-a456-556642440000")
                        .param("productName", "Updated Product")
                        .param("productQuantity", "200"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(productService).update(ArgumentMatchers.any(Product.class));
    }

    // Test for POST /product/delete/{id}
    @Test
    void testDeleteProduct() throws Exception {
        // simulate a successful deletion.
        when(productService.delete("123e4567-e89b-12d3-a456-556642440000")).thenReturn(true);

        mockMvc.perform(post("/product/delete/123e4567-e89b-12d3-a456-556642440000"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

        verify(productService).delete("123e4567-e89b-12d3-a456-556642440000");
    }
}