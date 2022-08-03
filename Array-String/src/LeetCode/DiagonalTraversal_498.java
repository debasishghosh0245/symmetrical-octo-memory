import java.util.*;
public class DiagonalTraversal_498{

    public static void main(String[] args){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        diagonalTraversal(matrix);
    }

    public static void diagonalTraversal(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            int row=0;
            int col=i;
            while(col>=0 && row<matrix[0].length){
                System.out.print(row+""+col+" ");
                row++;
                col--;
            }
            System.out.println("");
        }

        for(int i=0;i<matrix.length;i++){
            int row=matrix.length-1;
            int col=i;
            while(col>=0 && row<matrix[0].length){
                System.out.print(row+""+col+" ");
                row++;
                col--;
            }
            System.out.println("");
        }
    }

}
