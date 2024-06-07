public class FibonacciSequence
{
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ....
    public static void main(String[] args)
    {
        int a = 0;
        int b = 1;
        int c;

        do
        {
            System.out.print(a + "   ");
            c = a + b;
            a = b;
            b = c;
        } while (a < 600);

    }
}
