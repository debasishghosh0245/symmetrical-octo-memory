import java.util.*;
public class ReverseWordsInAStringIII_547{
    public static void main(String[] args){
        String str="Let's take LeetCode contest";
        StringBuilder result=new StringBuilder();
        for(String word: str.split(" ")){
            reverse(word,result);
        }
        System.out.println(result.toString().trim());
    }
    public static void reverse(String word,StringBuilder result){
        char[] chars=word.toCharArray();
        int i=0;
        int j=chars.length-1;
        while(j>i){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            j--;
            i++;
        }
        result.append(new String(chars)+" ");
    }
}
