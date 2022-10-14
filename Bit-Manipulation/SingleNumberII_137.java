public class SingleNumberII_137{

    public static void main(String[] args){
        System.out.println("Binary of -4 "+Integer.toBinaryString(-4));
        //int[] nums={2,2,3,2};
        int[] nums={-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(singleNumber(nums));
    }
    
    public static int singleNumber(int[] nums){
        int ans=0;
        for(int bit=0; bit < 32; bit++){
            int sum=0;
            for(int num:nums){
                if(((num >> bit ) & 1) == 1){
                    sum++;
                }
            }
            ans |= (sum % 3) << bit;
        }
        return ans;
    }
}
