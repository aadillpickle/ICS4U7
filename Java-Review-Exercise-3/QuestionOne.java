import java.util.Scanner;

class Powers
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        double x = in.nextDouble();
        System.out.println("Enter another number:");
        double y = in.nextDouble();
        in.close();

        double ePower = Math.exp(y * Math.log(x));
        double regPower = Math.pow(x, y);

        System.out.println("Here is x to the power of y using the given exponent formula (rounded): " + Math.round(ePower));
        System.out.println("Here is y to the power of x using the regular expontent formula (unrounded): " + regPower);
    }
}