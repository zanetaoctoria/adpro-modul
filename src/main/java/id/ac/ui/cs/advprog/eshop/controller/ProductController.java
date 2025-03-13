package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";  // Name of the template for creating a product.
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";  // Name of the template for listing products.
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String productId, Model model) {
        Product product = service.findById(productId);
        if (product == null) {
            // In production, add proper error handling or flash message.
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        return "EditProduct";  // Name of the template for editing a product.
    }

    // POST endpoint to process the edited product details
    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model) {
        boolean updated = service.update(product);
        // Optionally, add flash attributes to inform the user about success/failure.
        return "redirect:/product/list";
    }

    // Existing delete endpoint (for reference)
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String productId, Model model) {
        service.delete(productId);
        return "redirect:/product/list";
    }
}