import java.util.Scanner;
import java.util.Arrays;

class CarRecall
{
    public static void main(String[] args)
    {
        
        Integer[] defectiveModels = {119,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,221,780};
        Scanner in = new Scanner(System.in);
        System.out.println("What is the model number of your car? Please enter an integer.");
        int model = in.nextInt();
        in.close();

        if (Arrays.asList(defectiveModels).contains(model))
        {
            System.out.println("Your car is defective. It must be repaired.");

        }
        else 
        {
            System.out.println("Your car is not defective.");
        }
    }
}