import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
   COPYRIGHT (C) 2020 Aadil Ali. All Rights Reserved.
   Class to create a graphic based on given commands 
   Solves ICS4U1 assignment #1
   @author Aadil Ali
   @version 1.01 2020-02-28
*/
public class GraphicalEditor
{
    private static ArrayList<ArrayList> graphicsOutput = new ArrayList<ArrayList>();
    private static final String WORKSPACE_PATH = "/Users/aadilali/repos/ICS4U1/Assignment - 1/";
    private static int M = 0;
    private static int N = 0;
    private static String originalColor = "";
    private static boolean colorFlag = false;

/**
   Convert calendar date into Julian day.
   Note: This algorithm is from Press et al., Numerical Recipes
   in C, 2nd ed., Cambridge University Press, 1992
   @param day day of the date to be converted
   @param month month of the date to be converted
   @param year year of the date to be converted
   @return the Julian day number that begins at noon of the
   given calendar date.
*/
    public static void I(int M, int N)
    {
        for (int i = 0; i < N; i++)
        {
            ArrayList<Integer> rowToAdd = new ArrayList<Integer>();
            graphicsOutput.add(rowToAdd);
            for (int j = 0; j < M; j++)
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
        graphicsOutput.get(Y - 1).set(X - 1, C);
    }

    public static void V(int X, int Y1, int Y2, String C)
    {
        int columnToColor = X - 1;
        int startingRow = Y1 - 1;
        int endingRow = Y2;

        for (int i = startingRow; i < endingRow; i++)
        {
            graphicsOutput.get(i).set(columnToColor, C);
        }
        
    }

    public static void H(int X1, int X2, int Y, String C)
    {
        ArrayList rowToColor = graphicsOutput.get(Y - 1);
        int startingColumn = X1 - 1;
        int endingColumn = X2;

        for (int i = startingColumn; i < endingColumn; i++)
        {
            rowToColor.set(i, C);
        }
    }

    public static void K(int X1, int Y1, int X2, int Y2, String C)
    {
        int startingRow = Y1 - 1;
        int endingRow = Y2;
        int startingColumn = X1 - 1;
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
        int row = Y;
        int column = X;

        if (!colorFlag)
        {
            originalColor = String.valueOf(graphicsOutput.get(row).get(column));
            colorFlag = true;
        }

        try
        {   
            graphicsOutput.get(row).set(column, C);
            
        }
        catch (IndexOutOfBoundsException e)
        {  

        }

        try
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row + 1).get(column))))
            {
                F(column, row + 1, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {

        }

        try
        {                
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row + 1).get(column - 1))))
            {                    
                F(column - 1, row + 1, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            
        }

        try
        {                
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row).get(column - 1))))
            {                    
                F(column - 1, row, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {

        }

        try
        {                
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row - 1).get(column - 1))))
            {                    
                F(column - 1, row - 1, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            
        }
        try
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row - 1).get(column))))
            {
                F(column, row - 1, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            
        }

        try
        {                
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row - 1).get(column + 1))))
            {                    
                F(column + 1, row - 1, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            
        }

        try
        {
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row).get(column + 1))))
            {
                F(column + 1, row, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {

        }
        try
        {                
            if (originalColor.equals(String.valueOf(graphicsOutput.get(row + 1).get(column + 1))))
            {                    
                F(column + 1, row + 1, C);
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            
        }
    }

    public static void S(String Name) throws IOException
    {
        String out = "";
        for (int i = 0; i < graphicsOutput.size(); i++)
        {
            for (int j = 0; j < graphicsOutput.get(i).size(); j++)
            {
                out+= String.valueOf(graphicsOutput.get(i).get(j));
            }
            out += "\n";
        }
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
        final List<String> VALID_COMMANDS = Arrays.asList("I", "C", "L", "V", "H", "K", "F", "S", "X");
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
        System.out.println("Enter the name of your input file (typically input.txt):");
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
            if (VALID_COMMANDS.contains(commandLetter))
            {
                if (commandLetter.equals("I") && numParams.get("I") == commandParameters.length)//runs
                {
                    M = Integer.parseInt(commandParameters[1]);
                    N = Integer.parseInt(commandParameters[2]);
                    I(M, N);
                }
                else if (commandLetter.equals("C") && numParams.get("C") == commandParameters.length)//runs
                {
                    C();
                }
                else if (commandLetter.equals("L") && numParams.get("L") == commandParameters.length)//runs
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y = Integer.parseInt(commandParameters[2]);
                    String C = commandParameters[3];
                    L(X, Y, C);
                }
                else if (commandLetter.equals("V") && numParams.get("V") == commandParameters.length)//runs
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y1 = Integer.parseInt(commandParameters[2]);
                    int Y2 = Integer.parseInt(commandParameters[3]);
                    String C = commandParameters[4];
                    V(X, Y1, Y2, C);
                }
                else if (commandLetter.equals("H") && numParams.get("H") == commandParameters.length)
                {
                    int X1 = Integer.parseInt(commandParameters[1]);
                    int X2 = Integer.parseInt(commandParameters[2]);
                    int Y = Integer.parseInt(commandParameters[3]);
                    String C = commandParameters[4];
                    H(X1, X2, Y, C);
                }
                else if (commandLetter.equals("K") && numParams.get("K") == commandParameters.length)
                {
                    int X1 = Integer.parseInt(commandParameters[1]);
                    int Y1 = Integer.parseInt(commandParameters[2]);
                    int X2 = Integer.parseInt(commandParameters[3]);
                    int Y2 = Integer.parseInt(commandParameters[4]);
                    String C = commandParameters[5];
                    K(X1, Y1, X2, Y2, C);
                }
                else if (commandLetter.equals("F") && numParams.get("F") == commandParameters.length)
                {
                    int X = Integer.parseInt(commandParameters[1]) - 1;
                    int Y = Integer.parseInt(commandParameters[2]) - 1;
                    String C = commandParameters[3];
                    F(X, Y, C);
                }
                else if (commandLetter.equals("S") && numParams.get("S") == commandParameters.length)
                {
                    String Name = commandParameters[1];
                    S(Name);
                }
                else if (commandLetter.equals("X") && numParams.get("X") == commandParameters.length) //runs
                {
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