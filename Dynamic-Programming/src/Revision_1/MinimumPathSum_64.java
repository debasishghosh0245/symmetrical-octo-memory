public class MinimumPathSum_64{

    public static void main(String[] args){
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        //int[][] grid={{1,2,3},{4,5,6}};
        System.out.println(minmumPathSum_helper_DPII(grid));
    }

    public static int minmumPathSum_helper_rec(int[][] grid,int row,int col){
        if(row >= grid.length || col >= grid[row].length ) {
            return Integer.MAX_VALUE;
        }
        int right=minmumPathSum_helper_rec(grid,row,col+1);
        int bottom=minmumPathSum_helper_rec(grid,row+1,col);
        if(right==Integer.MAX_VALUE && bottom==Integer.MAX_VALUE){
            return grid[row][col];
        }else{
            return grid[row][col]+Math.min(right,bottom);
        }
    }

    public static int minmumPathSum_helper_DP(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        for(int row=dp.length-1;row>=0;row--){
            for(int col=dp[row].length-1;col>=0;col--){
                if(row==dp.length-1 && col==dp[row].length-1) {
                    dp[row][col]=grid[row][col];
                }
                else{
                    int right=Integer.MAX_VALUE;
                    int bottom=Integer.MAX_VALUE;
                    if(col+1 < dp[row].length){
                        right=dp[row][col+1];
                    }
                    if(row+1 < dp.length) {
                        bottom=dp[row+1][col];
                    }
                    dp[row][col]=grid[row][col]+Math.min(right,bottom);
                }
            }
        }
        return dp[0][0];
    }

    public static int minmumPathSum_helper_DPII(int[][] grid){
        int[] curr=new int[grid[0].length];
        int[] prev=new int[grid[0].length];
        for(int row=grid.length-1;row>=0;row--){
            for(int col=grid[row].length-1;col>=0;col--){
                if(row==grid.length-1 && col==grid[row].length-1) {
                    curr[col]=grid[row][col];
                }
                else{
                    int right=Integer.MAX_VALUE;
                    int bottom=Integer.MAX_VALUE;
                    if(col+1 < grid[row].length){
                        right=curr[col+1];
                    }
                    if(row+1 < grid.length) {
                    	 bottom=prev[col];
                    }

                    curr[col]=grid[row][col]+Math.min(right,bottom);
                }
            }
            prev=curr.clone();
        }
        return curr[0];
    }
}
