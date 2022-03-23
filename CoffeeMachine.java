package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int CoC;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Write how many cups of coffee you will need:");
        CoffeeMachine.CoC = sc.nextInt();
        calc();
        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/
    }
    static public void calc() {
        int cWater = 200;
        int cMilk = 50;
        int cCoffeeB = 15;
        System.out.println("For " + CoffeeMachine.CoC + " cups of coffee you will need:");
        System.out.println(CoffeeMachine.CoC * cWater + " ml of water");
        System.out.println(CoffeeMachine.CoC * cMilk + " ml of milk");
        System.out.println(CoffeeMachine.CoC * cCoffeeB + " g of coffee beans");

    }

}
