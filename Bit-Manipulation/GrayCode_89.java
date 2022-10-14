import java.util.*;
public class GrayCode_89{

    public static void main(String[] args){
        int n=3;
        System.out.println(printGrayCode(n));
    }

    public static List<Integer> printGrayCode(int n){
        if(n==0){
            List<Integer> list=new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> grayCodes=printGrayCode(n-1);
        List<Integer> ans=new ArrayList<>();
        int setMask=1<<(n-1);
        for(int i=0;i<grayCodes.size();i++){
            ans.add(grayCodes.get(i)+(setMask-setMask));
        }
        for(int i=grayCodes.size()-1;i>=0;i--){
            ans.add(grayCodes.get(i)+setMask);
        }
        return ans;
    }
}
