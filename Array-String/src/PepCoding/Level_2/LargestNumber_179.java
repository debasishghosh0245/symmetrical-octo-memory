import java.util.*;
public class LargestNumber_179{

    public static void main(String[] args){
        //int[] nums={3,30,34,5,9};
        int[] nums={0,1,2};
        System.out.println(largestNumber(nums));
    }
    public static String largestNumber(int[] nums) {
        String[] str_nums=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str_nums[i]=String.valueOf(nums[i]);
        }
        Collections.sort(Arrays.asList(str_nums),new MyComperator());
        //System.out.println(Arrays.toString(str_nums));
        if(str_nums[0].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();
        for(String srt:str_nums){
            sb.append(srt);
        }
        return sb.toString();
    }
}
class MyComperator implements Comparator<String>{
    public int compare(String str1,String str2){
        String a=str1+str2;
        String b=str2+str1;
        return b.compareTo(a);
    }
}
