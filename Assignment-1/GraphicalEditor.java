import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GraphicalEditor
{
    public static ArrayList<ArrayList> graphicsOutput = new ArrayList<ArrayList>();
    public static final String WORKSPACE_PATH = "/Users/aadilali/repos/ICS4U1/Assignment-1/";
    public static int M = 0;
    public static int N = 0;
    public static void I(int M, int N)
    {
        for (int i = 0; i < M; i++)
        {
            ArrayList<Integer> rowToAdd = new ArrayList<Integer>();
            graphicsOutput.add(rowToAdd);
            for (int j = 0; j < N; j++)
            {
                graphicsOutput.get(i).add(0);
            }
        }
    }
    public static void C()
    {
        for (int i = 0; i < graphicsOutput.size(); i++)
        {
            for (int j = 0; j < graphicsOutput.get(i).size(); j++)
            {
                graphicsOutput.get(i).set(j,0);
            }
        }
    }
    public static void L(int X, int Y, String C)
    {
        graphicsOutput.get(X-1).set(Y-1, C);
    }
    public static void V(int X, int Y1, int Y2, String C)
    {
        int columnToColor = X-1;
        int startingRow = Y1-1;
        int endingRow = Y2;

        for (int i = startingRow; i < endingRow; i++)
        {
            graphicsOutput.get(i).set(columnToColor, C);
        }
        
    }
    public static void H(int X1, int X2, int Y, String C)
    {
        ArrayList rowToColor = graphicsOutput.get(Y-1);
        int startingColumn = X1-1;
        int endingColumn = X2;

        for (int i = startingColumn; i < endingColumn; i++)
        {
            rowToColor.set(i, C);
        }
    }
    public static void K(int X1, int Y1, int X2, int Y2, String C)
    {
        int startingRow = Y1-1;
        int endingRow = Y2;
        int startingColumn = X1-1;
        int endingColumn = X2;

        for (int i = startingColumn; i < endingColumn; i++)
        {
            for(int j = startingRow; j < endingRow; j++)
            {
                graphicsOutput.get(i).set(j, C);
            }
        }

    }
    public static void F(int X, int Y, String C)
    {
        int row = X-1;
        int column = Y-1;
        String originalColor = String.valueOf(graphicsOutput.get(row).get(column));
        String color = C;
        L(row, column, color);
                    
        if (row-1 >= 0 && column+1 < N)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row-1).get(column+1))))
            {
                graphicsOutput.get(row-1).set(column+1, color);
                F(row, column+2, color);
            }
        }
        else if (row-1 >= 0 && column-1 >= 0)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row-1).get(column-1))))
            {
                graphicsOutput.get(row-1).set(column-1, color);
                F(row, column, color);
            }
        }
        else if (row+1 < M)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row+1).get(column))))
            {
                graphicsOutput.get(row+1).set(column, color);
                F(row+2, column+1, color);
            }
        }
        else if (column-1 >= 0)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row).get(column-1))))
            {
                graphicsOutput.get(row).set(column-1, color);
                F(row+1, column, color);
            }
        }
        else if (column+1 < N)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row).get(column+1))))
            {
                graphicsOutput.get(row).set(column+1, color);
                F(row+1, column+2, color);
            }
        }
        else if (row-1 >= 0)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row-1).get(column))))
            {
                graphicsOutput.get(row-1).set(column, color);
                F(row, column+1, color);
            }
        }
        else if (row+1 < M && column-1 >=0)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row+1).get(column-1))))
            {
                graphicsOutput.get(row+1).set(column-1, color);
                F(row+2, column, color);
            }
        }
        else if (row+1 < M && column+1 < N)
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row+1).get(column+1))))
            {
                graphicsOutput.get(row+1).set(column+1, color);
                F(row+2, column+2, color);
            }
        }
  
    }
    public static void S(String Name) throws IOException
    {
        System.out.println(Name);
        String out = "";
        for (int i = 0; i < graphicsOutput.size(); i++)
        {
            for (int j = 0; j < graphicsOutput.get(i).size(); j++)
            {
                out+= String.valueOf(graphicsOutput.get(i).get(j));
            }
            out += "\n";
        }
        System.out.println("boop");
        File outputFile = new File(WORKSPACE_PATH + Name);
        try
        {
            BufferedWriter writeOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
            writeOutput.write(out);
            //writeOutput.flush();
            writeOutput.close();
        }
        catch (IOException IOError)
        {

            System.out.println("IOError for writing to file");
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
         //"/Users/aadilali/repos/ICS4U1/Assignment-1/input.txt";
        List<String> validCommands = Arrays.asList("I", "C", "L", "V", "H", "K", "F", "S", "X");
        HashMap<String, Integer> numParams = new HashMap<String, Integer>();
        numParams.put("I", 3);
        numParams.put("C", 1);
        numParams.put("L", 4);
        numParams.put("V", 5);
        numParams.put("H", 5);
        numParams.put("K", 6);
        numParams.put("F", 4);
        numParams.put("S", 2);
        numParams.put("X", 1);
        Scanner getFile = new Scanner(System.in);
        System.out.println("Enter the name of your input file:");
        String filename = getFile.nextLine();
        getFile.close();
        File inputFile = new File(WORKSPACE_PATH + filename);
        String lines = "";
        try
        {
            Scanner readInput = new Scanner(inputFile);
            while (readInput.hasNextLine())
            {
                    lines += readInput.nextLine() + "\n";
            }
            readInput.close();
        }
        catch (IOException IOError)
        {
            System.out.println("IOError");
        }
        String[] inputArr = lines.split("\n");
        ArrayList<String[]> commands = new ArrayList<String[]>();
        for (int i = 0; i < inputArr.length; i++)
        {
            commands.add(inputArr[i].split(" "));
        }

        for (int i = 0; i < commands.size(); i++)
        {
            String commandLetter = commands.get(i)[0];
            String[] commandParameters = commands.get(i);
            if (validCommands.contains(commandLetter))
            {
                if (commandLetter.equals("I") && numParams.get("I") == commandParameters.length)//runs
                {
                    M = Integer.parseInt(commandParameters[1]);
                    N = Integer.parseInt(commandParameters[2]);
                    I(M, N);
                    System.out.println("1");
                }
                else if (commandLetter.equals("C") && numParams.get("C") == commandParameters.length)//runs
                {
                    C();
                    System.out.println("2");
                }
                else if (commandLetter.equals("L") && numParams.get("L") == commandParameters.length)//runs
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y = Integer.parseInt(commandParameters[2]);
                    String C = commandParameters[3];
                    L(X, Y, C);
                    System.out.println("3");
                }
                else if (commandLetter.equals("V") && numParams.get("V") == commandParameters.length)//runs
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y1 = Integer.parseInt(commandParameters[2]);
                    int Y2 = Integer.parseInt(commandParameters[3]);
                    String C = commandParameters[4];
                    V(X, Y1, Y2, C);
                    System.out.println("4");
                }
                else if (commandLetter.equals("H") && numParams.get("H") == commandParameters.length)
                {
                    int X1 = Integer.parseInt(commandParameters[1]);
                    int X2 = Integer.parseInt(commandParameters[2]);
                    int Y = Integer.parseInt(commandParameters[3]);
                    String C = commandParameters[4];
                    H(X1, X2, Y, C);
                    System.out.println("5");
                }
                else if (commandLetter.equals("K") && numParams.get("K") == commandParameters.length)
                {
                    int X1 = Integer.parseInt(commandParameters[1]);
                    int Y1 = Integer.parseInt(commandParameters[2]);
                    int X2 = Integer.parseInt(commandParameters[3]);
                    int Y2 = Integer.parseInt(commandParameters[4]);
                    String C = commandParameters[5];
                    K(X1, Y1, X2, Y2, C);
                    System.out.println("6");
                }
                else if (commandLetter.equals("F") && numParams.get("F") == commandParameters.length)
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y = Integer.parseInt(commandParameters[2]);
                    String C = commandParameters[3];
                    F(X, Y, C);
                    System.out.println("7");
                }
                else if (commandLetter.equals("S") && numParams.get("S") == commandParameters.length)
                {
                    String Name = commandParameters[1];
                    S(Name);
                    System.out.println("8");
                }
                else if (commandLetter.equals("X") && numParams.get("X") == commandParameters.length) //runs
                {
                    System.out.println("9");
                    System.exit(0);
                }
                else
                {
                    continue;
                }
            }
            else
            {
                continue;
            }
        }
    }
    
}