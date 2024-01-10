package parts;


public class Product {
    private String name;
    private String category;
    private String description;
    private int price;
    private String id;

    public Product(String pname) {

        init(pname, null, null, -1, null);

    }

    public Product(String nam, String id, String cte, int pri, String descr) {

        init(nam, id, cte, pri, descr);


    }

    private void init(String nam, String id_, String cte, int pri, String descr) {

        name = nam;
        id = id_;
        category = cte;
        price = pri;
        description = descr;


    }

    public String getName() {
        return name;
    }

    public String toString() {

        return getName() + ": " + getCategory() + " " + (getPrice() < 0 ? "Undefined" : getPrice()) + "$   " + Storage.quantity.get(id) + "     " + getDescription();
    }

    int getPrice() {

        return price;
    }

    public String getDescription() {

        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getID() {
        return id;
    }

    public void setName(String name) {

        this.name = name;

    }
}
