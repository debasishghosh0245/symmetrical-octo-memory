import java.util.*;
public class WordSearchII_212 {
	public static void main(String[] args) {
		char[][] board={{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
		String[] words={"oa","oaa"};
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
        trie.display(Trie.root);
        Set<String> ans=new HashSet<>();
		for (int row = 0; row < board.length; row++) {
		for (int col = 0; col < board.length; col++) {
			boolean[][] visited = new boolean[board.length][board.length];
                if(Trie.root.children.containsKey(board[row][col])){
                    dfs(board,Trie.root,row,col,visited,ans);
                }
		    }
		}
        System.out.println("ans >>"+ans);
	}
	static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
	public static void dfs(char[][] board,Trie.TrieNode root,int row,int col,
        boolean[][] visited,Set<String> ans) {
        Trie.TrieNode child=root.children.get(board[row][col]);
        if (child==null) return;
        System.out.println("Child >>"+board[row][col]+" Word >>"+child.word);
        if(child.word!=null){
            ans.add(child.word);
        }
		for (int[] direction : directions) {
			int nbrRow = row + direction[0];
			int nbrCol = col + direction[1];
			if (nbrRow < 0 || nbrRow >= board.length || nbrCol < 0
                || nbrCol >= board[0].length || visited[nbrRow][nbrCol]) {
				continue;
			}
			if (child.children.containsKey(board[nbrRow][nbrCol])) {
				visited[nbrRow][nbrCol] = true;
				dfs(board,child,nbrRow,nbrCol,visited,ans);
				visited[nbrRow][nbrCol] = false;
			}
		}
	}
}
class Trie {
	public static TrieNode root;
	public static class TrieNode {
		String word;
		HashMap<Character, TrieNode> children = new HashMap<>();
	}
	Trie(){
		root=new TrieNode();
	}
	public void insert(String word) {
		TrieNode curr=root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
            if(curr.children.get(ch)==null){
                curr.children.put(ch,new TrieNode());
            }
			curr = curr.children.get(ch);
		}
		curr.word=word;
	}
    public void display(TrieNode root){
        HashMap<Character,TrieNode> children=root.children;
        for(Map.Entry<Character,TrieNode> entry: children.entrySet()){
            System.out.println(entry.getKey());
            display(entry.getValue());
            //System.out.println(entry.getValue().word);
        }
    }
}
