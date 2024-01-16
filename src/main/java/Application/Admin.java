package Application;

import parts.Category;
import parts.Product;
import parts.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

import java.util.Scanner;

public class Admin {
	private String username;
	private String Email;
	private int password;
	Logger logger = LoggerFactory.getLogger(Admin.class);
	String invalidText = "invalid Input";
	public Admin() {
		super();
		username = "";
		Email = "";
		password = 0;
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
	public int isequal(String username, int pass) {
		if(this.username.equalsIgnoreCase(username) && this.password == pass) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public void ManageProducts() {
		logger.info("\n+------- Manage Product -------+\n");
		//---------------------------------------
		logger.info("1) Add Products");
		logger.info("\n2) Update Products");
		logger.info("\nEnter the number of your Action: ");
		Scanner ManageP = new Scanner(System.in);
		Scanner Operation = new Scanner(System.in);
		//
		int Min = ManageP.nextInt();
		if(Min == 1) {
			logger.info("Product Name: ");
			String PName = Operation.nextLine();
			logger.info("Product Descreption: ");
			String PDescreption = Operation.nextLine();
			logger.info("Product Quantity: ");
			int PQuantity = Operation.nextInt();
			logger.info("Product Price: ");
			int PPrice = Operation.nextInt();
			logger.info("Product Category: ");
			String PCategory = Operation.nextLine();
			String  idNum="p"+Storage.productList.size();

			Storage.productList.add(new Product(PName,idNum, PCategory, PPrice, PDescreption));
			Storage.quantity.put(idNum,PQuantity);
			
			logger.info("\nAdded Successfuly");
		}else if(Min == 2){
			logger.info("\nEnter the name of Product: ");
			String name = Operation.nextLine();
			for (Product element : Storage.productList) {
				if(element.getName().equalsIgnoreCase(name)) {
					element.setName(name);
					logger.info("Edit successfuly");
				}
			}

		}else {
			logger.info(invalidText);
		}
	}
	
	public void ManageCategories() {
		logger.info("\n+------- Manage Categories -------+\n");
		String CatMenu = "\nAdd Categories" +
						 "\nEdit Categories" +
						 "\nDelete Categories" +
						 "\nEnter the number of your Action: ";
		logger.info(CatMenu);
		Scanner ManageCat = new Scanner(System.in);
		Scanner CategoryOperation = new Scanner(System.in);
		ArrayList<Category> categoryList = Storage.catalog.categories;
		int MCat = ManageCat.nextInt();
		if(MCat == 1) {
			logger.info("\nEnter the name of category: ");
			String Catname = CategoryOperation.nextLine();
			categoryList.add(new Category(Catname));
			logger.info("\nAdded Successfuly");
		}else if(MCat == 2) {
			logger.info("\nEnter the name of category: ");
			String name = CategoryOperation.nextLine();
			for (Category element : categoryList) {
				if(element.getName().equalsIgnoreCase(name)) {
					element.setName(name);
					logger.info("Edit successfuly");
				}
			}
		}else if(MCat == 3){
			logger.info("\nEnter the name of category do you want to delete: ");
			String DeleteName = CategoryOperation.nextLine();
			for (Category category: categoryList)
				if (category.getName().equals(DeleteName)) {
					categoryList.remove(category);
					logger.info("Delete successful");
				}
		}else {
			logger.info(invalidText);
		}
	}
	
	public void ManageCustomer() {
		logger.info("\n+------- Manage Customer -------+\n");
		String custemerMenu = "1) View Customers" +
							  "2) Add Customer" +
							  "3) Delete Customer";
		logger.info(custemerMenu);
		Scanner ManageCustomer = new Scanner(System.in);
		Scanner CustomerOperation = new Scanner(System.in);
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		int MCustomer = ManageCustomer.nextInt();
		if(MCustomer == 1) {
			
		}else if(MCustomer == 2) {
			logger.info("\nEnter the name of Customer: ");
			String CustomerName = CustomerOperation.nextLine();
			logger.info("\nEnter the Email of Customer: ");
			String CustomerEmail = CustomerOperation.nextLine();
			logger.info("\nEnter the password of Customer: ");
			int CustomerPassword = CustomerOperation.nextInt();
			CustomerList.add(new Customer(CustomerName,CustomerEmail,CustomerPassword));
			logger.info("Added Successfuly");
		}else if(MCustomer == 3) {
			logger.info("\nEnter the name of Customer do you want to delete: ");
			String DeleteCustomer = CustomerOperation.nextLine();
			Customer CustomerToDelete = new Customer(DeleteCustomer);
			CustomerList.remove(CustomerToDelete);
			logger.info("Delete successfuly");
		}else
			logger.info(invalidText);
	}
	public void AdminOperation() {
		Scanner AOperation = new Scanner(System.in);
		int OP = AOperation.nextInt();
		while(OP != 5) {
			
			String menu = "\n+------- Welcome to Admin Wizard -------+\n" +
		               "1) Manage Products\n" +
		               "2) Manage Categories\n" +
		               "3) Manage Customers\n" +
		               "4) Manage Installation\n" +
		               "5) Exit\n" +
		               "Enter The Operation Number: ";
		logger.info(menu);
	    	
        	switch(OP) {
    		case 1:
    			ManageProducts();
    			break;
    		case 2:
    			ManageCategories();
    			break;
    		case 3:
    			ManageCustomer();
    			break;
    		case 4:
    			logger.info("Manage Installation:");
    			break;
    		case 5:
    			logger.info("Thanks for Using Our Application");
    			System.exit(0);
    		default:
    			logger.info(invalidText);
    		}
		}
		
	}
}
