
abstract class User {
    int userId;
    private String name;
    private String email;
    private String address;

    //default and overloaded constructors
    public User(){}
    public User(int id, String name, String email, String address) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public User(int id, String name, String email) //In case Address has not been provided
    {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.address = "N/A";
    }



    //setters and getters
    public int getUserId(){
        return userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    //abstract method
    public abstract void displayInfo();

}
