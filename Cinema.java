package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static int amount = 0;
    static public int n;
    static public int m;
    static char[][] array = new char[n][m];

    public static void main(String[] args) {
        menuCinema();
        fill();
        readRoom();
        sold();
    }
    public static void sold() {
        int halfN = 0;
        int halfPrice = 0;
        int nextHalfPrice = 0;
        int totalPrice = 0;
        int price = 0;
        if (n * m > 60) {
            if (n % 2 == 0){
                halfN  = n/2;
            }
            if (n % 2 != 0) {
                halfN  = (n/2);
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
            amount = n * m;
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
    static public void readRoom() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= m; i++) {
            System.out.print( i + " ");
        }
        System.out.println("DUPA");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Dupa2");
            System.out.print(i+1 + " ");
            for (int j = 0; j < m; j++) {
                System.out.println("DUPA3");
                System.out.print(array[i][j] + " ");
                System.out.println("DUPA4");
            }
            System.out.println("DUPA5");
            System.out.println();
        }
    }
    static public void fill() {
        for (char[] chars : array) {
            Arrays.fill(chars, 'S');
        }
    }
}
