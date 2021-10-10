package ticTacToe;

public class TicTacMain {
    public static void main(String[] args) {
TicTacToeClass ticTacToeClass = new TicTacToeClass();
ticTacToeClass.askUser();
char [] board = ticTacToeClass.assign();
char user = ticTacToeClass.user;
char computer = ticTacToeClass.computer;
ticTacToeClass.showBoard(board);
ticTacToeClass.firstMove(board,user,computer);
ticTacToeClass.showBoard(board);
ticTacToeClass.startGame(board,user,computer);


    }
}
