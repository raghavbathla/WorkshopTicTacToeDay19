package ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeClass {
    private boolean running = true;
    private char board[] = new char[10];
    public char user;
    private int count = 1;
    public char computer;
    public String winner;
    public boolean turn;
    Random random = new Random();

    public char[] assign() {

        for (int i = 1; i <= board.length - 1; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public void askUser() {
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

    private void makeMove(char[] board, char user) {
        System.out.println("Enter the position from 1 to 9");

        boolean val = true;
        while (val) {
            Scanner scanner = new Scanner(System.in);
            int move = scanner.nextInt();
            System.out.println("Enter the position from 1 to 9");
            if (board[move] == ' ') {
                board[move] = user;
                val = false;
            } else {
                System.out.println("Not empty");
            }
        }

    }

    private boolean firstChance() {

        System.out.println("Enter 0 for Head or 1 for  tails");
        Scanner sc = new Scanner(System.in);
        int choosen = sc.nextInt();
        int num = random.nextInt(2);
        if (num == choosen) {
            turn = true;
            System.out.println("User Wins , Do your first chance");
            return true;

        } else {
            turn = false;
            System.out.println("Computer Wins");
            return false;
        }
    }

    public void firstMove(char[] board, char user, char computer) {

        if (firstChance()) {
            makeMove(board, user);
            turn = false;
            showBoard(board);
        } else {
            int randomNum = random.nextInt(9) + 1;
            board[randomNum] = computer;
            turn = true;
            showBoard(board);
        }
    }

    public void showBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
    }

    public void startGame(char[] board, char user, char computer) {
        while (running) {


            if (turn) {
                makeMove(board, user);
                turn = false;
                count++;
                checkWinner(board);
                showBoard(board);
            } else {
                computerTurn(board, computer, user);
                turn = true;
                count++;
                checkWinner(board);
                showBoard(board);
            }
        }
        System.out.println("The winner is :-" + winner);

    }

    public void computerTurn(char[] board, char computer, char user) {
        int arr[] = new int[3];
        boolean nDone = true;
        String compWin = new StringBuilder().append(computer).append(computer).append(' ').toString();
        String compWin1 = new StringBuilder().append(' ').append(computer).append(computer).toString();
        String compWin2 = new StringBuilder().append(computer).append(' ').append(computer).toString();
        String userWin = new StringBuilder().append(user).append(user).append(' ').toString();
        String userWin1 = new StringBuilder().append(user).append(' ').append(user).toString();
        String userWin2 = new StringBuilder().append(' ').append(user).append(user).toString();

        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = new StringBuilder().append(board[1]).append(board[2]).append(board[3]).toString();
                    arr[0] = 1;
                    arr[1] = 2;
                    arr[2] = 3;
                    break;
                case 1:
                    line = new StringBuilder().append(board[4]).append(board[5]).append(board[6]).toString();
                    arr[0] = 4;
                    arr[1] = 5;
                    arr[2] = 6;
                    break;
                case 2:
                    line = new StringBuilder().append(board[7]).append(board[8]).append(board[9]).toString();
                    arr[0] = 7;
                    arr[1] = 8;
                    arr[2] = 9;
                    break;
                case 3:
                    line = new StringBuilder().append(board[1]).append(board[4]).append(board[7]).toString();
                    arr[0] = 1;
                    arr[1] = 4;
                    arr[2] = 7;
                    break;
                case 4:
                    line = new StringBuilder().append(board[2]).append(board[5]).append(board[8]).toString();
                    arr[0] = 2;
                    arr[1] = 5;
                    arr[2] = 8;
                    break;
                case 5:
                    line = new StringBuilder().append(board[3]).append(board[6]).append(board[9]).toString();
                    arr[0] = 3;
                    arr[1] = 6;
                    arr[2] = 9;
                    break;
                case 6:
                    line = new StringBuilder().append(board[1]).append(board[5]).append(board[9]).toString();
                    arr[0] = 1;
                    arr[1] = 5;
                    arr[2] = 9;
                    break;
                case 7:
                    line = new StringBuilder().append(board[3]).append(board[5]).append(board[7]).toString();
                    arr[0] = 3;
                    arr[1] = 5;
                    arr[2] = 7;
                    break;
            }
            if (nDone) {
                if (line.equals(compWin) || line.equals(compWin1) || line.equals(compWin2)) {

                    for (int j : arr) {
                        if (board[j] == ' ') {
                            board[j] = computer;
                            nDone = false;
                        }
                    }
                }
            }


            if (nDone) {
                if (line.equals(userWin) || line.equals(userWin1) || line.equals(userWin2)) {
                    for (int j : arr) {
                        if (board[j] == ' ') {
                            board[j] = computer;
                            nDone = false;
                        }
                    }

                }
            }

        }
        if (nDone) {
            while (true) {
                int ran = random.nextInt(9) + 1;
                if (board[ran] == ' ') {
                    board[ran] = computer;
                    break;
                }


            }
        }
    }


    private void checkWinner(char[] board) {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = new StringBuilder().append(board[1]).append(board[2]).append(board[3]).toString();
                    break;
                case 1:
                    line = new StringBuilder().append(board[4]).append(board[5]).append(board[6]).toString();
                    break;
                case 2:
                    line = new StringBuilder().append(board[7]).append(board[8]).append(board[9]).toString();
                    break;
                case 3:
                    line = new StringBuilder().append(board[1]).append(board[4]).append(board[7]).toString();
                    break;
                case 4:
                    line = new StringBuilder().append(board[2]).append(board[5]).append(board[8]).toString();
                    break;
                case 5:
                    line = new StringBuilder().append(board[3]).append(board[6]).append(board[9]).toString();
                    break;
                case 6:
                    line = new StringBuilder().append(board[1]).append(board[5]).append(board[9]).toString();
                    break;
                case 7:
                    line = new StringBuilder().append(board[3]).append(board[5]).append(board[7]).toString();
                    break;
            }
            if (line.equals("XXX")) {
                winner = "X";
                running = false;
            } else if (line.equals("OOO")) {
                winner = "O";
                running = false;
            }
        }
        if (running) {
            if (count == 9) {
                winner = "Draw";
                running = false;
            }
        }

    }


}
