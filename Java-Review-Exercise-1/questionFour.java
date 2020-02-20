import java.util.Scanner;

class promptUser 
{
    public static void main (String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter an integer smaller than 1000: ");
        int i = inputScanner.nextInt();
        if (i < 1000) 
        {
            int hundreds = i / 100;
            int tens = i % 100;
            tens = tens / 10;
            int ones = i % 10;

            if (hundreds != 0) 
            {
                System.out.println("Hundreds Digit: " + hundreds);
            }
            if (tens != 0)
            {
                System.out.println("Tens Digit: " + tens);
            }
            if (ones != 0)
            {
                System.out.println("Ones Digit: " + ones);
            }
        
        }
        else 
        {
            System.out.println("You have entered an integer greater than 1000. Please run the program again with a valid input.");
        }

        inputScanner.close();
    }
    
}
