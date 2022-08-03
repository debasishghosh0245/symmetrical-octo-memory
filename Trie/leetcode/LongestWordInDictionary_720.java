import java.util.*;
public class LongestWordInDictionary_720{
    public static void main(String[] args){
        //String[] words={"w","wo","wor","worl","world"};
        //String[] words={"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        //String[] words={"a","banana","app","appl","ap","apply","apple"};
        //String[] words={"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        //String[] words={"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        Trie trie=new Trie();
        for(String word: words){
            trie.insert(word);
        }
        trie.dfs(trie.root);
        System.out.println("Longest Word >>"+trie.longestWord);
    }
}
class Trie{
    TrieNode root;
    String longestWord="";
    StringBuilder currLongestWord;
    public static class TrieNode{
        String word;
        TreeMap<Character,TrieNode> children=new TreeMap<>();
    }
    Trie(){
        root=new TrieNode();
        currLongestWord=new StringBuilder();
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
    public void display(TrieNode root){
        for(Map.Entry<Character,TrieNode> entry: root.children.entrySet()){
            System.out.print(entry.getKey()+" ");
            TrieNode child=entry.getValue();
            display(child);
            if(child.word!=null){
                System.out.println(" ");
            }
        }
    }
    public void dfs(TrieNode root){
        if(root==null || root.children.size()==0) return;
        for(Map.Entry<Character,TrieNode> entry:root.children.entrySet()){
            Character ch=entry.getKey();
            TrieNode child=entry.getValue();
            if(child.word!=null){
                currLongestWord.append(ch);
                if(longestWord.length()<currLongestWord.length()){
                    longestWord=currLongestWord.toString();
                }
                dfs(child);
                currLongestWord.deleteCharAt(currLongestWord.length()-1);
            }
        }
    }
}
