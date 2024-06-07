// Custom exception class for out of stock
public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}