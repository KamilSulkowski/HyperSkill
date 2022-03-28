package machine;

public class CoffeeMachine {


    public static void main(String[] args) {
        while (Variables.menu) {
            Variables.cCost = 0;
            Variables.cWater = 0;
            Variables.cMilk = 0;
            Variables.cCoffeeB = 0;
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = Variables.sc.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  ");
                    String coffee = Variables.sc.nextLine();
                    switch (coffee) {
                        case "1":
                            Methods.espresso();
                            break;
                        case "2":
                            Methods.latte();
                            break;
                        case "3":
                            Methods.cappuccino();
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    Methods.addToMachine();
                    break;
                case "take":
                    Methods.takeFromMachine();
                    break;
                case  "remaining":
                    Methods.storageMachine();
                    break;
                case "exit":
                    Variables.menu = false;
                    break;
            }
        }
    }

}
