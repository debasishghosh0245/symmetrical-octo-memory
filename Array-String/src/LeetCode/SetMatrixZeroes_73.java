import java.util.*;
public class SetMatrixZeroes_73{
    public static void main(String[] args){
        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZero(matrix);
    }
    public static void setMatrixZero(int[][] matrix){
        int[][] result=new int[matrix.length][matrix[0].length];
        for(int[] arr:result){
            Arrays.fill(arr,-1);
        }
        //Arrays.fill(result,-1);
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(matrix[row][col]==0){
                    markRowColZero(result,row,col);
                }else if(result[row][col]==-1){
                    result[row][col]=matrix[row][col];
                }
            }
        }
        for(int row=0;row<result.length;row++){
            for(int col=0;col<result[0].length;col++){
                System.out.print(result[row][col]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void markRowColZero(int[][] result,int row,int col){
        //up
        for(int i=row,j=col;i>=0;i--){
            result[i][j]=0;
        }
        //down
        for(int i=row,j=col;i<result.length;i++){
            result[i][j]=0;
        }
        //left
        for(int i=row,j=col;j>=0;j--){
            result[i][j]=0;
        }
        //right
        for(int i=row,j=col;j<result[row].length;j++){
            result[i][j]=0;
        }
    }
}
