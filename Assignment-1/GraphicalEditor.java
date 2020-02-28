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
    private static int M = 0;
    private static int N = 0;
    private static String originalColor = "";
    private static boolean colorFlag = false;

/**
   Initializes an N x M grid of zeros
   @param M The number of columns in the graphic output grid
   @param N The number of rows in the graphic output grid
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
/**
   Sets all values in the graphic output grid to zero
*/
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
/**
   Sets a point in the graphics output grid to a certain color 
   @param X The x coordinate (column) of the point
   @param Y The y coordinate (row) of the point
   @param C The color of the point, represented as a single letter
*/
    public static void L(int X, int Y, String C)
    {
        graphicsOutput.get(Y - 1).set(X - 1, C);
    }
/**
   Sets a vertical line in the graphics output grid to a certain color.
   The length is the delta between Y2 and Y1.
   @param X The x coordinate (column) at which the line is drawn
   @param Y1 The starting y coordinate (row) of the line
   @param Y2 The ending y coordinate (row) of the line
   @param C The color of the points, represented as a single letter
*/
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
/**
   Sets a horizontal line in the graphics output grid to a certain color.
   The length is the delta between X2 and X1.
   @param X1 The starting x coordinate (column) of the line
   @param X2 The ending x coordinate (column) of the line
   @param Y The y coordinate (row) at which the line is drawn
   @param C The color of the points, represented as a single letter
*/
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
/**
   Sets a rectangle in the graphics output grid to a certain color.
   The length is the delta between X2 and X1.
   The width is the delta between Y2 and Y1.
   @param X1 The starting x coordinate (column) of the rectangle
   @param Y1 The starting y coordinate (row) of the rectangle
   @param X2 The ending x coordinate (column) of the rectangle 
   @param Y2 The ending y coordinate (row) of the rectangle
   @param C The color of the points, represented as a single letter
*/
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
/**
   Fills the region R with the color C, where R is defined as
   follows. Pixel (X, Y) belongs to R. Any other pixel
   which is the same color as pixel (X, Y) and shares a
   common side with any pixel in R also belongs to this region.
   @param X The x coordinate (column) of the starting point
   @param Y The y coordinate (row) of the starting point
   @param C The color of the points, represented as a single letter
*/
    public static void F(int X, int Y, String C)
    {
        int row = Y;
        int column = X;

        /*
        check if this is the first time the function is run to determine
        the original color that needs to be changed to the new color 
        */
        if (!colorFlag)
        {
            originalColor = String.valueOf(graphicsOutput.get(row).get(column));
            colorFlag = true;
        }
        //set point to new color
        try
        {   
            graphicsOutput.get(row).set(column, C);
            
        }
        catch (IndexOutOfBoundsException e)
        {  

        }
        /*
        check if any corners around the point are the original color 
        and call fill on them recursively if they are
        */
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

/**
   Creates and writes the contents of the graphics output grid to a file
   @param Name The name of the file that is created and written to
*/
    public static void S(String Name) throws IOException
    {
        /*
        append all rows to output and delimit 
        with \n to print rows on new lines
        */
        String output = "";
        for (int i = 0; i < graphicsOutput.size(); i++)
        {
            for (int j = 0; j < graphicsOutput.get(i).size(); j++)
            {
                output += String.valueOf(graphicsOutput.get(i).get(j));
            }
            output += "\n";
        }
        //create output file and write out output String to it
        File outputFile = new File(Name);
        try
        {
            BufferedWriter writeOutput = new BufferedWriter
            (new OutputStreamWriter(new FileOutputStream(outputFile)));
            writeOutput.write(output);
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
        //prompt for and get input text file
        Scanner getFile = new Scanner(System.in);
        System.out.println("Enter the name of your input file" 
        + "(ex. /Users/aadilali/repos/ICS4U1/Assignment-1/input.txt):");
        String filename = getFile.nextLine();
        getFile.close();
        File inputFile = new File(filename);
        //split text file into commands and split commands into parameters
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
        //preprocess and validate commands then call them with given params
        for (int i = 0; i < commands.size(); i++)
        {
            String commandLetter = commands.get(i)[0];
            String[] commandParameters = commands.get(i);
            if (VALID_COMMANDS.contains(commandLetter))
            {
                if (commandLetter.equals("I") 
                && numParams.get("I") == commandParameters.length)//runs
                {
                    M = Integer.parseInt(commandParameters[1]);
                    N = Integer.parseInt(commandParameters[2]);
                    I(M, N);
                }

                else if (commandLetter.equals("C") 
                && numParams.get("C") == commandParameters.length)//runs
                {
                    C();
                }

                else if (commandLetter.equals("L") 
                && numParams.get("L") == commandParameters.length)//runs
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y = Integer.parseInt(commandParameters[2]);
                    String C = commandParameters[3];
                    L(X, Y, C);
                }

                else if (commandLetter.equals("V") 
                && numParams.get("V") == commandParameters.length)//runs
                {
                    int X = Integer.parseInt(commandParameters[1]);
                    int Y1 = Integer.parseInt(commandParameters[2]);
                    int Y2 = Integer.parseInt(commandParameters[3]);
                    String C = commandParameters[4];
                    V(X, Y1, Y2, C);
                }

                else if (commandLetter.equals("H") 
                && numParams.get("H") == commandParameters.length)
                {
                    int X1 = Integer.parseInt(commandParameters[1]);
                    int X2 = Integer.parseInt(commandParameters[2]);
                    int Y = Integer.parseInt(commandParameters[3]);
                    String C = commandParameters[4];
                    H(X1, X2, Y, C);
                }

                else if (commandLetter.equals("K") 
                && numParams.get("K") == commandParameters.length)
                {
                    int X1 = Integer.parseInt(commandParameters[1]);
                    int Y1 = Integer.parseInt(commandParameters[2]);
                    int X2 = Integer.parseInt(commandParameters[3]);
                    int Y2 = Integer.parseInt(commandParameters[4]);
                    String C = commandParameters[5];
                    K(X1, Y1, X2, Y2, C);
                }

                else if (commandLetter.equals("F") 
                && numParams.get("F") == commandParameters.length)
                {
                    int X = Integer.parseInt(commandParameters[1]) - 1;
                    int Y = Integer.parseInt(commandParameters[2]) - 1;
                    String C = commandParameters[3];
                    F(X, Y, C);
                }
                else if (commandLetter.equals("S") 
                && numParams.get("S") == commandParameters.length)
                {
                    String Name = commandParameters[1];
                    S(Name);
                }
                else if (commandLetter.equals("X") 
                && numParams.get("X") == commandParameters.length) 
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