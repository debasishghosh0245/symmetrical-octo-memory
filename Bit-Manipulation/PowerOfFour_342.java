public class PowerOfFour_342{

    public static void main(String[] args){
        int n=16;
        System.out.println(isPowerOfFour(n));
    }
    public static boolean isPowerOfFour(int n){
        if(n>0){
            //if number is greater that zero
            if((n & n-1)==0){
                //if the only one set bit
                return (n & 0b10101010101010101010101010101010)==0;
            }
        }
        return true;
    }
}
