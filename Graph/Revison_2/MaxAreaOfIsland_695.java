public class MaxAreaOfIsland_695{

    public static void main(String[] args){
        //char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int[][] grid={{1,0,1},{1,1,1},{0,0,1}};
        int maxArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    currArea=1;
                    findIsland(grid,i,j);
                    maxArea=Math.max(currArea,maxArea);
                }
            }
        }
        System.out.println("Maximum Area of Island "+maxArea);
    }

    static int currArea=0;
    static int[][] directions={{0,-1},{-1,0},{1,0},{0,1}};
    public static void findIsland(int[][] grid,int currRow,int currCol){
        grid[currRow][currCol]=0;
        for(int[] direction: directions){
            int nbrRow=currRow+direction[0];
            int nbrCol=currCol+direction[1];
            if(nbrRow < 0 || nbrRow >= grid.length || nbrCol < 0
                || nbrCol >= grid[0].length
                || grid[nbrRow][nbrCol]==0){
                    continue;
            }else{
                currArea++;
                findIsland(grid,nbrRow,nbrCol);
            }
        }
    }
}
