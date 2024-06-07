public class Product {
    private int productID;
    private String name;
    private String description;
    private double price;
    private static int quantity;
    private String category;

    public Product() {

    }

    public Product(int productID, String name, String description, double price, int quantity, String category) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }



    // setters and getters for the instances
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory(){ return category;}
    public void setCategory(String category){this.category = category;}


    //A method to display a product's info:
    public void printInfo()
    {
        System.out.println( " ID: " + productID + " Name: " + this.name + "\n Description: " + this.description + "\n Price: " + this.price + "\n Quantity: " + this.quantity + "\n Category: " + this.category);
    }
}