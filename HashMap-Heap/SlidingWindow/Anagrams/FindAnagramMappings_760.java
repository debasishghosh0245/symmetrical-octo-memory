import java.util.*;
public class FindAnagramMappings_760{
    public static void main(String[] args){
        int[] nums1={21,5,74,5,74,21};
        int[] nums2={21,5,74,74,5,21};
        System.out.println(Arrays.toString(findAnagramMapping(nums1,nums2)));
    }

    public static int[] findAnagramMapping(int[] nums1,int[] nums2){
        HashMap<Integer,List<Integer>> map2=new HashMap<>();
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            map2.putIfAbsent(nums2[i],new ArrayList<>());
            List<Integer> indexList=map2.get(nums2[i]);
            indexList.add(i);
            map2.put(nums2[i],indexList);
        }
        int i=0;
        for(i=0;i<nums1.length;i++){
            List<Integer> indexs=map2.get(nums1[i]);
            ans[i]=indexs.get(indexs.size()-1);
        }
        return ans;
    }
}
