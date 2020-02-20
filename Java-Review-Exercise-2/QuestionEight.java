import java.util.Scanner;

class Dice
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer between 1 and 1000 inclusive:");
        int m = in.nextInt();
        System.out.println("Enter another integer between 1 and 1000 inclusive:");
        int n = in.nextInt();
        in.close();
        int numWays = 0;

        if (m > 10)
        {
            m = 10;
        }
        if (n > 10)
        {
            n = 10;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int x = 1; x <= n; x++)
            {
                if (x + i == 10)
                {
                    // System.out.println("i: " + i ); 
                    // System.out.println("x: " + x);
                    // System.out.println("-----");
                    numWays +=1; 
                }
            }
        }
        if (numWays == 1)
        {
            System.out.println("There is " + numWays + " way to get the sum 10.");
        }
        else
        {
            System.out.println("There are " + numWays + " ways to get the sum 10.");
        }
    }
}