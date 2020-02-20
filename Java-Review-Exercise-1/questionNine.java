import java.util.Scanner;

class Grading 
{
    public static void main(String[] args)
    {
        Scanner inputGrades = new Scanner(System.in);
        System.out.println("Enter the first grade (must be an integer value): ");
        int first = inputGrades.nextInt();
        System.out.println("Enter the second grade (must be an integer value): ");
        int second = inputGrades.nextInt();
        System.out.println("Enter the third grade (must be an integer value): ");
        int third = inputGrades.nextInt();
        System.out.println("Enter the fourth grade (must be an integer value): ");
        int fourth = inputGrades.nextInt();
        System.out.println("Enter the fifth and final grade (must be an integer value): ");
        int fifth = inputGrades.nextInt();

        double average = (double)(first + second + third + fourth + fifth) / 5.0;
        System.out.println("The average of the five grades is " + average);

        inputGrades.close();
    }
}