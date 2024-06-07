

import java.util.*;
import java.util.Scanner;

//Seller class that extends the user class
public class Seller extends User {
    private ArrayList<Integer> products;

    //Default and overloaded constructors
    public Seller(){}
    public Seller(int id,String name, String email, String address, ArrayList<Integer> products){
        super(id,name, email, address);
        this.products = products;

    }
    public Seller(int id,String name, String email, String address){
        super(id,name, email, address);
    }


    //Setters and getters:
    public void setProducts(ArrayList<Integer> products)
    {
        this.products = products;
    }

    public ArrayList<Integer> getProducts()
    {
        return this.products;
    }


    //overriding the abstract method
    @Override
    public void displayInfo() {
        System.out.println("---Seller information---");
        System.out.println("Seller ID: " + super.getUserId());
        System.out.println("Name: " + super.getName());
        System.out.println("Email: " + super.getEmail());
        System.out.println("Address: " + super.getAddress());
    }

    //Adding and removing products:
    public void addProduct(Product product) throws QuantityZeroException{
        if(product.getQuantity() == 0)
            throw new QuantityZeroException();

        products.add(product.getProductID());
        System.out.println(product.getName() + " has been added to the inventory");
    }

    public void removeProduct(Product product) {
        for (int x  = 0; x < products.size(); x++)
        {
            if(product.getProductID() == products.get(x))
            {
                products.remove(product.getProductID());
                return;
            }
        }
        System.out.println("This product is not available in your inventory.");
    }

    public void listProducts(ArrayList<Product> available_products) {
        System.out.println(" List of Products:");
            for( Product product : available_products)
            {

                    System.out.println("Product Name: " + product.getName() + "\n");
            }
        }
    }

