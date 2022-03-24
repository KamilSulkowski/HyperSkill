package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static boolean menu = true;
    static int CoC = 1;
    static int cCost;
    static int cWater;
    static int cMilk;
    static int cCoffeeB;
    static int iWater = 400;
    static int iMilk = 540;
    static int iCoffeeB = 120;
    static int iCups = 9;
    static int iMoney = 550;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (menu) {
            CoffeeMachine.cCost = 0;
            CoffeeMachine.cWater = 0;
            CoffeeMachine.cMilk = 0;
            CoffeeMachine.cCoffeeB = 0;
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:  ");
                    String coffee = sc.nextLine();
                    switch (coffee) {
                        case "1":
                            espresso();
                            break;
                        case "2":
                            latte();
                            break;
                        case "3":
                            cappuccino();
                            break;
                        case "back":
                            break;
                    }
                    break;
                case "fill":
                    addToMachine();
                    break;
                case "take":
                    takeFromMachine();
                    break;
                case  "remaining":
                    storageMachine();
                    break;
                case "exit":
                    menu = false;
                    break;
            }
        }
        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!"); */
    }
   static public void calc() {
        System.out.println("Write how many cups of coffee you will need:");
        CoffeeMachine.CoC = sc.nextInt();
        System.out.println("For " + CoffeeMachine.CoC + " cups of coffee you will need:");
        System.out.println(CoffeeMachine.CoC * CoffeeMachine.cWater + " ml of water");
        System.out.println(CoffeeMachine.CoC * CoffeeMachine.cMilk + " ml of milk");
        System.out.println(CoffeeMachine.CoC * CoffeeMachine.cCoffeeB + " g of coffee beans");

    }
   static public void check() {
       if (CoffeeMachine.cWater <= CoffeeMachine.iWater) {
           if (CoffeeMachine.cMilk <= CoffeeMachine.iMilk) {
               if (CoffeeMachine.cCoffeeB <= CoffeeMachine.iCoffeeB) {
                   if (CoffeeMachine.iCups >= CoffeeMachine.CoC) {
                       System.out.println("I have enough resources, making you a coffee!");
                       makeCoffee();
                   } else System.out.println("Sorry, not enough cups!");
               } else System.out.println("Sorry, not enough coffee beans!");
           } else System.out.println("Sorry, not enough milk!");
       } else System.out.println("Sorry, not enough water!");
   }
    static public void espresso() {
        CoffeeMachine.cWater = 250;
        CoffeeMachine.cCoffeeB = 16;
        CoffeeMachine.cCost = 4;
        check();
    }
    static public void latte() {
        CoffeeMachine.cWater = 350;
        CoffeeMachine.cMilk = 75;
        CoffeeMachine.cCoffeeB = 20;
        CoffeeMachine.cCost = 7;
        check();
    }
    static public void cappuccino() {
        CoffeeMachine.cWater = 200;
        CoffeeMachine.cMilk = 100;
        CoffeeMachine.cCoffeeB = 12;
        CoffeeMachine.cCost = 6;
        check();
    }
    static public void makeCoffee() {
        CoffeeMachine.iWater -= CoffeeMachine.cWater;
        CoffeeMachine.iMilk -= CoffeeMachine.cMilk;
        CoffeeMachine.iCoffeeB -= CoffeeMachine.cCoffeeB;
        CoffeeMachine.iCups -= CoffeeMachine.CoC;
        CoffeeMachine.iMoney += CoffeeMachine.cCost;
    }
    static public void takeFromMachine() {
        System.out.println();
        System.out.println("I gave you $" + iMoney);
        iMoney -= iMoney;
    }
    static public void storageMachine() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(CoffeeMachine.iWater + " ml of water");
        System.out.println(CoffeeMachine.iMilk + " ml of milk");
        System.out.println(CoffeeMachine.iCoffeeB + " g of coffee beans");
        System.out.println(CoffeeMachine.iCups + " disposable cups");
        System.out.println("$" + CoffeeMachine.iMoney + " of money");
    }

    static public void addToMachine() {
        System.out.println("Write how many ml of water you want to add:  ");
        int addedWater = sc.nextInt();
        CoffeeMachine.iWater += addedWater;
        System.out.println("Write how many ml of milk you want to add:  ");
        int addedMilk = sc.nextInt();
        CoffeeMachine.iMilk += addedMilk;
        System.out.println("Write how many grams of coffee beans you want to add:  ");
        int addedCoffeeB = sc.nextInt();
        CoffeeMachine.iCoffeeB += addedCoffeeB;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addedCups = sc.nextInt();
        CoffeeMachine.iCups += addedCups;
    }
    static public void coffeeMake() {
        boolean space = true;
        int waterForCoC = CoffeeMachine.CoC * CoffeeMachine.cWater;
        int milkForCoC = CoffeeMachine.CoC * CoffeeMachine.cMilk;
        int cBeansForCoC = CoffeeMachine.CoC * CoffeeMachine.cCoffeeB;
        int moreWater = CoffeeMachine.iWater - waterForCoC;
        int moreMilk = CoffeeMachine.iMilk - milkForCoC;
        int moreCoffeeB = CoffeeMachine.iCoffeeB  - cBeansForCoC;
        int moreCoC = 0;
        if (CoffeeMachine.CoC >= 0) {
            if (CoffeeMachine.iWater <= waterForCoC || CoffeeMachine.iMilk <= milkForCoC || CoffeeMachine.iCoffeeB <= cBeansForCoC) {
                while (space) {
                    if (CoffeeMachine.iWater > CoffeeMachine.cWater) {
                        CoffeeMachine.iWater -= CoffeeMachine.cWater;
                        if (CoffeeMachine.iMilk > CoffeeMachine.cMilk) {
                            CoffeeMachine.iMilk -= CoffeeMachine.cMilk;
                            if (CoffeeMachine.iCoffeeB > CoffeeMachine.cCoffeeB) {
                                moreCoC += 1;
                                CoffeeMachine.iCoffeeB -= CoffeeMachine.cCoffeeB;
                            } else {
                                space = false;
                            }
                        } else {
                            space = false;
                        }
                    } else {
                        space = false;
                    }
                }
                System.out.println("No, I can make only " + moreCoC + " cup(s) of coffee");
                }

            if (CoffeeMachine.iWater >= waterForCoC) {
                if (CoffeeMachine.iMilk >= milkForCoC) {
                    if (CoffeeMachine.iCoffeeB >= cBeansForCoC) {
                        while (space) {
                            if (moreWater >= CoffeeMachine.cWater) {
                                moreWater -= CoffeeMachine.cWater;
                                if (moreMilk >= CoffeeMachine.cMilk) {
                                    moreMilk -= CoffeeMachine.cMilk;
                                    if (moreCoffeeB >= CoffeeMachine.cCoffeeB) {
                                        moreCoC += 1;
                                        moreCoffeeB -= CoffeeMachine.cCoffeeB;
                                    } else {
                                        space = false;
                                    }
                                } else {
                                    space = false;
                                }
                            } else {
                                space = false;
                            }
                        }
                        if (moreCoC == 0) {
                            if (CoffeeMachine.CoC == 0) {
                                System.out.println("Yes, I can make that amount of coffee");
                            }else if (CoffeeMachine.CoC == 1) {
                                System.out.println("Yes, I can make that amount of coffee");
                            }else if (CoffeeMachine.CoC > 1) {
                                System.out.println("Yes, I can make that amount of coffee");
                            }else {
                                System.out.println("No, I can make only " + moreCoC + " cup(s) of coffee");
                            }
                        } else {
                            if (CoffeeMachine.CoC == 0) {
                                System.out.println("Yes, I can make that amount of coffee (and even " + moreCoC + " more than that)");
                            }else if (CoffeeMachine.CoC == 1) {
                                System.out.println("Yes, I can make that amount of coffee(and even " + moreCoC + " more than that)");
                            }else if (CoffeeMachine.CoC > 1) {
                                System.out.println("Yes, I can make that amount of coffee (and even " + moreCoC + " more than that)");
                            }else {
                                System.out.println("No, I can make only " + moreCoC + " cup(s) of coffee");
                            }
                        }

                    }
                }
            }
        }


    }
}
