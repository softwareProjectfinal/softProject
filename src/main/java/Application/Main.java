package Application;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static Admin admin = new Admin();
	static Customer customer = new Customer();
	static Installer installer = new Installer();
	static String EnterUsername = "Enter Your Username: ";
	static String EnterEmail = "Enter Your Email: ";
	static String Enterpassword = "Enter Your password: ";
	static Logger logger = LoggerFactory.getLogger(Main.class);
	public static void Registration() {
		int invalid = -2;
		do {
			Scanner input = new Scanner(System.in);
			Scanner fla = new Scanner(System.in);
			logger.info("\n+------- Registration Form -------+\n");
			//---------------------------------------------
			logger.info("Do you Register as Admin/customer?(admin => 1 , customer =>2 , installer => 3)");
			int flag = fla.nextInt();
			if(flag == 1) {
				invalid = 1;
				logger.info("\n+------- Admin Register Form -------+\n");
				logger.info(EnterUsername);
				String username = input.nextLine();
				admin.setUsername(username);
				// ---------------------------------------------
				logger.info(EnterEmail);
				String email = input.nextLine();
				admin.setEmail(email);
				// ---------------------------------------------
				logger.info(Enterpassword);
				int pass = input.nextInt();
				admin.setPassword(pass);
				
			} else if(flag == 2) {
				invalid = 1;
				logger.info("\n+------- Customer Register Form -------+\n");
				logger.info(EnterUsername);
				String username = input.nextLine();
				customer.setUsername(username);
				// ---------------------------------------------
				logger.info(EnterEmail);
				String email = input.nextLine();
				customer.setEmail(email);
				// ---------------------------------------------
				logger.info(Enterpassword);
				int pass = input.nextInt();
				customer.setPassword(pass);
				
			}else if(flag == 3) {
				invalid = 1;
				logger.info("\n+------- Installer Register Form -------+\n");
				logger.info(EnterUsername);
				String username = input.nextLine();
				installer.setUsername(username);
				// ---------------------------------------------
				logger.info(EnterEmail);
				String email = input.nextLine();
				installer.setEmail(email);
				// ---------------------------------------------
				logger.info(Enterpassword);
				int pass = input.nextInt();
				installer.setPassword(pass);
			}else {
				invalid = -1;
				logger.info("Invalid input, please enter number between 1 - 3 only");
			}
		}while(invalid == -1);
		
	}
	
	public static void Login() {
		int invalid = -2;
		do {
			Scanner input1 = new Scanner(System.in);
			logger.info("\n+------- Login Form -------+\n");
			//---------------------------------------------
			logger.info(EnterUsername);
	        String UserN = input1.nextLine();
	        logger.info(Enterpassword);
	        int password = input1.nextInt();
	        
	        if(customer.equal(UserN, password) == 1) {
	        	invalid = 1;
	        	customer.CustomerOperation();
	        }
	        else if(admin.equal(UserN, password) == 1){
	        	invalid = 1;
	        	admin.AdminOperation();
	        }
	        else if(installer.equal(UserN, password) == 1) {
	        	invalid = 1;
	        	installer.InstallerOperation();
	        }
	        else {
	        	invalid = -1;
	        	logger.info("invalid input.");
	        }
		}while(invalid == -1);
		
	}
	
	
	public static void main(String[] args) {
		logger.info("+---------------------------------------------+");
		logger.info("+----------- Welcome To Car Rentel -----------+");
		logger.info("+---------------------------------------------+");
		Registration();	
		Login();
	

	}

}