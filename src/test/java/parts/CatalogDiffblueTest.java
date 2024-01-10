package parts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
//
//import org.junit.BeforeClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CatalogDiffblueTest {
    /**
     * Method under test: {@link Catalog#viewAllProducts()}
     */
    @Test
    public void testViewAllProducts() {
        // Arrange
        Catalog catalog = new Catalog();

        // Act
        catalog.viewAllProducts();

        // Assert that nothing has changed
        assertEquals(3, catalog.categories.size());
    }

    /**
     * Method under test: {@link Catalog#filterProductsByPrice()}
     */
    class InputOutputProvider {

        Scanner scanner ;
        //void print(String message);

        public  InputOutputProvider(Scanner scanner) {
            this.scanner = scanner;
        }


        public String nextLine() {
            return scanner.nextLine();
        }


    }


    @Mock
    private static Scanner scanner;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeClass
    public static void setUp() {

        //System.setOut(new PrintStream(outputStreamCaptor));
        scanner = new Scanner(System.in);
    }

    @Test
    @Ignore
    public void testFilterProductsByPrice() {
        //MockitoAnnotations.openMocks(this);
        // Set up the mocked user input
        InputOutputProvider inputOutputProvider = new InputOutputProvider(scanner);

        String input = "10\n2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Set up the mocked scanner behavior
        when(inputOutputProvider.nextLine()).thenReturn("10", "2");

        // Call the method
        Catalog catalog = new Catalog(); // Instantiate your class
        catalog.filterProductsByPrice(/*scanner*/);

        // Assert the output
        assertEquals("here's no any product", outputStreamCaptor.toString().trim());
    }
}
