import java.util.Scanner;

class getUserInput {
    
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter a string: " );
        String s =  inputScanner.nextLine();
        System.out.println("Your string: " + s);

        System.out.println("Enter a character: " );
        char c = inputScanner.next().charAt(0);
        System.out.println("Your char: " + c);
    
        System.out.println("Enter an integer: ");
        int i =  inputScanner.nextInt();
        System.out.println("Your integer: " + i);

        System.out.println("Enter a floating point number: " );
        float f =  inputScanner.nextFloat();
        System.out.println("Your floating point number: " + f);

        inputScanner.close();
    }
}