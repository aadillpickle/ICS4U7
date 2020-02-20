class Memory {
    public static void main(String[] args) {
        int myNum = 5;
        double yourNum = 4.5;
        yourNum = myNum + 2.5; //yourNum is now 7.5 (5+2.5 = 7.5)
        yourNum = yourNum - 2; //yourNum is now 5.5 (7.5-2 = 5.5)
        System.out.println(myNum); //prints out 5, myNum hasn't been modified so it is still 5
        System.out.println(yourNum * 2); //prints out 11.0 (5.5 * 2 = 11.0) and we must put the decimal because it is a float
        myNum = 3 * 2; //myNum is now 6 (3*2 = 6)
        yourNum = myNum - yourNum; //yourNum is now 0.5 (6-5.5 = 0.5)
        System.out.println(myNum); //prints out 6
        System.out.println(yourNum); //prints out 0.5
    }
}