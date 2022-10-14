import java.util.*;
public class MinimumTimeTypeWordUsingSpecialTypewriter_1974{

    public static void main(String[] args){
        //String word = "bza";
        String word="zjpc";
        System.out.println(minTimeToTypeWord(word));
    }

    public static int minTimeToTypeWord(String str){
        int totalTime=str.length();
        char prev='a';
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            totalTime+=Math.min(Math.abs(ch-prev),26-Math.abs(prev-ch));
            prev=ch;
        }
        return totalTime;
    }

}
