import java.util.*;
public class MinimumFallingPathSum_931{
    public static void main(String[] args){
        //int[][] matrix={{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix ={{-19,57},{-40,-5}};
        int ans=Integer.MAX_VALUE;
        for(int col=0;col<matrix.length;col++){
            ans=Math.min(ans,minFallingPathSum_recursion(matrix,0,col));
        }
        System.out.println(ans);
    }

    public static int minFallingPathSum_recursion(int[][] matrix,int row,int col){
        if(row >= matrix.length || col < 0 || col >= matrix[row].length){
            return Integer.MAX_VALUE;
        }
        if(row==matrix.length-1) return matrix[row][col];
        int bottom=minFallingPathSum_recursion(matrix,row+1,col);
        int leftDiagonal=minFallingPathSum_recursion(matrix,row+1,col-1);
        int rightDiagonal=minFallingPathSum_recursion(matrix,row+1,col+1);
        int min=Math.min(rightDiagonal,leftDiagonal);
        min=Math.min(min,bottom);
        return min+matrix[row][col];
    }

    public static int minFallingPathSum_DPII(int[][] matrix){
        int[] curr=new int[matrix.length];
        int[] prev=new int[curr.length];
        for(int row=matrix.length-1;row>=0;row--) {
            for(int col=0;col<matrix[row].length;col++){
                if(row==matrix.length-1){
                    curr[col]=matrix[row][col];
                }else{
                    int min=matrix[row][col]+prev[col];
                    if(col-1>=0){
                        min=Math.min(min,matrix[row][col]+prev[col-1]);
                    }
                    if(col+1<prev.length){
                        min=Math.min(min,matrix[row][col]+prev[col+1]);
                    }
                    curr[col]=min;
                }
            }
            prev=curr.clone();
        }
        int min=curr[0];
        for(int j=1;j<curr.length;j++){
            min=Math.min(min,curr[j]);
        }
        return min;
    }

    public static int minFallingPathSum_DP(int[][] matrix){
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int row=matrix.length-1;row>=0;row--) {
            for(int col=matrix.length-1;col>=0;col--){
                if(row==matrix.length-1){
                    dp[row][col]=matrix[row][col];
                }else{
                    int min=matrix[row][col]+dp[row+1][col];
                    if(col-1>=0){
                        min=Math.min(min,matrix[row][col]+dp[row+1][col-1]);
                    }
                    if(col+1<matrix[row].length){
                        min=Math.min(min,matrix[row][col]+dp[row+1][col+1]);
                    }
                    dp[row][col]=min;
                }
            }
        }
        int min=dp[0][0];
        for(int j=1;j<dp[0].length;j++){
            min=Math.min(min,dp[0][j]);
        }
        return min;
    }
}
