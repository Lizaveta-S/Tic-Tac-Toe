package tictactoe;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static char[][] cells = new char[3][3];
    public static boolean winner_X = false;
    public static boolean winner_O = false;
    public static boolean gameOn = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '_';
            }
        }

        printingField(cells);

        int column;
        int row;
        boolean cellIsEmpty;

        while (gameOn) {
            cellIsEmpty = true;
            while (cellIsEmpty) {
                System.out.println("Enter the coordinates: ");
                try {
                    column = scanner.nextInt();
                    row = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (column > 3 || row > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (row == 1) {
                    row = 2;
                } else if (row == 2) {
                    row = 1;
                } else {
                    row = 0;
                }

                if (cells[row][column - 1] == '_') {
                    if (k % 2 == 0) {
                        cells[row][column - 1] = 'X';
                    } else {
                        cells[row][column - 1] = 'O';
                    }
                    cellIsEmpty = false;
                    k++;
                    printingField(cells);
                    checkWinner(cells);

                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }

        }


    }

    public static void printingField(char[][] ch) {
        System.out.println("---------");
        System.out.println("| " + cells[0][0] + " " + cells[0][1] + " " + cells[0][2] + " |");
        System.out.println("| " + cells[1][0] + " " + cells[1][1] + " " + cells[1][2] + " |");
        System.out.println("| " + cells[2][0] + " " + cells[2][1] + " " + cells[2][2] + " |");
        System.out.println("---------");
    }

    public static void checkWinner(char[][] ch) {
        int counter_X = 0;
        int counter_O = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                if (ch[i][j] == 'X') {
                    counter_X++;
                } else if (ch[i][j] == 'O') {
                    counter_O++;
                }
            }
        }

        if(ch[0][0] == 'X' && ch[0][1] == 'X' && ch[0][2] == 'X' ||
                ch[1][0] == 'X' && ch[1][1] == 'X' && ch[1][2] == 'X' ||
                ch[2][0] == 'X' && ch[2][1] == 'X' && ch[2][2] == 'X' ||
                ch[0][0] == 'X' && ch[1][0] == 'X' && ch[2][0] == 'X' ||
                ch[0][1] == 'X' && ch[1][1] == 'X' && ch[2][1] == 'X' ||
                ch[0][2] == 'X' && ch[1][2] == 'X' && ch[2][2] == 'X' ||
                ch[0][0] == 'X' && ch[1][1] == 'X' && ch[2][2] == 'X' ||
                ch[0][2] == 'X' && ch[1][1] == 'X' && ch[2][0] == 'X') {
            winner_X = true;

        }
        if(ch[0][0] == 'O' && ch[0][1] == 'O' && ch[0][2] == 'O' ||
                ch[1][0] == 'O' && ch[1][1] == 'O' && ch[1][2] == 'O' ||
                ch[2][0] == 'O' && ch[2][1] == 'O' && ch[2][2] == 'O' ||
                ch[0][0] == 'O' && ch[1][0] == 'O' && ch[2][0] == 'O' ||
                ch[0][1] == 'O' && ch[1][1] == 'O' && ch[2][1] == 'O' ||
                ch[0][2] == 'O' && ch[1][2] == 'O' && ch[2][2] == 'O' ||
                ch[0][0] == 'O' && ch[1][1] == 'O' && ch[2][2] == 'O' ||
                ch[0][2] == 'O' && ch[1][1] == 'O' && ch[2][0] == 'O') {
            winner_O = true;

        }
        if (winner_O) {
            System.out.println("O wins");
            gameOn = false;
        } else if (winner_X) {
            System.out.println("X wins");
            gameOn = false;
        } else if(counter_O + counter_X == 9) {
            System.out.println("Draw");
            gameOn = false;
        }
    }
}
