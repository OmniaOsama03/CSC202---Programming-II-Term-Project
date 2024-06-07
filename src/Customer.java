
import java.util.*;
class Customer extends User {
    private ArrayList<Integer> shoppingCart; //An arraylist of product IDs



    //Default and overloaded constructors:
    public Customer(){}
    public Customer(int id, String name, String email, String address, ArrayList<Integer> shoppingCart){
        super(id, name, email, address);
        this.shoppingCart = shoppingCart;
    }

    public Customer(int id, String name, String email, String address){
        super(id, name, email, address);
    }

    //Setters and getters:
    public ArrayList<Integer> getShoppingCart()
    {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Integer> shoppingCart)
    {
        this.shoppingCart = shoppingCart;

    }


    //Overridden method to display a customer's info
    @Override
    public void displayInfo() {
        System.out.println("--- Customer information---");
        System.out.println("Customer ID: " + super.getUserId());
        System.out.println("Name: " + super.getName());
        System.out.println("Email: " + super.getEmail());
        System.out.println("Address: " + super.getAddress());
        System.out.println("Shopping cart: " + printList(shoppingCart));

    }
    public String printList(ArrayList<Integer> cart)
    {
        if(cart.size() == 0)
        {
            System.out.println("None");
        }
        String s = "";
        for(int x = 0; x<cart.size(); x++)
        {

            s +=  cart.get(x) + ", ";
        }

        return s;
    }


    //Other necessary methods:
    public void addToCart(Product product) throws QuantityZeroException {
        if(product.getQuantity() == 0) {
            throw new QuantityZeroException();
        }

        if (!(shoppingCart.contains(product))) {
            shoppingCart.add(product.getProductID());
            System.out.println("The " + product.getName() + " is added to the shopping cart.");
            product.setQuantity(product.getQuantity()-1);

        }else if (shoppingCart.contains(product)) {

            System.out.println("One more "+ product.getName() + " is added to the shopping cart.");
            product.setQuantity(product.getQuantity()- 1 );
        }
    }

    public void removeFromCart(Product product) {
        if (shoppingCart.contains(product.getProductID())) {
            shoppingCart.remove(product.getProductID());
            System.out.println("The product is removed successfully.");
            product.setQuantity(product.getQuantity() + 1);
        }else{
            System.out.println(product.getName() + " is not in your cart!");
        }
    }

    public String findProductsInCart(Product product) {
        for(int x = 0 ; x < shoppingCart.size(); x++)
            if (product.getProductID() == shoppingCart.get(x)) {
                return "The " + product.getName() + " is in your cart!";
            }
        return "The " + product.getName() + " is not in your cart.";
        }

}