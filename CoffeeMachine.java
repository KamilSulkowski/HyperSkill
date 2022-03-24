package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int CoC;
    static int cWater = 200;
    static int cMilk = 50;
    static int cCoffeeB = 15;
    static int iWater = 0;
    static int iMilk = 0;
    static int iCoffeeB = 0;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        storageMachine();
        coffeeMake();
        //calc();
        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/
    }
   /* static public void calc() {
        System.out.println("Write how many cups of coffee you will need:");
        CoffeeMachine.CoC = sc.nextInt();
        System.out.println("For " + CoffeeMachine.CoC + " cups of coffee you will need:");
        System.out.println(CoffeeMachine.CoC * CoffeeMachine.cWater + " ml of water");
        System.out.println(CoffeeMachine.CoC * CoffeeMachine.cMilk + " ml of milk");
        System.out.println(CoffeeMachine.CoC * CoffeeMachine.cCoffeeB + " g of coffee beans");

    }*/

    static public void storageMachine() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        CoffeeMachine.iWater = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        CoffeeMachine.iMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        CoffeeMachine.iCoffeeB = sc.nextInt();
    }
    static public void coffeeMake() {
        System.out.println("Write how many cups of coffee you will need: ");
        CoffeeMachine.CoC = sc.nextInt();
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
