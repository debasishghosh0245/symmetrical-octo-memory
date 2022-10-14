public class SwapAllOddAndEvenBits{

    public static void main(String[] args){
        int n=23;
        System.out.println(swapAllOddAndEvenBits(n));
    }
    public static int swapAllOddAndEvenBits(int n){
        int oddMask=0xAAAAAAAA;
        int evenMask=0x55555555;
        int segrigatedEvensBits=evenMask & n;
        int segrigatedOddBits=oddMask & n;
        return (segrigatedEvensBits << 1) | (segrigatedOddBits >> 1);
    }
}
