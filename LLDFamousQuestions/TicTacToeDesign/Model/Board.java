package LLDFamousQuestions.TicTacToeDesign.Model;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair; 

public class Board {
    public int size;
    public PlayingPiece board[][];
    public Board(int size){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }
    public boolean addPiece(int row,int col,PlayingPiece piece){
        if(board[row][col]!=null)
            return false;
        board[row][col]=piece;
        return true;
    }
    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freeCells=new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair<Integer,Integer> locPair = new Pair<>(i,j);
                    freeCells.add(locPair);
                }
            }
        }
        return freeCells;
    }
    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                   System.out.print(board[i][j].piecetype.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }
}
