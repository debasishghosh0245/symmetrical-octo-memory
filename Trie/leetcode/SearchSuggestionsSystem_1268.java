import java.util.*;
public class SearchSuggestionsSystem_1268{
    public static void main(String[] args){
        Trie trie=new Trie();
        String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
        for(String product: products){
            trie.insert(product);
        }
        trie.display(trie.root);
        String searchWord="mouse";
    }
}
public static void dfs(TreeNode root,String searchWord){
    PriorityQueue<TrieNode> maxHeap=new LinkedList<>();
    for(Map.Entry<Character,TrieNode> entry:root.children){

        if(maxHeap.size()>3){
            maxHeap.pop();
        }
        maxHeap.offer(entry.getValue());
    }
    while(!maxHeap.isEmpty()){
        dfs(maxHeap.pop());
    }
}
class Trie{
    TrieNode root;
    public static class TrieNode{
        String word;
        HashMap<Character,TrieNode> children=new HashMap<>();
    }
    Trie(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            curr.children.putIfAbsent(ch,new TrieNode());
            curr=curr.children.get(ch);
        }
        curr.word=word;
    }

    public static List<String> search(String searchWord){
        TrieNode curr=root;
        for(int i=0;i<searchWord.length();i++){
            char ch=charAt(i);
            if(root.children.containsKey(cur)){
                curr=root.childen.get(curr);
            }
        }

    }

    public void display(TrieNode root){
        for(Map.Entry<Character,TrieNode> entry: root.children.entrySet()){
            System.out.print(entry.getKey()+"");
            TrieNode child=entry.getValue();
            display(child);
            if(child.word!=null){
                System.out.println(" ");
            }
        }
    }
}
