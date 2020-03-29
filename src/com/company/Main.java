package com.company;

public class Main {

    public static void main(String[] args) {
        // Here is saved the player who is on the move (0 or 1)
	    int turn = 0;
        // Here is saved the winner
        int winner = -1;
        // Here is saved the game board with 9 positions
        int[] board = new int[9];
        for(int i = 0; i < board.length; i++){
            board[i] = -1;
        }
        // define players
        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;

        // Play as long as there is no winner
        while(winner == -1){
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].validateTurn(board, turnField)){
                board[turnField] = players[turn].number;
                turn = (turn + 1) % 2;
            }
            winner = checkWinner(board);
        }
        System.out.println("Congrats Player " + winner + ", you won!");
    }

    public static int checkWinner(int[] board){
        // Check which player won
        int winner = -1;

        // horizontal
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != -1){
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != -1){
            winner = board[6];
        }
        // vertical
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != -1){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != -1){
            winner = board[2];
        }
        // diagonal
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
        }
        else if(board[2] == board[4] && board[2] == board[6] && board[2] != -1) {
            winner = board[2];
        }
        else{
            winner = -1;
        }
        return winner;
    }

    public static void printBoard(int[] myBoard){
        // The game board is shown here
        System.out.println(myBoard[0] + " | " + myBoard[1] + " | " + myBoard[2]);
        System.out.println("____________");
        System.out.println(myBoard[3] + " | " + myBoard[4] + " | " + myBoard[5]);
        System.out.println("____________");
        System.out.println(myBoard[6] + " | " + myBoard[7] + " | " + myBoard[8]);
    }
}
