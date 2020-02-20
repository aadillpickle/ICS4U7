import java.util.Scanner;

class QuestionThree
{

    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        String lastLine = "";
        for (int i = 1; i < n+1; i++)
        {
            int outside = i; 
            if (i == 1)
            {
                System.out.println(Integer.toString(outside));
                continue;
            }
            else if (i == 2)
            {
                lastLine = Integer.toString(outside) + " " + Integer.toString(outside);
                System.out.println(lastLine);
                continue;
            }
            else if (i > 2)
            {
                String middle = "";
                String[] lm = lastLine.split(" ");
                for (int x = 1; x < lm.length; x++)        
                {
                    middle += Integer.toString(Integer.parseInt(lm[x-1]) + Integer.parseInt(lm[x]));
                    middle += " ";
                }
                lastLine = Integer.toString(outside) + " " + middle + Integer.toString(outside);
                System.out.println(Integer.toString(outside) + " " + middle + Integer.toString(outside));
            }
        }
    }
}
