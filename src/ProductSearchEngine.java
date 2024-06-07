import java.util.ArrayList;

public class ProductSearchEngine extends Thread implements IProductSearch
{
    private String type; //This will allow us to specify on what basis the search is being made. Can be name, category, or range.
    private String name; //If search is by name, this will be used.
    private String category;
    private int min; //min and max refer to the price range
    private int max;

    private ArrayList<Product> products; //The list to be searched

    //Constructors with parameters depending on the search type:

    public ProductSearchEngine(String type, String category, String name, ArrayList<Product> products)
    {
        this.type = type;
        this.category = category;
        this.name = name;
        this.products = products;
    }
    public ProductSearchEngine(String type, String category, ArrayList<Product> products)
    {
        this.type =type;
        this.category = category;
        this.products = products;
    }

    public ProductSearchEngine(String type, int min, int max, ArrayList<Product> products)
    {
        this.type = type;
        this.min = min;
        this.max = max;
        this.products = products;
    }


    public void run()
    {
        switch (type) {
            case "category":
            case "Category":
                searchCategory(category, products);
                break;
            case "name":
            case "Name":
                searchName(category, name, products);
                break;
            case "Range":
            case "range":
                searchInRange(min,max, products);
                break;
            default:
                System.out.println("Invalid input. :p");
        }
    }

    @Override
    public void searchName(String category, String name, ArrayList<Product> product) {
        if (!category.equalsIgnoreCase("Cleaning") && !category.equalsIgnoreCase("Clothing") && !category.equalsIgnoreCase("Electronics") && !category.equalsIgnoreCase("Plant") && !category.equalsIgnoreCase("SkinCare")) {
            System.out.println("The inputted type is not available.");
            return;
        }

        boolean exists = false;
        for (int x = 0; x < products.size(); x++)
        {
            if (products.get(x).getCategory().equalsIgnoreCase(category)  && products.get(x).getName().equalsIgnoreCase(name)) {
                System.out.println("---" + products.get(x).getName() + " information ---");
                products.get(x).printInfo();
                System.out.println("\n"); //For formatting only
                exists = true;
            }
        }

        if(!exists)
        {
            System.out.println("This item is not available. ");

        }
    }

    @Override
    public void searchCategory(String name, ArrayList<Product> product) {
        if (!category.equalsIgnoreCase("Cleaning") && !category.equalsIgnoreCase("Clothing") && !category.equalsIgnoreCase("Electronic") && !category.equalsIgnoreCase("Plant") && !category.equalsIgnoreCase("SkinCare")) {
            System.out.println("The inputted category is not available.");
            return;
        }

        boolean exists = false;
        for (int x = 0; x < products.size(); x++)
        {
            if (products.get(x).getCategory().equalsIgnoreCase(category) && products.get(x).getQuantity() !=0) {
                System.out.println("---" + products.get(x).getName() + " information---");
                products.get(x).printInfo();
                System.out.println("\n"); //For formatting only
                exists = true;
            }
        }

        if(!exists)
        {
            System.out.println("No item is available from this category");
        }
    }

    public void searchInRange(int min, int max, ArrayList<Product> product)
    {

        boolean exists = false;
        for (int x = 0; x < products.size(); x++)
        {
            if (products.get(x).getPrice() >= min && products.get(x).getPrice() <= max) {
                System.out.println("---" + products.get(x).getName() + " information---");
                products.get(x).printInfo();
                System.out.println("\n"); //For formatting only
                exists = true;
            }
        }

        if(!exists)
        {
            System.out.println("No item belongs to this price range.");
        }
    }
}
