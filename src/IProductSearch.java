import java.util.ArrayList;

public interface IProductSearch
{

    //Will contain the search methods we're implementing:
    void searchName(String category, String name,ArrayList<Product> product);
    void searchCategory(String name,ArrayList<Product> product);
    void searchInRange(int min, int max,ArrayList<Product> product);

}
