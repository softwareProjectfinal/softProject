package Application;

import parts.Catalog;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Customer {
	private String username;
	private String Email;
	private int password;
	
	Logger logger = LoggerFactory.getLogger(Customer.class);
	String invalidText = "Invalid Input";
	String successfulText = "Updated Successfuly";
	public Customer() {
		super();
		username = "";
		Email = "";
		password = 0;
	}
	

	public Customer(String username) {
		super();
		this.username = username;
	}
	public Customer(String username, String email, int password) {
		super();
		this.username = username;
		Email = email;
		this.password = password;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	public int equal(String username, int pass) {
		if(this.username.equalsIgnoreCase(username) && this.password == pass) {
			return 1;
		}else {
			return -1;
		}
	}
	
	
	public void CustomerOperation() {
		Scanner COperation = new Scanner(System.in);
    	
    	while(true) {
    		logger.info("\n+------- Welcome to Customer Wizard -------+\n");
    		String cutemerOperation = "1) Browse Products" +
    								  "2) Make Purchases" +
    								  "3) View Orders History" +
    								  "4) View Installation Requests" +
    								  "5) Edit profile" +
    								  "6) Exit" +
    								  "Enter The Operation Number: ";
    		logger.info(cutemerOperation);
        	// for the customer dashboard
        	int OP = COperation.nextInt();
        	Catalog NewCatalog = new Catalog();
    		switch(OP) {
    		case 1:
    			logger.info("\n+------- Browse Products -------+\n");
    			NewCatalog.viewAllProducts();
    			break;
    		case 2:
    			logger.info("\n+------- Make Purchases -------+\n");
    			Scanner Purchase = new Scanner(System.in);
    			NewCatalog.requestInstallation(Purchase);
    			logger.info("Successfully");

    			break;
    		case 3:
    			logger.info("\nView Order History:");
    			break;
    		case 4:
    			logger.info("\nView Installation Requests:");
    			break;
    		case 5:
    			logger.info("\n+------- Your Profile -------+\n");
    			System.out.println("Your Username: " + this.getUsername());
    			System.out.println("Your Email: " + this.getEmail());
    			logger.info("\n1) Edit Username");
    			logger.info("\n2) Edit Email");
    			logger.info("\n3) Change Password");
    			Scanner Choise = new Scanner(System.in);
    			Scanner Operation = new Scanner(System.in);
    			int ChoiseNum = Choise.nextInt();
    			if(ChoiseNum == 1) {
    				logger.info("Enter New Username: ");
    				String NewUsername = Operation.nextLine();
    				this.setUsername(NewUsername);
    				logger.info(successfulText);
    			}else if(ChoiseNum == 2) {
    				logger.info("Enter New Email: ");
    				String NewEmail = Operation.nextLine();
    				this.setEmail(NewEmail);
    				logger.info(successfulText);
    			}else if(ChoiseNum == 3) {
    				logger.info("Enter New Password: ");
    				int NewPassword = Operation.nextInt();
    				this.setPassword(NewPassword);
    				logger.info(successfulText);
    			}else {
    				logger.info(invalidText);
    			}

    			break;
    		case 6:
    			logger.info("Thank you for using our application.");
    			System.exit(0);
    		default:
    			logger.info(invalidText);
    		}
    	}
	}
	

}