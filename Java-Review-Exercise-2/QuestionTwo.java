import java.util.Scanner;

class PackageCheck 
{
    public static void main(String[] args)
    {
        boolean isHeavy = false;
        boolean isLarge = false;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the weight of your package in grams: ");
        double weight = in.nextDouble();
        System.out.println("Enter the length of your package in cm: ");
        double length = in.nextDouble();
        System.out.println("Enter the width of your package in cm: ");
        double width = in.nextDouble();
        System.out.println("Enter the height of your package in cm: ");
        double height = in.nextDouble();
        double volume = length * width * height;

        if (weight > 27000)
        {
            isHeavy = true;
        }

        if (volume > 1000000)
        {
            isLarge = true;
        }

        if (isHeavy && isLarge) 
        {
            System.out.println("Too heavy and too large.");
        }
        else if (isHeavy) 
        {
            System.out.println("Too heavy.");
        }
        else if (isLarge)
        {
            System.out.println("Too large");
        }
        else
        {
            System.out.println("Your package meets all the requirements!");    
        }

        in.close();
    }
}