package LLDFamousQuestions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import LLDFamousQuestions.TicTacToeDesign.Model.Board;
import LLDFamousQuestions.TicTacToeDesign.Model.Piece;
import LLDFamousQuestions.TicTacToeDesign.Model.PieceX;
import LLDFamousQuestions.TicTacToeDesign.Model.PieceY;
import LLDFamousQuestions.TicTacToeDesign.Model.Player;
import javafx.util.Pair;

public class TicTacToeGame {
    public Board gameBoard;
    Deque<Player> players;

    public void initializeGame(){
        players=new LinkedList<>();
        Player xPlayer=new Player("Keshav", new PieceX());
        Player oPlayer=new Player("Rahul",new PieceY());
        players.add(oPlayer);
        players.add(xPlayer);
        gameBoard=new Board(3);
    }

    public String startGame(){
        boolean status=true;
        while(status){
            Player playerTurn=players.removeFirst();
            gameBoard.printBoard();
            List<Pair<Integer,Integer>> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                status=false;
                continue;
            }
            
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully=gameBoard.addPiece(inputRow, inputColumn, playerTurn.getPiece());
            if(!pieceAddedSuccessfully){
                System.out.println("Incorret possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.getPiece().piecetype);
            if(winner){
                return playerTurn.name;
            }
        }
        return "Uff a tough Tie!!!" ;
    }

    public boolean isThereWinner(int row,int col, Piece playerPiece){
        boolean rowMatch=true;
        boolean columMatch=true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch=true;

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].piecetype !=playerPiece ){
                rowMatch=false;
            }
        }

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][col]==null || gameBoard.board[i][col].piecetype != playerPiece){
                columMatch = false;
            }
        }

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][i]==null || gameBoard.board[i][i].piecetype !=playerPiece){
                diagonalMatch = false;
            }
        }

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[(gameBoard.size-1)-i][(gameBoard.size-1)-i]==null || gameBoard.board[(gameBoard.size-1)-i][(gameBoard.size-1)-i].piecetype != playerPiece){
                antiDiagonalMatch = false;
            }
        }

        return rowMatch | columMatch | antiDiagonalMatch | diagonalMatch;
    }
}
