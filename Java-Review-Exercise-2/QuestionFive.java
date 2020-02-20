import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class FastFood 
{
    public static void main(String[] args)
    {
        int calories = 0;
        int burger = 0;
        int side = 0;
        int drink = 0;
        int dessert = 0;

        Map<Integer,Integer> burgers = new HashMap<Integer,Integer> ();

            burgers.put(1, 461);
            burgers.put(2, 431);
            burgers.put(3, 420);
            burgers.put(4, 0);

        Map<Integer,Integer> drinks = new HashMap<Integer,Integer>();
            drinks.put(1, 130);
            drinks.put(2, 160);
            drinks.put(3, 118);
            drinks.put(4, 0);
        
        Map<Integer,Integer> sides = new HashMap<Integer,Integer>();
            sides.put(1, 100);
            sides.put(2, 57);
            sides.put(3, 70);
            sides.put(4, 0);
        
        Map<Integer,Integer> desserts = new HashMap<Integer,Integer>();
            desserts.put(1, 167);
            desserts.put(2, 266);
            desserts.put(3, 75);
            desserts.put(4, 0);

        Scanner in = new Scanner(System.in);
        
        System.out.println("Welcome to Chip's Fast Food Emporium");
        System.out.println("Please enter a burger choice: ");
        burger = in.nextInt();
        System.out.println("Please enter a side order choice: ");
        side = in.nextInt();
        System.out.println("Please enter a drink choice: ");
        drink = in.nextInt();
        System.out.println("Please enter a dessert choice: ");
        dessert = in.nextInt();

        in.close();

        int burgerCals = burgers.get(burger);
        int drinkCals = drinks.get(drink);
        int sideCals = sides.get(side);
        int dessertCals = desserts.get(dessert);

        calories = burgerCals + drinkCals + sideCals + dessertCals;

        System.out.println("Your total calorie count is " + calories + ".");

    }
}