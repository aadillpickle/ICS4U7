class QuestionOne
{
    public static void main(String[] args)
    {
        int[] mylist = {0,1,2,3,4};
        int[] listt = listIsArray(mylist);
        for (int i = 0; i < listt.length; i++)
        {
            System.out.println(listt[i]);
        }
        
    }
    public static int[] listIsArray (int[] list)
    {
        int[] returnList = new int[4];
        int a = 0;
        int b = 1;
        int c = 0;
        int d = 100;
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] == 0)
            {
                i++;
            }
            b *= list[i];
            if (list[i] > 0)
            {
                c += list[i];
            }
            if (list[i] < d) {
                d = list[i];
            }
        }
        returnList[0] = a;
        returnList[1] = b;
        returnList[2] = c;
        returnList[3] = d;
        return returnList;

    }
}