public class AllRepeatingExceptTwo{

    public static void main(String[] args){
        int[] nums={1,3,4,2,2};
        System.out.println(findRepeatingNumber(nums));
    }

    public static int findRepeatingNumber(int[] nums){
        int xor=0;
        int x=0;
        int y=0;
        int repeating=0;
        for(int i=0;i<nums.length;i++){
            xor=xor ^ nums[i];
        }
        for(int i=1;i<=nums.length;i++){
            xor=xor ^ i;
        }
        int mask=xor & (-xor);
        for(int i=0;i<nums.length;i++){
            if((mask & nums[i])==0){
                x=x^nums[i];
            }else{
                y=y^nums[i];
            }
        }
        for(int i=1;i<=nums.length;i++){
            if((mask & i)==0){
                x=x^i;
            }else{
                y=y^i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                repeating=x;
                break;
            }
            if(nums[i]==y){
                repeating=y;
                break;
            }
        }
        return repeating;
    }
}
