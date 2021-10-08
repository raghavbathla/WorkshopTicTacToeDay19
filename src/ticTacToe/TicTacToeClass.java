package ticTacToe;

import java.util.Scanner;

public class TicTacToeClass {
    private char board[] = new char[10];
    private char user;
     private char computer;
     private char[] assign() {

        for (int i = 1; i <= board.length - 1; i++) {
            board[i] = ' ';
        }
        return board;
    }

     private void askUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose between X or O");

        System.out.println("Enter X for X or O for O");
        user = scanner.next().charAt(0);
        if (user == 'X')
            computer = 'O';
        else {
            user = 'O';
            computer = 'X';
        }
    }

}
