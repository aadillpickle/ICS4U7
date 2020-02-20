
class Casting 
{
    public static void main(String[] args)
    {
        int j = 5;
        double k = 1.6;
        int y;
        double z;

        y = j * (int)k; //not fine because when multiplication between a double and int happens the result has to be a double
        //but in this case it's an int so we need to cast the double to an int so we have integer multiplication, y  will be 8
        z = j * k; //fine because a double and an integer multiplication results in a double and z is a double, z will be 8.0 
        z = k * k; //fine because there's no difference in types when multiplying or assigning, z will be 2.56 (for some reason there is a rounding error here)
        k = j; //fine becasue there is no operation between different type, just an assignemnt
        //of int to double so no decimals are lost just a .0 added onto the end, k will be 5.0
        y = j + 3; //fine because we're adding the same type (int) and y is an int, y will be 8
        
        System.out.println(((Object)j).getClass().getSimpleName());
        System.out.println(((Object)k).getClass().getSimpleName());
        System.out.println(((Object)y).getClass().getSimpleName());
        System.out.println(((Object)z).getClass().getSimpleName());
        System.out.println(y);
        System.out.println(z);
        System.out.println(k);
        System.out.println(j);

    }
}