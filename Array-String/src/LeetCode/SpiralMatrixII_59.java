public class SpiralMatrixII_59{

    public static void main(String[] args){
        int n=5;
        int[][] ans=sprialMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static int[][] sprialMatrix(int n){
        int[][] matrix=new int[n][n];
        int rowStart=0; int colStart=0; int rowEnd=n-1; int colEnd=n-1;
        int totalCnt=n*n+1; int currCnt=1;
        while(currCnt<totalCnt){
            //for top
            for(int i=rowStart,j=colStart;j<=colEnd && currCnt<totalCnt;j++){
                matrix[i][j]=currCnt++;
            }
            rowStart++;
            //for right
            for(int i=rowStart,j=colEnd;i<=rowEnd && currCnt<totalCnt;i++){
                matrix[i][j]=currCnt++;
            }
            colEnd--;
            //for bottom
            for(int j=colEnd,i=rowEnd;j>=colStart && currCnt<totalCnt;j--){
                matrix[i][j]=currCnt++;
            }
            rowEnd--;
            //for left
            for(int j=colStart,i=rowEnd;i>=rowStart && currCnt<totalCnt;i--){
                matrix[i][j]=currCnt++;
            }
            colStart++;
        }
        return matrix;
    }
}
