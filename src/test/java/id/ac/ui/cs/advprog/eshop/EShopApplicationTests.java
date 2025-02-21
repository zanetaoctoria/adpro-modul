package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMainMethod() {
        // Calling the main method. If it executes without errors, the test passes.
        EShopApplication.main(new String[]{});
    }
}