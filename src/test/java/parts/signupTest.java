package parts;
import Application.*;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import Application.Main;

public class signupTest {

	@Test
    public void testSuccessfulAdminRegistration() {
		Admin admin = new Admin();
        String input = "1\nadmin1\nadmin@example.com\n1234\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.Registration(); // Call the actual Registration function

        String expectedOutput = "\n+------- Registration Form -------+\n" +
                                "Do you Register as Admin/customer?(admin => 1 , customer =>2 , installer => 3)\n" +
                                "+------- Admin Register Form -------+\n" +
                                "Enter Your Username: Enter Your Email: Enter Your password: \n";
        assertEquals(expectedOutput, out.toString());
        assertEquals("admin1", admin.getUsername());
        assertEquals("admin@example.com", admin.getEmail());
        assertEquals(1234, admin.getPassword());
    }
	
	@Test
    public void testSuccessfulCustomerRegistration() {
		Customer customer = new Customer();
        String input = "1\nadmin1\nadmin@example.com\n1234\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.Registration(); // Call the actual Registration function

        String expectedOutput = "\n+------- Registration Form -------+\n" +
                                "Do you Register as Admin/customer?(admin => 1 , customer =>2 , installer => 3)\n" +
                                "+------- Admin Register Form -------+\n" +
                                "Enter Your Username: Enter Your Email: Enter Your password: \n";
        assertEquals(expectedOutput, out.toString());
        assertEquals("admin1", customer.getUsername());
        assertEquals("admin@example.com", customer.getEmail());
        assertEquals(1234, customer.getPassword());
    }
	
	@Test
    public void testSuccessfulInstallerRegistration() {
		Installer installer = new Installer();
        String input = "1\nadmin1\nadmin@example.com\n1234\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.Registration(); // Call the actual Registration function

        String expectedOutput = "\n+------- Registration Form -------+\n" +
                                "Do you Register as Admin/customer?(admin => 1 , customer =>2 , installer => 3)\n" +
                                "+------- Admin Register Form -------+\n" +
                                "Enter Your Username: Enter Your Email: Enter Your password: \n";
        assertEquals(expectedOutput, out.toString());
        assertEquals("admin1", installer.getUsername());
        assertEquals("admin@example.com", installer.getEmail());
        assertEquals(1234, installer.getPassword());
    }

}
