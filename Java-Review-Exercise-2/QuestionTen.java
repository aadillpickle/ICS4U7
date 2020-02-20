class WellOrder
{
    public static void main(String[] args)
    {
        int threeDigitMax = 1000;
        int threeDigitMin = 100;
        int wellOrderedCount = 0;
        String wellOrderedNums = "";
        for (int i = threeDigitMin; i < threeDigitMax; i++)
        {
            String strInt = Integer.toString(i);
            int firstDigit = Integer.parseInt(Character.toString(strInt.charAt(0)));
            int secondDigit = Integer.parseInt(Character.toString(strInt.charAt(1)));
            int thirdDigit = Integer.parseInt(Character.toString(strInt.charAt(2)));
            
            if (firstDigit < secondDigit && secondDigit < thirdDigit)
            {
                wellOrderedCount ++;
                wellOrderedNums += strInt + " ";

                if (wellOrderedCount % 10 == 0)
                {
                    wellOrderedNums += "\n";
                }
            }
        }
        System.out.println(wellOrderedNums);
        System.out.println("The total number is " + wellOrderedCount);
    }
}