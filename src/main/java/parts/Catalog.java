package parts;


import orders.Request;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {

    public static final String SEPARATOR = "-----------------------";
    public ArrayList<Category> categories;
    Category electronics = new Category("Electronics");
    Category interior = new Category("Interior");
    Category exterior = new Category("Exterior");
    Product p;


    public Catalog() {

        categories = new ArrayList<>();
        //interior.add(new Product("steering"));
        categories.add(interior);
        categories.add(exterior);
        categories.add(electronics);

        interior = categories.get(0);
        exterior = categories.get(1);
        electronics = categories.get(2);


    }


    public void viewAllProducts() {
        System.out.println("\nAll Products:");
        System.out.println(SEPARATOR);
        for (Category category : categories) {
            boolean f = false;
            //
            System.out.println(category.getName() + ":\n");

            for (Product product : category.getProducts()) {
                if (!f)
                    System.out.println("""
                            Name     | Category | Price | Count | Description
                            -------------------------------------------------""");
                System.out.println(product);
                f = true;
                System.out.println(SEPARATOR);

            }
            if (!f)
                System.out.println("there's no any product");


        }

        System.out.println(SEPARATOR);
    }

    public void viewProducts() {
        System.out.println("");
        int i = 1;
        for (Category category : categories) {


            //System.out.println(category.getName()+":\n");
            for (Product product : category.getProducts()) {

                System.out.println(i + "-" + product.getName() + " " + product.getPrice() + "$");

                i++;
            }

        }

        System.out.println();
    }

    public void filterProductsByCatalog(Scanner scanner) {

        System.out.println();
        if (categories.isEmpty())
            System.out.println("No available Categories!");
        else {
            int index;
            do {

                System.out.println("Available Catalogs:");
                int i = 1;
                for (Category category : categories) {

                    System.out.println(i++ + "-" + category.getName());
                }

                System.out.print("Enter the catalog number to filter products: ");
                index = scanner.nextInt();
            } while (index > categories.size());

            String selectedCatalog = categories.get(index - 1).getName();
            System.out.println("Products in " + selectedCatalog + ":\n");

            Category category = categories.get(index - 1);
            int i = 1;
            if (!category.getProducts().isEmpty())
                for (Product product : category.getProducts()) {
                    System.out.println(i++ + "-" + product.getName());
                }

            else
                System.out.println("No products found for the this catalog.");
        }


        System.out.println("---------------------------");
    }


    public void filterProductsByPrice() {

        viewProducts();

        System.out.print("Enter the price: ");

        Scanner scanner = new Scanner(System.in);

        String price;

        do {

            price = scanner.nextLine();


        } while (!price.matches("[0-9]+"));

        System.out.println("Enter the number of option:");
        System.out.println("""
                1- Greater than (>)
                2- Less than    (<)
                3- Equal        (=)
                4- Not equal    (!=)
                """);

        String op = scanner.nextLine();

        boolean found = false;
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                int intPrice = Integer.parseInt(price);
                switch (op) {

                    case "1":
                        if (product.getPrice() > intPrice) {
                            System.out.println(product);
                            found = true;
                        }
                        break;
                    case "2":
                        if (product.getPrice() < intPrice) {
                            System.out.println(product);
                            found = true;
                        }
                        break;
                    case "3":
                        if (product.getPrice() == intPrice) {
                            System.out.println(product);
                            found = true;
                        }
                        break;
                    case "4":
                        if (product.getPrice() != intPrice) {
                            System.out.println(product);
                            found = true;
                        }
                        break;


                }
            }


        }


        if (!found)
            System.out.println("there's no any product");


        System.out.println();

    }


    public void requestInstallation(Scanner scanner) {
        p = null;
        viewProducts();
        Product p = new Product("");
        boolean found = false;
        do {


            System.out.print("Enter the number of product: ");
            String pNum = scanner.nextLine();
            if (!pNum.matches("[0-9]+"))
                continue;
            int i = 0;
            found = false;
            for (Category category : categories)
                for (Product product : category.getProducts()) {

                    i++;
                    if (i == Integer.parseInt(pNum)) {
                        found = true;
                        p = product;
                        String id = p.getID();
                        int v = Storage.quantity.get(id);
                        if (v != 0)
                            Storage.quantity.put(id, v - 1);
                        else {
                            found = false;
                            System.out.println("Not available!");
                            break;

                        }

                    }

                }


        } while (!found);


        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter your car make: ");
        String carMake = scanner.nextLine();
        System.out.print("Enter your car model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter your preferred date: ");
        String preferredDate = scanner.nextLine();

        // Create an installation request and add it to the list in storage
        Request request = new Request(p, customerName, carMake, carModel, preferredDate, false);
        Storage.installationRequests.add(request);

        System.out.println("Your installation request has been submitted and is awaiting confirmation.");

        request.email();


    }


}
