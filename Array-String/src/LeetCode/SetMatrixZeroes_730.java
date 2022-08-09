import java.util.*;
public class SetMatrixZeroes_730{
    public static void main(String[] args){
        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        //int[][] matrix={{1,1,2,6},{3,0,5,2},{1,3,1,5}};
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZero(matrix);
    }
    public static void setMatrixZero(int[][] matrix){
        int R=matrix.length;
        int C=matrix[0].length;
        boolean isFastRow=false;
        boolean isFastCol=false;
        for(int row=0;row<R;row++){
            if(matrix[row][0]==0){
                isFastCol=true;
            }
        }
        for(int col=0;col<C;col++){
            if(matrix[0][col]==0){
                isFastRow=true;
            }
        }
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(matrix[row][col]==0){
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }
        //col 0
        for(int row=1;row<R;row++){
            if(matrix[row][0]==0){
                for(int col=1;col<C;col++){
                    matrix[row][col]=0;
                }
            }
        }
        //row 0
        for(int col=1;col<C;col++){
            if(matrix[0][col]==0){
                for(int row=1;row<R;row++){
                    matrix[row][col]=0;
                }
            }
        }
        if(isFastCol){
            for(int row=0;row<R;row++){
                matrix[row][0]=0;
            }
        }
        if(isFastRow){
            for(int col=0;col<C;col++){
                matrix[0][col]=0;
            }
        }
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println(" ");
        }
    }
}
