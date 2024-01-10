package parts;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<Product> products;

    public Category(String cname) {

        name = cname;
        products = new ArrayList<>();
    }

    public Category(String na, ArrayList<Product> products) {

        name = na;
        this.products = products;

    }

    public void add(Product p) {

        products.add(p);

    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
