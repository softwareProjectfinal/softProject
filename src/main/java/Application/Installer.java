package Application;

import java.util.Scanner;

public class Installer {
	private String username;
	private String Email;
	private int password;
	
	
	
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
		if(this.username.equalsIgnoreCase(username) & this.password == pass) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public void InstallerOperation() {
		Scanner COperation = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n+------- Welcome to Installer Wizard -------+\n");
	    	System.out.println("1) View installation requests");
	    	System.out.println("2) schedule appointments");
	    	System.out.println("5) Exit");
	    	System.out.println("Enter The Operation Number: ");
	    	// for the Installer dashboard
	    	//        	int OP = COperation.nextInt();
//        	
//        	switch(OP) {
//    		case 1:
//    			System.out.print("Products");
//    			break;
//    		case 2:
//    			System.out.print("cateogries");
//    			break;
//    		case 3:
//    			System.out.print("Add");
//    			break;
//    		case 4:
//    			System.out.print("delete");
//    		case 5:
//    			System.exit(0);
//    		}
		}
		
	}
	
}