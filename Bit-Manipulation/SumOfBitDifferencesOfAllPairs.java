public class SumOfBitDifferencesOfAllPairs{

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(sumOfBitDiffPairs(nums));
    }
    public static int sumOfBitDiffPairs(int[] nums){
        int ans=0;
        for(int bit=0;bit<32;bit++){
            int mask=1<<bit;
            int onesbit_count=0;
            int zerosbit_count=0;
            for(int num : nums){
                if((num & mask) > 0){
                    onesbit_count++;
                }
                zerosbit_count=nums.length-onesbit_count;
            }
            ans+=(onesbit_count*zerosbit_count) * (onesbit_count*zerosbit_count);
        }
        return ans;
    }



}
