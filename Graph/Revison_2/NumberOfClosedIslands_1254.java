public class NumberOfClosedIslands_1254{

    public static void main(String[] args){
        //int[][] grid={{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0}
        //,{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] grid={{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        //boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==0
                    && (row==0 || row==(grid.length-1)
                    || col==0 || col==(grid[row].length-1))){
                    numberOfClosedIslands(grid,row,col);
                }
            }
        }
        // for(int row=0;row<grid.length;row++){
        //     for(int col=0;col<grid[row].length;col++){
        //         System.out.print(grid[row][col]+" ");
        //     }
        //     System.out.println("");
        // }
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]==0
                    && row!=0 && row!=(grid.length-1)
                    && col!=0 && col!=(grid[row].length-1)){
                    count++;
                    numberOfClosedIslands(grid,row,col);
                }
            }
        }
        System.out.println("Number of Closed Island "+count);
    }

    static int[][] directions={{-1,0},{0,1},{0,-1},{1,0}};
    public static void numberOfClosedIslands(int[][] grid,int currRow,int currCol){
        grid[currRow][currCol]=1;
        for(int[] direction: directions){
            int nbrRow=direction[0]+currRow;
            int nbrCol=direction[1]+currCol;
            if(nbrRow < 0 || nbrRow >= grid.length || nbrCol < 0 || nbrCol >= grid[currRow].length
                || grid[nbrRow][nbrCol]==1){
                continue;
            }else{
                //System.out.println("Neighbour Row >>"+nbrRow);
                //System.out.println("Neighbour Column >>"+nbrCol);
                numberOfClosedIslands(grid,nbrRow,nbrCol);
            }
        }
    }
}
