package parts;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import Application.Main;

public class LoginTest {

	@Test
    public void testSuccessfulCustomerLogin() {
        String username = "validCustomer";
        int password = 1234;

        ByteArrayInputStream in = new ByteArrayInputStream((username + "\n" + password + "\n").getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.Login(); // Call the actual Login function

        String expectedOutput = "\n+------- Welcome to Customer Wizard -------+\\n";
        assertEquals(expectedOutput, out.toString());
    }
	
	@Test
    public void testSuccessfulAdminLogin() {
        String username = "validCustomer";
        int password = 1234;

        ByteArrayInputStream in = new ByteArrayInputStream((username + "\n" + password + "\n").getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.Login(); // Call the actual Login function

        String expectedOutput = "\n+------- Welcome to Admin Wizard -------+\n";
        assertEquals(expectedOutput, out.toString());
    }
	
	public void testSuccessfulInstallerLogin() {
        String username = "validCustomer";
        int password = 1234;

        ByteArrayInputStream in = new ByteArrayInputStream((username + "\n" + password + "\n").getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.Login(); // Call the actual Login function

        String expectedOutput = "\n+------- Welcome to Installer Wizard -------+\n";
        assertEquals(expectedOutput, out.toString());
    }

}
