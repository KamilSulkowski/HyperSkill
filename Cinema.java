package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static boolean exit = true;
    static int tickets;
    static int totalPrice;
    static int income;
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
        income = 0;
        tickets = 0;
        totalPrice = 0;
        System.out.println("Number of purchased tickets: " + tickets);
        System.out.println("Percentage: ");
        System.out.println("Current income: " + income);
        System.out.println("Total income: $" + totalIncome());

    }

    public static void sold() {
        income = 0;
        tickets = 0;
        amount = n * m;
        int halfN = 0;
        int halfPrice = 0;
        int nextHalfPrice = 0;
        totalPrice = 0;
        int price = 0;
        if (amount > 60) {
            if (n % 2 == 0){
                halfN  = n/2;
            }
            price = 10;
            halfPrice = (halfN * m) * price;
            if (n % 2 != 0) {
                ++halfN;
            }
            price = 8;
            nextHalfPrice = (halfN * m) * price;
            totalPrice = nextHalfPrice + halfPrice;

        }else {
            if (amount < 60){
                price = 10;
                income += price;
                tickets += tickets;
            }
            totalPrice = amount * price;
        }

    }
    public static void menuCinema() {
        System.out.println("Enter the number of rows: ");
        n = sc.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        m = sc.nextInt();
    }
    public static void buyTicket() {
        System.out.println();
        System.out.println("Enter a row number: ");
        x = sc.nextInt();
        System.out.println("Enter a seat number in that row: ");
        y = sc.nextInt();
        try {
            if (array[x-1][y-1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                array[x-1][y-1] = 'B';

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input!");
        }
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice());
        System.out.println();
        readRoom();
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
            }else ticketP = 8;
        }
        return ticketP;
    }
    static public int purchasedTickets() {
        tickets  = 0;
        amount = n * m;
        if (amount < 60){
            ticketP = 10;
        }
        if (amount > 60) {
            if (x <= 4) {
                ticketP = 10;
            }else ticketP = 8;
        }
        return ticketP
    }
    static public int totalIncome() {
        int halfN = 0;
        int halfPrice = 0;
        int nextHalfPrice = 0;
        int ticketP = 0;
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
