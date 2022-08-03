import java.util.*;
public class HappyNumber_202{

    public static void main(String[] args){
        System.out.println(loopDetection(2));
    }

    public static boolean happyNumber(int n){
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            int next=next(n);
            if(set.contains(next)) return false;
            set.add(next);
            n=next;
        }
        return true;
    }
    public static int next(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            n=n/10;
            sum+=digit;
        }
        return sum;
    }
    //Apprpach 2: Floyed Loop detection:
    public static boolean loopDetection(int n){
        int fast=next(n);
        int slow=n;
        while(fast!=1 && fast!=slow){
            slow=next(slow);
            fast=next(next(fast));
        }
        return fast==1;
    }
}
