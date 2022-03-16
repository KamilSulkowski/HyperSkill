package tictactoe;

import java.util.Scanner;

public class Main {
    static int sumX = 0;
    static int sumO = 0;
    static boolean xWin = false;
    static boolean yWin = false;
    static boolean flag = true;

    static char[][] board;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Board
        createBoard();
        // Move
        while (check()) {
            moveX();
        }

    }
    public static void createBoard() {
        int n = 3;
        board = new char[n][n];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = ' ';
            }
        }
        board();
    }
    public static void moveX() {
        String sX;
        String sY;
        char Z;
        if (flag) {
            Z = 'X';
        }else {
            Z = 'O';
        }
        while (true) {
            System.out.print("Enter the coordinates: ");
            sX = sc.next();
            sY = sc.next();
            if (!isNumeric(sX) || !isNumeric(sY)) {
                System.out.println("You should enter numbers!");
            } else {
                int x = Integer.parseInt(sX);
                int y = Integer.parseInt(sY);

                if (x > 3 || y > 3 || x < 1 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                }else {
                    board[x - 1][y - 1] = Z;
                    flag = !flag;
                    break;
                }
            }
        }
        board();
    }
    public static void vertical() {
        for (int i = 0; i < board.length; i++) {
            sumX = 0;
            sumO = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'X') {
                    sumX++;
                    if (sumX == 3){
                        xWin = true;
                    }
                }
                if (board[j][i] == 'O') {
                    sumO++;
                    if (sumO == 3){
                        yWin = true;
                    }
                }
            }
        }
    }
    public static void horizontal() {
        for (int i = 0; i < board.length; i++) {
            sumX = 0;
            sumO = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'X') {
                    sumX++;
                    if (sumX == 3){
                        xWin = true;
                    }
                }
                if (board[i][j] == 'O') {
                    sumO++;
                    if (sumO == 3){
                        yWin = true;
                    }
                }
            }
        }
    }
    public static void diagonal() {
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            xWin = true;
        } else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            xWin = true;
        } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            yWin = true;
        } else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            yWin = true;
        }
    }
    public static boolean check() {
        // POZIOMO
        horizontal();
        // PIONOWO
        vertical();
        // PRZEKĄTNIE
        diagonal();
        int lenghX = 0;
        int lenghO = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'X') {
                    lenghX++;
                }
                if (board[i][j] == 'O') {
                    lenghO++;
                }
            }
        }
        if (xWin == true && yWin == true || Math.abs(lenghO - lenghX) > 1){
            System.out.println("Impossible");
            return false;
        } else if (xWin == true) {
            System.out.println("X wins");
            return false;
        } else if (yWin == true) {
            System.out.println("O wins");
            return false;
        }  else if (xWin == false && yWin == false && lenghO + lenghX == 9) {
            System.out.println("Draw");
            return false;
        }
        return true;
    }
    public static void board() {
        System.out.println("---------");
        for (int i = 0; i < board.length; i++){
            System.out.print("| ");
            for (int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.print("| \n");
        }
        System.out.println("---------");
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
