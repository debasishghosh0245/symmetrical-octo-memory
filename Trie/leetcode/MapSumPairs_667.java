import java.util.*;
public class MapSumPairs_667 {
    public static TreeNode root;
    public static HashMap<String,Integer> map;
    public static class TreeNode{
        int sum=0;
        HashMap<Character,TreeNode> children=new HashMap<>();
    }
    public MapSumPairs_667(){
        root=new TreeNode();
        map=new HashMap<>();
    }
    public static void insert(String word,int val){
        int delta=map.getOrDefault(word,0);
        map.put(word,val);
        TreeNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null){
                curr.children.put(ch,new TreeNode());
            }
            curr.children.get(ch).sum+=val-delta;
            curr=curr.children.get(ch);
        }
    }
    public static int sum(String prefix){
        TreeNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(curr.children.get(ch)==null) return 0;
            curr=curr.children.get(ch);
        }
        return curr.sum;
    }
    public static void display(TreeNode root){
        HashMap<Character,TreeNode> child=root.children;
        for(Map.Entry<Character,TreeNode> entry: child.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(child.get(entry.getKey()).sum);
            TreeNode rootCh=child.get(entry.getKey());
            display(rootCh);
            if(rootCh.isWord) {
                System.out.println(" ");
            }
        }
    }
    public static void main(String[] args){
        MapSumPairs_667 trie=new MapSumPairs_667();
        insert("apple",3);
        System.out.println("Sum >>"+sum("app"));
        insert("app",2);
        insert("apple",2);
        System.out.println("Sum >>"+sum("app"));
        display(root);
    }
}
