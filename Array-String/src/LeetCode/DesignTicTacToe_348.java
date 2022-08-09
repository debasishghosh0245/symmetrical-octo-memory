import java.util.*;
public class DesignTicTacToe_348{
    public static void main(String[] args){
        // TicTacToe tic=new TicTacToe(3);
        // System.out.println(tic.move(0,0,1));
        // System.out.println(tic.move(0,2,2));
        // System.out.println(tic.move(2,2,1));
        // System.out.println(tic.move(1,1,2));
        // System.out.println(tic.move(2,0,1));
        // System.out.println(tic.move(1,0,2));
        // System.out.println(tic.move(2,1,1));
        TicTacToe tic=new TicTacToe(2);
        System.out.println(tic.move(0,1,1));
        System.out.println(tic.move(1,1,2));
        System.out.println(tic.move(1,0,1));
        int[][] board=tic.board;
        for(int[] arr: board){
            System.out.println(Arrays.toString(arr));
        }
    }
}
class TicTacToe{
    int[][] board=null;
    public TicTacToe(int n){
        board=new int[n][n];
    }
    public int move(int row,int col,int player){
        board[row][col]=player;
        if(isWinner(row,col,player)) {
            return player;
        }
        else {
            return 0;
        }
    }
    public boolean isWinner(int row,int col,int player){
        boolean horizontal=false;
        boolean vertical=false;
        boolean diagonal=false;
        boolean antidiagonal=false;
        //Vertical
        for(int i=0,j=col;i<board.length;i++){
            if(board[i][j]!=player) {
                vertical=false;
                break;
            }else{
                vertical=true;
            }
        }
        //Horizontal
        for(int i=row,j=0;j<board[0].length;j++){
            if(board[i][j]!=player) {
                horizontal=false;
                break;
            }else{
                horizontal=true;
            }
        }
        //Diagonal
        for(int i=0;i<board.length;i++){
            if(board[i][i]!=player) {
                diagonal=false;
                break;
            }else{
                diagonal=true;
            }
        }
        //Anti diagonal
        for(int i=0;i<board.length;i++){
            if(board[i][board.length-i-1]!=player) {
                antidiagonal=false;
                break;
            }
            else{
                antidiagonal=true;
            }
        }
        // System.out.println("Horizontal >>"+horizontal);
        // System.out.println("antidiagonal >>"+antidiagonal);
        // System.out.println("Diagonal >>"+diagonal);
        // System.out.println("Vertical >>"+vertical);
        return antidiagonal || diagonal|| horizontal || vertical;
    }
}
