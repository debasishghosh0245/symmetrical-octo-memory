import java.util.*;
public class DesignSearchAutocompleteSystem_642{
    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.display(wordDictionary.root);
    }
}

class WordDictionary{
    TreeNode root;

    public static class TreeNode{
        boolean isLast;
        HashMap<Character,TreeNode> children=new HashMap<>();
    }
    WordDictionary(){
        root=new TreeNode();
    }
    public void addWord(String word){
        TreeNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null){
                curr.children.put(ch,new TreeNode());
            }
            curr=curr.children.get(ch);
        }
        curr.isLast=true;
    }

    public static boolean search(String word){


    }

    public void display(TreeNode root){
        HashMap<Character,TreeNode> children=root.children;
        for(Map.Entry<Character,TreeNode> entry: children.entrySet()){
            System.out.print(entry.getKey());
            TreeNode child=children.get(entry.getKey());
            display(child);
            if(child.isLast){
                System.out.println(" ");
            }
        }
    }
}
