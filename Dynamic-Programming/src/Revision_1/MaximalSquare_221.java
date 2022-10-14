public class MaximalSquare_221{

    public static void main(String[] args){
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'}};
        // {'1','1','1','1','1'},{'1','0','0','1','0'}};
        //char[][] matrix={{'0','1'}};
        //char[][] matrix={{'0','0','0','0','0'},{'0','0','0','0','0'},{'0','0','0','0','1'},{'0','0','0','0','0'}};
        //char[][] matrix={{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}};
        int max=maximumSquare_helper_dp(matrix);
        System.out.println("Max Area -- "+(max*max));
    }

    // public static int maximumSquare_helper(char[][] matrix,int row,int col){
    //     int right=matrix[row][col+1];
    //     int bottom=matrix[row+1][col];
    //     int rightdiagonal=matrix[row+1][col+1];
    //     if(row < 0) return;
    //     for(int col=0;col<matrix[row].length;col++){
    //             int min=Integer.MAX_VALUE;
    //             if(row+1 < matrix.length){
    //                 min=Math.min(min,matrix[row+1][col]-'0');
    //             }
    //             if(col+1 < matrix[row].length){
    //                 min=Math.min(min,matrix[row][col]-'0');
    //             }
    //             if(row+1 < matrix.length && col+1 < matrix[row].length){
    //                 min=Math.min(min,matrix[row+1][col+1]-'0');
    //             }
    //             //System.out.println("min .."+min);
    //             max=Math.max(min+1,max);
    //             matrix[row][col]=(char)(min+1+'0');
    //
    //     }
    //     maximumSquare_helper(matrix,row-1);
    // }

    public static int maximumSquare_helper_dp(char[][] matrix){
        int max=Integer.MIN_VALUE;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int row=rows-1;row>=0;row--){
            for(int col=cols-1;col>=0;col--){
                if(row==rows-1 || col==cols-1){
                    dp[row][col]=matrix[row][col]-'0';
                    max=Math.max(max,dp[row][col]);
                }else{
                    if(matrix[row][col]=='1'){
                        int right=0,bottom=0,rightdiagonal=0;
                        if(col+1<matrix[row].length){
                            right=dp[row][col+1];
                        }
                        if(row+1<matrix.length){
                            bottom=dp[row+1][col];
                        }
                        if(row+1<matrix.length && col+1<matrix[row].length){
                            rightdiagonal=dp[row+1][col+1];
                        }
                        int min=Integer.MAX_VALUE;
                        min=Math.min(right,bottom);
                        min=Math.min(min,rightdiagonal);
                        dp[row][col]=(matrix[row][col]-'0')+min;
                        max=Math.max(max,dp[row][col]);
                    }else{
                        dp[row][col]=0;
                    }
                }
            }
        }
        return max;
    }
}
