import java.util.*;
public class Subsets_78{
    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> result=new ArrayList<>();
        System.out.println(subsets_helper_rec(nums,0,new ArrayList<Integer>(),result));
    }

    public static List<List<Integer>> subsets_helper_rec(int[] nums,int i,
        List<Integer> set,List<List<Integer>> subsets) {
        if(i>=nums.length){
            subsets.add(set);
            return subsets;
        }
        set.add(nums[i]);
        subsets_helper_rec(nums,i+1,new ArrayList<>(set),subsets);
        set.remove(set.size()-1);
        subsets_helper_rec(nums,i+1,new ArrayList<>(set),subsets);
        return subsets;
    }
}
