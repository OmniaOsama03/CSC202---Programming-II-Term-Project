import java.util.ArrayList;
import java.util.List;

public class MarketPlace {
    private  ArrayList<Product> products;

    //default and overloaded constructors:
    public MarketPlace(){}
    public MarketPlace(ArrayList<Product> products){
        this.products = products;

    }

    //Setters and getters:
    public void setProducts(ArrayList<Product> products)
    {
        this.products = products;
    }
    public ArrayList<Product> getProducts()
    {
        return this.products;
    }

    //Other methods:
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product is successfully added to the MarketPlace!");
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
            System.out.println("Product is successfully removed from the MarketPlace!");
        }
        else
            System.out.println("Product is not available within the marketPlace");
    }


    public double calculateTotalCost(ArrayList<Integer> shoppingCart) { //Calculates total cost for a certain shopping cart
        double totalCost = 0.0;

        //Thought proccess - if the number matches the ID, get the price
        for (Product product : products) {
            for(int x = 0; x < shoppingCart.size(); x++)
            {
                if(shoppingCart.get(x) == product.getProductID())
                    totalCost += product.getPrice();
            }
        }

        return totalCost;
    }

}