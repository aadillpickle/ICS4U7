import java.util.Scanner;

class Letter {
    public static void main(String[] args) 
    {
        int cost = 0;
        int extraCharges = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("What is the mass of your package (in grams)?");
        double mass = in.nextDouble();
        in.close();
        if (mass > 0 && mass <= 30)
        {
            cost = 40;
        }
        else if (mass > 30 && mass <= 50 ) 
        {
            cost = 55;
        }
        else if (mass > 50 && mass <= 100)
        {
            cost = 70;
        }
        else if (mass > 100)
        {
            mass = mass - 100;
            extraCharges = (int)mass / 50;
            if (mass % 50 != 0) 
            {
                extraCharges += 1;
            }
            cost = 70 + 25 * extraCharges;

        }
        else 
        {
            System.out.println("You have entered a mass of less than 0g. Your cost is therefore defaulted to 0. Please try again.");
        }
        System.out.println("The cost of your letter is " + cost + " sinas.");
    }
}