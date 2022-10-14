public class NumberOfEnclaves_1020{
    public static void main(String[] args){
        //int[][] grid={{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int[][] grid={{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==1
                    && (row==0 || row==(grid.length-1)
                    || col==0 || col==(grid[row].length-1))){
                    numberOfEnclaves(grid,row,col);
                }
            }
        }
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==1
                    && row!=0 && row!=(grid.length-1)
                    && col!=0 && col!=(grid[row].length-1)){
                    if(grid[row][col]==1) moves++;
                }
            }
        }
        System.out.println("Number of Moves "+moves);
    }
    static int moves=0;
    static int[][] directions={{-1,0},{0,1},{0,-1},{1,0}};
    public static void numberOfEnclaves(int[][] grid,int currRow,int currCol){
        grid[currRow][currCol]=0;
        for(int[] direction: directions){
            int nbrRow=direction[0]+currRow;
            int nbrCol=direction[1]+currCol;
            if(nbrRow < 0 || nbrRow >= grid.length || nbrCol < 0 || nbrCol >= grid[currRow].length
                || grid[nbrRow][nbrCol]==0){
                continue;
            }else{
                numberOfEnclaves(grid,nbrRow,nbrCol);
            }
        }
    }
}
