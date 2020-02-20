import java.util.Scanner;

class Easter 
{
    public static void main(String[] args) 
    {
        Scanner inputYear = new Scanner(System.in);
        System.out.println("Enter the calendar year (a number greater than 0): ");
        int y = inputYear.nextInt();
        if (y > 0) 
        {
            //algorithm for finding month and day of easter in a given year
            int p = y / 100;
            int q = y - 19 * (y / 19);
            int r = (p - 17) / 25;
            int s = p - (p / 4) - (p - r) / 3 + 19 * q + 15;
            s = s - 30 * (s / 30); //this line should always make s = 0, could delete
            s = s - (s / 28) * (1 - (s / 28) * (29 / (s + 1)) * ((21 - q) / 11));
            int t = y + (y / 4) + s + 2 - p + (p / 4);
            t = t - 7 * (t / 7); //this line will also always have t = 0, could delete
            int u = s - t;
            int m = 3 + (u + 40) / 44;
            int d = u + 28 - 31 * (m / 4);

            System.out.println("In " + y + ", Easter falls on the following date: "
            + y + "-" + m + "-" + d);
        }
        else {
            System.out.println("You did not enter a number greater than 0. Run the program again and enter a valid input.");
        }
        inputYear.close();
    }
}