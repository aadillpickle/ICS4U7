import java.util.Scanner;


class Diamond {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = in.nextLine();
        in.close();

        if (str.length() > 10)
        {
            str = str.substring(0,11);
        }

        int repeatSpaces = str.length() - 1;
        String[] arr = new String[str.length() - 1];

        for (int i = 0; i < str.length(); i++)
        {
            String middle = Character.toString(str.charAt(i)); 
            String end = "";
            int inc = 1; //

            while (i - inc >= 0)
            {
                end += str.charAt(i - inc);
                inc ++;
            }

            String start = new StringBuffer(end).reverse().toString(); 
            String output = start + middle + end;

            if (i < str.length() - 1)
            {
                arr[i] = " ".repeat(repeatSpaces) + output;
            }
            System.out.println(" ".repeat(repeatSpaces) + output);
            repeatSpaces = repeatSpaces - 1;

        }
        for (int x = arr.length - 1; x >= 0; x--) 
        {
            System.out.println(arr[x]);
        }
    }
}