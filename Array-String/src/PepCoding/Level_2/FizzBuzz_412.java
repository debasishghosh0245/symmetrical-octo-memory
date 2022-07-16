import java.util.*;
public class FizzBuzz_412  {

    public static void main(String[] args){
        System.out.println(fizzBuzzII(3));
    }

    //Approach 1
    public static List<String> fizzBuzz(int n){
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                ans.add("FizzBuzz");
            }else if(i%3==0){
                ans.add("Fizz");
            }else if(i%5==0){
                ans.add("Buzz");
            }else{
                ans.add(i+"");
            }
        }
        return ans;
    }

    //Approach 2
    public static List<String> fizzBuzzII(int n){
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            StringBuilder numAnsStr = new StringBuilder();
            if(i%3==0){
                numAnsStr.append("Fizz");
            }
            if(i%5==0){
                numAnsStr.append("Buzz");
            }
            if(numAnsStr.length()==0){
                numAnsStr.append(i+"");
            }
            ans.add(numAnsStr.toString());
        }
        return ans;
    }
}
