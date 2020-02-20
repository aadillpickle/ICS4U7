class QuestionTwo
{
    public static void main (String[] args)
    {
        int[][] mylist = new int[10][20];
        int[] listt = tableIsArray(mylist);
        for (int i = 0; i < listt.length; i++)
        {
            System.out.println(listt[i]);
        }   
    }
    public static int[] tableIsArray (int[][] table)
    {
        int[] returnList = new int[4];
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0; 
        int min = table[0][0];
        int max = 0;
        for (int i=0;i<table.length; i++)
        {
            for (int x=0; x<table[i].length; x++)
            {
                i++;
                b += x;
                if (x % 3 == 0)
                {
                    c++;
                }
                if (x < min)
                {
                    min = x;
                }
                if (x > max)
                {
                    max = x;
                }
            }
        }
        d = max - min;
        returnList[0] = a;
        returnList[1] = b;
        returnList[2] = c;
        returnList[3] = d;
        return returnList;
    }
}