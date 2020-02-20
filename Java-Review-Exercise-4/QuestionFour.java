import java.util.*;

class QuestionFour
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] params = in.nextLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        String[] map = new String[n];
        int[][] counts = new int[n][m];
        for (int x = 0; x < n; x++)
        {
            map[x] = in.nextLine();
        }
        in.close();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (map[i].charAt(j) == '*')
                {
                    try
                    {
                        counts[i-1][j+1]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                        counts[i-1][j-1]++; 
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                        counts[i+1][j]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                        counts[i][j-1]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                            counts[i][j+1]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                            counts[i-1][j]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                            counts[i+1][j-1]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                    try
                    {
                            counts[i+1][j+1]++;
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
        }
        for (int a = 0; a < counts.length; a++)
        {
            for (int b = 0; b < counts[a].length; b++)
            {
                if(map[a].charAt(b) == '*')
                {
                    System.out.print("*");
                    continue;
                }
                System.out.print(counts[a][b]);
            }
            System.out.println("\n");
        }
    }
}