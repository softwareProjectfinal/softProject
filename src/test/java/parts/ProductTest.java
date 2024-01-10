package parts;

import org.junit.Test;
import parts.Storage;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Product 1", "1", "category1", 20, "Description 1");

        assertEquals("1", product.getID());
        assertEquals("Product 1", product.getName());
        assertEquals("category1", product.getCategory());
        assertEquals("Description 1", product.getDescription());
        assertEquals(20, product.getPrice());
        product = new  Product("");
        assertEquals("", product.getName());
        assertEquals(product.toString(),product.getName() + ": " + product.getCategory() + " " + (product.getPrice() < 0 ? "Undefined" : product.getPrice()) + "$   " + Storage.quantity.get(product.getID()) + "     " + product.getDescription());

        product.setName("");
        assertEquals("",product.getName());

    }

    @Test
    public void getName() {
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getID() {
    }
}