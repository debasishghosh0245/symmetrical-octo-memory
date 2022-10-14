import java.util.*;
public class Permutations_46{

    public static void main(String[] args){
        int[] nums={1,2,3};
        Integer[] box=new Integer[nums.length];
        List<List<Integer>> ans=new ArrayList<>();
        permutation(nums,0,box,ans);
        System.out.println(ans);
    }

    public static List<List<Integer>> permutation(int[] nums,int idx,
        Integer[] set,List<List<Integer>> pset){
        if(idx >= nums.length){
            pset.add(new ArrayList<>(Arrays.asList(set)));
            return pset;
        }
        for(int i=0;i<set.length;i++){
            if(set[i]==null){
                set[i]=nums[idx];
                permutation(nums,idx+1,set,pset);
                set[i]=null;
            }
        }
        return pset;
    }
}
