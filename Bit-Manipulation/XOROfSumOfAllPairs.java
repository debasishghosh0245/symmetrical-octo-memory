public class XOROfSumOfAllPairs{

    public static void main(String[] args){
        int[] nums={1,5,2,1,2};
        System.out.println(findXOROfSumOfAllPairs(nums));
    }
    public static int findXOROfSumOfAllPairs(int[] nums){
        int xor=0;
        for(int num:nums){
            xor=xor ^ num;
        }
        return xor << 1;
    }
}
