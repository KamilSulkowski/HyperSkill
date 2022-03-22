package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static boolean exit = true;
    static int tickets = 0;
    static double percent;
    static boolean bought = false;
    static int totalPrice;
    static int income = 0;
    static public int n;
    static public int m;
    static public int x;
    static public int y;
    static char[][] array;
    static int amount;
    public static void main(String[] args) {
        menuCinema();
        fill();
        while (exit) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 0:
                    exit = false;
                    break;
                case 1:
                    readRoom();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    stats();
                    break;
                case 4:

                    break;
            }
        }
    }
    public static void stats() {
        amount = n * m;
        totalPrice = 0;
        System.out.println("Number of purchased tickets: " + tickets);
        System.out.println("Percentage: " + String.format("%.2f",percent) + "%");
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + totalIncome());

    }
    public static void menuCinema() {
        System.out.println("Enter the number of rows:");
        n = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        m = sc.nextInt();
    }
    public static void buyTicket() {
        boolean ask = true;
        while (ask) {
        System.out.println();
        System.out.println("Enter a row number:");
        x = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            y = sc.nextInt();
            try {
                if (array[x-1][y-1] == 'B') {
                    System.out.println();
                    System.out.println("That ticket has already been purchased!");
                } else {
                    ask = false;
                    bought = true;
                    purchasedTickets();
                    incomeFromTicket();
                    percent = (float) tickets / amount;
                    percent *= 100;
                    array[x-1][y-1] = 'B';
                    bought = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!");
            }
        }

        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice());
        System.out.println();
    }
    public static void askAgain() {
        System.out.println("Enter a seat number in that row:");
        y = sc.nextInt();
    }
    static public void readRoom() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= m; i++) {
            System.out.print( i + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    static public void fill() {
        array = new char[n][m];
        for (char[] chars : array) {
            Arrays.fill(chars, 'S');
        }
    }
    static public int ticketPrice() {
        int ticketP = 0;
        amount = n * m;
        if (amount < 60){
            ticketP = 10;
        }
        if (amount > 60) {
            if (x <= 4) {
                ticketP = 10;
            }else {
                ticketP = 8;
            }
        }
        return ticketP;
    }
    static public void incomeFromTicket() {
        int ticketP;
        amount = n * m;
        if (amount < 60){
            ticketP = 10;
            income = income + ticketP;
        }
        if (amount > 60) {
            if (x <= 4) {
                ticketP = 10;
            }else {
                ticketP = 8;
            }
            income = income + ticketP;
        }
    }
    static public void purchasedTickets() {
        if (bought) {
            tickets++;
        }
    }
    static public int totalIncome() {
        int halfN = 0;
        int halfPrice;
        int nextHalfPrice;
        int ticketP;
        totalPrice = 0;
        amount = n * m;
        if (amount < 60){
            ticketP = 10;
            totalPrice = amount * ticketP;
        }
        if (amount > 60) {
            if (n % 2 == 0){
                halfN  = n/2;
            }
            if (n % 2 != 0) {
                halfN  = (n/2);
            }
            ticketP = 10;
            halfPrice = (halfN * m) * ticketP;
            if (n % 2 != 0) {
                ++halfN;
            }
            ticketP = 8;
            nextHalfPrice = (halfN * m) * ticketP;
            totalPrice = nextHalfPrice + halfPrice;
        }
        return totalPrice;
    }

}
