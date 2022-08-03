public class WordSearch_79{
    public static void main(String[] args){
        // char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // String word="SEE";
        char[][] board={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word="AAB";
        boolean[][] visited=new boolean[board.length][board[0].length];
        int idx=0;
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==word.charAt(idx)){
                    visited[row][col]=true;
                    if(dfs(board,word,idx,row,col,visited)){
                        System.out.println(true);
                    }
                    visited[row][col]=false;
                }
            }
        }
        //System.out.println(false);
    }
    static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public static boolean dfs(char[][] board,String word,int idx,int row,int col,
        boolean[][] visited){
        if(idx+1>=word.length()) {
            return true;
        }
        for(int[] direction: directions){
            int nbrRow=row+direction[0];
            int nbrCol=col+direction[1];
            if(nbrRow < 0 || nbrRow >= board.length || nbrCol < 0
                || nbrCol >= board[0].length
                || visited[nbrRow][nbrCol]){
                continue;
            }
            if(board[nbrRow][nbrCol]==word.charAt(idx+1)){
                visited[nbrRow][nbrCol]=true;
                if(dfs(board,word,idx+1,nbrRow,nbrCol,visited)) return true;
                visited[nbrRow][nbrCol]=false;
            }
        }
        return false;
    }
}
