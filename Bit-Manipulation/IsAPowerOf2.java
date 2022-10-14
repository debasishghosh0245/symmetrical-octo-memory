public class IsAPowerOf2{

    public static void main(String[] args){
        System.out.println(isPowerOfTwo(5));
    }
    public static boolean isPowerOfTwo(int n){
        int rsb=n & -n;
        return n-rsb==0;
    }
}
