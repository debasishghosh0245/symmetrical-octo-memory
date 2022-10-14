import java.util.*;
public class MaximumMatrixSum_1975{
    public static void main(String[] args){
        //int[][] matrix={{1,2,3},{-1,-2,-3},{1,2,3}};
        int[][] matrix={{-1,0,-1},{-2,1,3},{3,2,2}};
        //int[][] matrix={{1,-1},{-1,1}};
        System.out.println(maxMatrixSum(matrix));
    }
    public static long maxMatrixSum(int[][] matrix) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        int countNegative=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                min=Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0) {
                    countNegative++;
                }
                sum+=Math.abs(matrix[i][j]);
            }
        }
        System.out.println("Sum "+sum+"min "+min);
        if(countNegative%2!=0){
            return sum-Math.abs(min)-Math.abs(min);
        }
        return sum;
    }
}
