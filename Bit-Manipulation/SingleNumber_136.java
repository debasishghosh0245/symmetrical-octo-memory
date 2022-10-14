public class SingleNumber_136{

    public static void main(String[] args){
        int[] nums={4,1,2,1,2};
        System.out.println(single(nums));
    }

    public static int single(int[] arr){
        int ans=0;
        for(int i:arr){
            ans=i^ans;
        }
        return ans;
    }
}
