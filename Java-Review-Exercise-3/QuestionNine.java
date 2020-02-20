import java.util.Scanner;

class Expressions
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        double a = in.nextDouble();
        System.out.println("Enter another number:");
        double b = in.nextDouble();
        System.out.println("Enter a third number:");
        double c = in.nextDouble();
        in.close();

        double p = 1 / norm(a,b,c);
        double q = norm(Math.pow(a, 2), Math.pow(b, 2), Math.pow(c, 2));
        double r = norm(2*a, 3*b, 5*c);
        double s = norm(Math.sqrt(3.0)*a, 0, 0) * norm(0, Math.sqrt(12)*b, 0) * norm(0, 0, Math.sqrt(27)* c);
        System.out.println(p + " " + q + " " + r + " " + s);
    }
    public static double norm (double x, double y, double z)
    {   
        double sumOfSquares = Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2);
        double out =  Math.pow(sumOfSquares, (1.0/2.0));
        return out;
    }
}