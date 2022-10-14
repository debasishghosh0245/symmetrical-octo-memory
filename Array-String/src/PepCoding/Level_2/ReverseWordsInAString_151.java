import java.util.*;
public class ReverseWordsInAString_151{

    public static void main(String[] args){
        String s="a good   example";
        System.out.println(reverseWordsII(s));
    }
    public static String reverseWords(String s){
        //Remove the leading space
        s=s.trim();
        String[] strArr=s.split("\\s+");
        int i=0;
        int j=strArr.length-1;
        while(j>=i){
            swap(strArr,i,j);
            i++;
            j--;
            System.out.println(Arrays.toString(strArr));
        }
        return String.join(" ",strArr);
    }


    public static void swap(String[] arr,int i,int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static String reverseWordIII(String s){
        s=s.trim();
        String[] word=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            if(word[i].trim().length()!=0){
                sb.append(word[i]+" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWordsII(String s){
        int left=0;
        int right=s.length()-1;
        //remove left leading space
        while(right >= left && s.charAt(left)==' '){
            left++;
        }
        //remove right leading space
        while(right >= left && s.charAt(right)==' '){
            right--;
        }
        Deque<String> deque=new LinkedList<>();
        StringBuilder word=new StringBuilder();
        while(right >=left){
            char ch=s.charAt(left);
            if(ch==' '){
                if(word.toString().trim().length()!=0){
                    deque.offerFirst(word.toString());
                    word=new StringBuilder();
                }
            }else{
                word.append(ch);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ",deque);
    }
}
