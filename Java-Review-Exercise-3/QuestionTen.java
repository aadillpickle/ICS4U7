import java.util.Scanner;

class Factoring
{
    public static void main(String[] args)
    {
        String inputMessage = "Enter a positive integer to get its prime factorization. Enter a negative number to stop.";
        Scanner in = new Scanner(System.in);
    
            System.out.println(inputMessage);
            int number = in.nextInt();
            while (number >= 1)
            {
                int originalNumber = number;
                int product = 1;
                int factor = 1;

                while (product != originalNumber)
                {
                    factor = leastFactor(number);
                    System.out.println(factor);
                    product *= factor;
                    number = number / factor;
                }

                System.out.println(inputMessage);
                number = in.nextInt();
            }
        in.close();
    }

    public static int leastFactor(int n)
    {

        int smallestFactor = 1;
        if (n > 1)
        {
            for (int i = 2; i <= n ; i++)
            {
                if (n % i == 0)
                {
                    smallestFactor = i;
                    break;
                }
            }
            return smallestFactor;
        }    
        else
        {
            return 0;
        }
    } 
}