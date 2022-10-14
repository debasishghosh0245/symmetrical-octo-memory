public class KernighansAlgorithm{
    public static void main(String[] args){
        int n=58;
        int count=0;
        while(n!=0){
            //System.out.println(Integer.toBinaryString(n));
            int rsb=(n & -n);
            n=n-rsb;
            count++;
        }
        System.out.println("Required Step >> "+count);
    }
}
