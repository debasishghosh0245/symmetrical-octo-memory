public class ReverseBits_199{

    public static void main(String[] args){
        int n=0b00000010100101000001111010011100;
        //964176192
        //int n=0b11111111111111111111111111111101;
        System.out.println("ans >>"+reverseBit3(n,32));
    }
    public static int reverse(int n){
        int result=0;
        for(int i=0;i<32;i++){
            result=result<<1;
            result |= (n & 1);
            n=n >> 1;
            System.out.println(Integer.toBinaryString(n));
            System.out.println(Integer.toBinaryString(result));
        }
        return result;
    }

    public static int reversbit(int n){
        int reverse=0;
        for(int i=31;i>0;i--){
            int mask=1<<i;
            if((mask & n)!=0) {
                int setmask=1<<(31-i);
                reverse |= setmask;
            }
        }
        System.out.println("Reverese >>"+Integer.toBinaryString(reverse));
        return reverse;
    }

    public static int reverseBit3(int n,int bit){
        if(bit==1){
            return n;
        }
        int midd=bit/2;
        return (reverseBit3(n>>midd,midd) | reverseBit3(n<<midd,midd));
    }
}
