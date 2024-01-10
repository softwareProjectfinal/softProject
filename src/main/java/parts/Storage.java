package parts;

import orders.Request;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {

    public static ArrayList<Request> installationRequests = new ArrayList<>();
    public static ArrayList<Product> productList = new ArrayList<Product>();
    public static Catalog catalog;
    String[] part = {"steering cover * p1 * interior * 13 * black leather ", "wheel cover * p2 * external * 20 * silver aluminium  "};
    //enum  parts {steering,"wheel","radio"};
    public static HashMap<String, Integer> quantity = new HashMap<>();

    void s() {


    }


    public Storage() {

        catalog = new Catalog();

        String[] fields;

        for (String p : part) {
            fields = p.split(" [*] ");
            String cat = fields[2];
            if (cat.equals("interior")) {
                catalog.interior.add(new Product(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]));
                quantity.put(fields[1], 3);
            } else if (cat.equals("external")) {
                catalog.exterior.add(new Product(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]));
                quantity.put(fields[1], 3);
            } else if (cat.equals("electronics")) {
                catalog.electronics.add(new Product(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]));
                quantity.put(fields[1], 3);
            }
        }


    }

    public Catalog getCatalog() {
        return catalog;
    }
}
