import java.util.*;
public class ImplementTrie_208{
    static TreeNode root;
    public static class TreeNode{
        boolean isWord;
        HashMap<Character,TreeNode> children=new HashMap<>();
    }

    public ImplementTrie_208(){
        root=new TreeNode();
    }

    public static void insert(String word){
        TreeNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null){
                curr.children.put(ch,new TreeNode());
            }
            curr=curr.children.get(ch);
        }
        curr.isWord=true;
    }

    /*Return true */
    public static boolean search(String word){
        TreeNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null) return false;
            curr=curr.children.get(ch);
        }
        return curr.isWord;
    }

    public static boolean startWith(String word){
        TreeNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null) return false;
            curr=curr.children.get(ch);
        }
        return true;
    }

    public static void display(TreeNode root){
        HashMap<Character,TreeNode> child=root.children;
        for(Map.Entry<Character,TreeNode> map:child.entrySet()){
            System.out.print(map.getKey()+" ");
            TreeNode childRoot=child.get(map.getKey());
            display(childRoot);
            if(childRoot.isWord) {
                System.out.println(" ");
            }
        }
    }

    public static void main(String[] args){
        ImplementTrie_208 trie=new ImplementTrie_208();
        insert("am");
        insert("bad");
        insert("bae");
        insert("so");
        display(root);
        System.out.println(search("aam"));
        System.out.println(startWith("son"));
    }
}
