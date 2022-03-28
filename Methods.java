package machine;
public class Methods {
    static public void check() {
        if (Variables.cWater <= Variables.iWater) {
            if (Variables.cMilk <= Variables.iMilk) {
                if (Variables.cCoffeeB <= Variables.iCoffeeB) {
                    if (Variables.iCups >= Variables.CoC) {
                        System.out.println("I have enough resources, making you a coffee!");
                        makeCoffee();
                    } else System.out.println("Sorry, not enough cups!");
                } else System.out.println("Sorry, not enough coffee beans!");
            } else System.out.println("Sorry, not enough milk!");
        } else System.out.println("Sorry, not enough water!");
    }
    static public void espresso() {
        Variables.cWater = 250;
        Variables.cCoffeeB = 16;
        Variables.cCost = 4;
        check();
    }
    static public void latte() {
        Variables.cWater = 350;
        Variables.cMilk = 75;
        Variables.cCoffeeB = 20;
        Variables.cCost = 7;
        check();
    }
    static public void cappuccino() {
        Variables.cWater = 200;
        Variables.cMilk = 100;
        Variables.cCoffeeB = 12;
        Variables.cCost = 6;
        check();
    }
    static public void makeCoffee() {
        Variables.iWater -= Variables.cWater;
        Variables.iMilk -= Variables.cMilk;
        Variables.iCoffeeB -= Variables.cCoffeeB;
        Variables.iCups -= Variables.CoC;
        Variables.iMoney += Variables.cCost;
    }
    static public void takeFromMachine() {
        System.out.println();
        System.out.println("I gave you $" + Variables.iMoney);
        Variables.iMoney -= Variables.iMoney;
    }
    static public void storageMachine() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(Variables.iWater + " ml of water");
        System.out.println(Variables.iMilk + " ml of milk");
        System.out.println(Variables.iCoffeeB + " g of coffee beans");
        System.out.println(Variables.iCups + " disposable cups");
        System.out.println("$" + Variables.iMoney + " of money");
    }

    static public void addToMachine() {
        System.out.println("Write how many ml of water you want to add:  ");
        int addedWater = Variables.sc.nextInt();
        Variables.iWater += addedWater;
        System.out.println("Write how many ml of milk you want to add:  ");
        int addedMilk = Variables.sc.nextInt();
        Variables.iMilk += addedMilk;
        System.out.println("Write how many grams of coffee beans you want to add:  ");
        int addedCoffeeB = Variables.sc.nextInt();
        Variables.iCoffeeB += addedCoffeeB;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addedCups = Variables.sc.nextInt();
        Variables.iCups += addedCups;
    }
    static public void coffeeMake() {
        boolean space = true;
        int waterForCoC = Variables.CoC * Variables.cWater;
        int milkForCoC = Variables.CoC * Variables.cMilk;
        int cBeansForCoC = Variables.CoC * Variables.cCoffeeB;
        int moreWater = Variables.iWater - waterForCoC;
        int moreMilk = Variables.iMilk - milkForCoC;
        int moreCoffeeB = Variables.iCoffeeB  - cBeansForCoC;
        int moreCoC = 0;
        if (Variables.CoC >= 0) {
            if (Variables.iWater <= waterForCoC || Variables.iMilk <= milkForCoC || Variables.iCoffeeB <= cBeansForCoC) {
                while (space) {
                    if (Variables.iWater > Variables.cWater) {
                        Variables.iWater -= Variables.cWater;
                        if (Variables.iMilk > Variables.cMilk) {
                            Variables.iMilk -= Variables.cMilk;
                            if (Variables.iCoffeeB > Variables.cCoffeeB) {
                                moreCoC += 1;
                                Variables.iCoffeeB -= Variables.cCoffeeB;
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

            if (Variables.iWater >= waterForCoC) {
                if (Variables.iMilk >= milkForCoC) {
                    if (Variables.iCoffeeB >= cBeansForCoC) {
                        while (space) {
                            if (moreWater >= Variables.cWater) {
                                moreWater -= Variables.cWater;
                                if (moreMilk >= Variables.cMilk) {
                                    moreMilk -= Variables.cMilk;
                                    if (moreCoffeeB >= Variables.cCoffeeB) {
                                        moreCoC += 1;
                                        moreCoffeeB -= Variables.cCoffeeB;
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
                            if (Variables.CoC == 0) {
                                System.out.println("Yes, I can make that amount of coffee");
                            }else if (Variables.CoC == 1) {
                                System.out.println("Yes, I can make that amount of coffee");
                            }else if (Variables.CoC > 1) {
                                System.out.println("Yes, I can make that amount of coffee");
                            }else {
                                System.out.println("No, I can make only " + moreCoC + " cup(s) of coffee");
                            }
                        } else {
                            if (Variables.CoC == 0) {
                                System.out.println("Yes, I can make that amount of coffee (and even " + moreCoC + " more than that)");
                            }else if (Variables.CoC == 1) {
                                System.out.println("Yes, I can make that amount of coffee(and even " + moreCoC + " more than that)");
                            }else if (Variables.CoC > 1) {
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
