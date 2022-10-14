public class NumberOfIslands_200 {

    public static void main(String[] args){
        //char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid= {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    findIsland(grid,i,j);
                }
            }
        }
        System.out.println("Number of Island "+count);
    }
    static int[][] directions={{0,-1},{-1,0},{1,0},{0,1}};
    public static void findIsland(char[][] grid,int currRow,int currCol){
        grid[currRow][currCol]='0';
        for(int[] direction: directions){
            int nbrRow=currRow+direction[0];
            int nbrCol=currCol+direction[1];
            if(nbrRow < 0 || nbrRow >= grid.length || nbrCol < 0
                || nbrCol >= grid[0].length
                || grid[nbrRow][nbrCol]=='0'){
                    continue;
            }else{
                // System.out.println("Row "+nbrRow);
                // System.out.println("Column "+nbrCol);
                findIsland(grid,nbrRow,nbrCol);
            }
        }
    }
}
