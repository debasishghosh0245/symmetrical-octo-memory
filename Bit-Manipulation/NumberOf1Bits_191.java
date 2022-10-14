public class NumberOf1Bits_191{

    public static void main(String[] args){
        int n=31;
        System.out.println(numsOfBits(n));
    }

    public static int numsOfBits(int n){
        int cntBits=0;
        while(n!=0){
            int rsb=(n & -n);
            n=n-rsb;
            cntBits++;
        }
        return cntBits;
    }
}
