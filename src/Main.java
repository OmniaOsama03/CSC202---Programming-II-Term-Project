import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, QuantityZeroException {

       TextIO textIO = new TextIO();
        //Obtaining the data from the text files:
       ArrayList<Customer> customers = textIO.customersFromFile();
       ArrayList<Seller> sellers = textIO.sellersFromFile();
       ArrayList<Product> products = textIO.productsFromFile();

        System.out.println("   ---- Testing the data retrieval for products  ----  ");

        for(Product product: products) {
            product.printInfo();
            System.out.println("\n \n \n "); //For formatting only :)
        }

        System.out.println("   ---- Testing the data retrieval for sellers  ----  ");

        for(Seller seller: sellers) {
            seller.displayInfo();
            System.out.println("\n \n \n "); //For formatting only
        }

        System.out.println("   ---- Testing the data retrieval for Customers  ----  ");

        for(Customer customer: customers) {
            customer.displayInfo();
            System.out.println("\n \n \n "); //For formatting only
        }

        System.out.println("   ---- Testing the Multithreading  ----  ");

        //Creating 2 threads, and splitting the Products arraylist among them
        ArrayList<Product> search1 = new ArrayList<>();
        ArrayList<Product> search2 = new ArrayList<>();

        for (int x = 0; x <= 4; x++)
            search1.add(products.get(x));

        for (int x = 5; x <= 8; x++)
            search2.add(products.get(x));

        //Searching by name:
        ProductSearchEngine thread1 = new ProductSearchEngine("name", "Electronics", "phone",search1);
        ProductSearchEngine thread2 = new ProductSearchEngine("name", "Electronics","phone", search2);

        thread1.start();
        thread2.start();

        //Searching by price range:
        ProductSearchEngine thread3 = new ProductSearchEngine("range", 100,400,search1);
        ProductSearchEngine thread4 = new ProductSearchEngine("range", 100,400,search2);

        thread3.start();
        thread4.start();




        System.out.println("   ---- Methods to add and remove items from the shopping cart (Customer) ----  ");
        Product toAdd = products.get(2);
        Product toRemove = products.get(4);
        customers.get(1).addToCart(toAdd); //Should add product 2 to Jane Smith
        customers.get(2).removeFromCart(toRemove); //Should remove product 4 from Michael Wilson

        System.out.println("   ---- Methods to list, add and remove products from a seller  ----  ");
        sellers.get(1).listProducts(products);
        sellers.get(1).removeProduct(products.get(1));
        sellers.get(1).listProducts(products);

        sellers.get(1).addProduct(products.get(4));
        sellers.get(1).listProducts(products);

        System.out.println("   ---- Testing the data rewriting for Customers  ----  ");
        //Adding a custom row -
        ArrayList<Integer> sampleCart = new ArrayList<>(); //Creating a sample cart for testing
        sampleCart.add(6);
        sampleCart.add(3);
        customers.add(new Customer(1234, "Dr.Zakaria", "sample@email.com", "Jupiter", sampleCart));

        System.out.println("   ---- Testing the data rewriting for Sellers  ----  ");
        //Adding a custom row -

        ArrayList<Integer> sampleSet = new ArrayList<>(); //Creating a sample cart for testing
        sampleSet.add(6);
        sampleSet.add(3);
        sampleSet.add(8);
        sellers.add(new Seller(202, "Michael Jackson", "sample@email.com", "123 road", sampleSet));

        System.out.println("   ---- Testing the data rewriting for Products  ----  ");
        //Adding a custom row -
        products.add(new Product(11, "Phone", "A very nice and shiny phone.buy.",900,5,"electronics"));


       //To end the main method, transporting everything back into the text files:
       textIO.sellersToFile(sellers);
       textIO.customersToFile(customers);
       textIO.productsToFile(products);
    }
}