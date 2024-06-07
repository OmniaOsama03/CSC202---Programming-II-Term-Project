import java.io.*;
import java.util.*;

public class TextIO {

    //To read from the product text files:
    public ArrayList<Product> productsFromFile() throws IOException {
        ArrayList<Product> products = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("C:\\Users\\maado\\IdeaProjects\\CSC202 Term Project\\src\\Products.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String description = data[2];
                double price = Double.parseDouble(data[3]);
                int quantity = Integer.parseInt(data[4]);
                String category = data[5];

                products.add(new Product(id, name, description, price, quantity, category));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    //To read from the customer text files:
    public ArrayList<Customer> customersFromFile() throws IOException {
        ArrayList<Customer> customersList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("C:\\Users\\maado\\IdeaProjects\\CSC202 Term Project\\src\\Customers.txt"))) {
            int counter = 1;
            Customer customer = null; // This will act as a placeholder

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (counter % 2 != 0) {
                    // Odd row, initialize customer attributes except for the last (shopping cart)
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String email = data[2];
                    String address = data[3];
                    customer = new Customer(id, name, email, address);

                } else {
                    // Even row, initialize the shopping cart attribute from the line with the ArrayList
                    ArrayList<Integer> shoppingCart = parseProducts(line);
                    customer.setShoppingCart(shoppingCart);
                    customersList.add(customer);

                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customersList;
    }


    //To read from the seller text file:
    public ArrayList<Seller> sellersFromFile() throws IOException {
        ArrayList<Seller> sellers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("C:\\Users\\maado\\IdeaProjects\\CSC202 Term Project\\src\\Seller.txt"))) {
            int counter = 1;
            Seller seller = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (counter % 2 != 0) {
                    // Odd row, initialize seller attributes except for the last (products)
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String email = data[2];
                    String address = data[3];
                    seller = new Seller(id, name, email, address);
                } else {
                    // Even row, initialize the products attribute from the line with the ArrayList
                    ArrayList<Integer> products = parseProducts(line);
                    seller.setProducts(products);
                    sellers.add(seller);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sellers;
    }

    //Used for the seller and customer text files, this method creates an arraylist of product IDs
    private ArrayList<Integer> parseProducts(String line) { //Made private since it should only be used within certain methods in this class.
        ArrayList<Integer> products = new ArrayList<>();
        String[] productsData = line.split(",");

        for (String productId : productsData) {
            products.add(Integer.parseInt(productId));
        }
        return products;
    }

    //Now,to write back into the text files:
    //Product ArrayList to rows in File:
    public void productsToFile(ArrayList<Product> products)
    {
        try(PrintWriter writer = new PrintWriter(new File("C:\\Users\\maado\\IdeaProjects\\CSC202 Term Project\\src\\Products.txt"))){
                    for(Product product : products)
                    {
                        writer.println(product.getProductID() + "," + product.getName() + "," + product.getDescription() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getCategory());
                    }
                    writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



    //Customer ArrayList to rows in File:
    public void customersToFile(ArrayList<Customer> customers) {
        try (FileWriter writer = new FileWriter(new File("C:\\Users\\maado\\IdeaProjects\\CSC202 Term Project\\src\\Customers.txt"))) {
            for (Customer customer : customers) {
                writer.write(customer.getUserId() + "," + customer.getName() + "," + customer.getEmail() + "," + customer.getAddress() + "\n");
                writer.write(transformProducts(customer.getShoppingCart()) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Seller Arraylist to rows in File:
    public void sellersToFile(ArrayList<Seller> sellers)
    {
        try(PrintWriter writer = new PrintWriter(new File("C:\\Users\\maado\\IdeaProjects\\CSC202 Term Project\\src\\Seller.txt")))
        {
            //id, name,email, address
            for(Seller seller: sellers)
            {
                writer.write(seller.getUserId() + "," + seller.getName() + "," + seller.getEmail() + "," + seller.getAddress() + "\n");
                writer.write(transformProducts(seller.getProducts()) + "\n");
            }
            writer.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private String transformProducts(ArrayList<Integer> products) //Turns an arraylist of products into a String of IDs (Comma-separated)
    {

        String separated = "";
        for(int x = 0; x < products.size(); x++)
        {
            if(x == products.size()-1) {
                separated += products.get(x);
            }
            else
            separated += products.get(x) + ",";
        }
        return separated;
    }

}