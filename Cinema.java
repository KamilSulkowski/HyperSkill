package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static public int n;
    static public int m;
    static public int x;
    static public int y;
    static char[][] array;
    static int amount;
    public static void main(String[] args) {
        boolean exit = true;
        menuCinema();
        System.out.println("a");
        fill();
        System.out.println("v");
        while (exit) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
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
            }
        }

    }
    public static void sold() {
        amount = n * m;
        int halfN = 0;
        int halfPrice = 0;
        int nextHalfPrice = 0;
        int totalPrice = 0;
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
            }
            totalPrice = amount * price;
        }
        System.out.println("Total income: ");
        System.out.println("$"+totalPrice);
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
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice());
        System.out.println();
        boughtTicket();
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
    static public void boughtTicket() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= m; i++) {
            System.out.print( i + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < m; j++) {
                array[x-1][y-1] = 'B';
                array[x-1][y-1] = array[i][j];
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
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
}
