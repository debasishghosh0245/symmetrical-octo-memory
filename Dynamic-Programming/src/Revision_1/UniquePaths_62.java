public class UniquePaths_62{

    public static void main(String[] args){
        System.out.println(uniquePaths_helper_dp(3,7));
    }

    public static int uniquePaths_helper_rec(int srcRow,int srcCol,int destRow,int destCol){
        if(srcRow > destRow || srcCol > destCol) return 0;
        if(srcRow==destRow && srcCol==destCol){
            return 1;
        }
        int rightCnt=uniquePaths_helper_rec(srcRow,srcCol+1,destRow,destCol);
        int downCnt=uniquePaths_helper_rec(srcRow+1,srcCol,destRow,destCol);
        return rightCnt+downCnt;
    }

    public static int uniquePaths_helper_dp(int destRow,int destCol){
        int[][] dp=new int[destRow][destCol];
        for(int row=dp.length-1;row>=0;row--){
            for(int col=dp[row].length-1;col>=0;col--){
                if(row==destRow-1 && col==destCol-1){
                    dp[row][col]=1;
                }else{
                    int rightCnt=0;
                    int downCnt=0;
                    if(col+1 < dp[row].length){
                        rightCnt=dp[row][col+1];
                    }
                    if(row+1 < dp.length){
                        downCnt=dp[row+1][col];
                    }
                    dp[row][col]=rightCnt+downCnt;
                }
            }
        }
        return dp[0][0];
    }
}
