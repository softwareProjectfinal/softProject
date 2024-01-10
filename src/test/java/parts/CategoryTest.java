package parts;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void add() {
    }

    @Test
    public void getProducts() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void testCategoryCreation() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "1", "category1", 20, "Description 1"));
        Category category = new Category("Interior", products);

        assertEquals("Interior", category.getName());
        assertEquals(1, category.getProducts().size());
    }

}