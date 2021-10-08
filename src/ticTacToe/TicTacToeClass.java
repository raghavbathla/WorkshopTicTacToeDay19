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
     private void showBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
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
