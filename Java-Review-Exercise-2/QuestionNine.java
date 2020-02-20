import java.util.Scanner;

class Asterisks
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the numbers, separated by spaces: ");
        String s = in.nextLine();
        in.close();
        String strArray[] = s.split(" ");
        int intArray[] = new int[strArray.length];
        
        for (int i = 0; i < strArray.length; i++)
        {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        for (int i = 0; i < intArray.length; i++)
        {
            int n = intArray[i];
            System.out.println(n + "*".repeat(n));
        }
    }
}