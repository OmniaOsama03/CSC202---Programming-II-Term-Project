// Custom exception class for invalid product
public class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}