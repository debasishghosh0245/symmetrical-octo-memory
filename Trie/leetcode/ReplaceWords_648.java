import java.util.*;
public class ReplaceWords_648{

    public static void main(String[] args){
        WordDictionary dictionary=new WordDictionary();
        //String[] arr ={"cat","bat","rat"};
        //String sentence = "the cattle was rattled by the battery";
        String sentence="aadsfasf absbs bbab cadsfafs";
        String[] arr={"a","b","c"};
        for(String word: arr){
            dictionary.addWord(word);
        }
        System.out.println("After replaced >> "+dictionary.replaceWords(sentence));
        dictionary.display(dictionary.root);
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
    public String findPrefix(String word){
        TreeNode curr=root;
        StringBuilder prefix=new StringBuilder();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null){
                return "";
            }
            prefix.append(ch);
            curr=curr.children.get(ch);
            if(curr.isLast==true){
                return prefix.toString();
            }
        }
        return "";
    }
    public String replaceWords(String sentence){
        String[] words=sentence.split(" ");
        StringBuilder ans=new StringBuilder();
        StringTokenizer str_arr= new StringTokenizer(sentence);
        while (str_arr.hasMoreTokens()) {
            String word=str_arr.nextToken();
            String prefixStr=findPrefix(word);
            //System.out.println("Word >> "+word+" >>  prefix word >> "+prefixStr);
            if(prefixStr.length()>0){
                ans.append(prefixStr+" ");
            }else{
                ans.append(word+" ");
            }
        }
        return ans.toString();
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
