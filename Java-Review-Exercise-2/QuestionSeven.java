import java.util.Scanner;
import java.lang.Math;

class Power2
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int i = in.nextInt();
        in.close();
        int power = 0;
        int base = 2;
        int powerOfTwo = 0;
        if (i > 0)
        {
            while (powerOfTwo < i)
            {
                powerOfTwo = (int) Math.pow(base, power);
                power ++;
            }
            System.out.println("The smallest power of two that is greater or equal to the given integer is " + powerOfTwo);
        }
        else
        {
            System.out.println("You have not entered a positive integer. Please try again.");
        }
    }
}