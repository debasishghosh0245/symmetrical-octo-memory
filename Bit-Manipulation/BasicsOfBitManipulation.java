import java.util.*;
public class BasicsOfBitManipulation{

    public static void main(String[] args){
        int n=57;
        int i=3;
        int k=3;
        int j=3;
        int m=3;
        int onMask=1 << i;
        int offMask=~(1 << j);
        int toggleMask=1 << k;
        int checkBit=1 << m;
        System.out.println("Set Bit Or On Bit "+(n | onMask));
        System.out.println("Get Bit Or Off Bit "+(n & offMask));
        System.out.println("Toggle Bit >> "+(n ^ toggleMask));
        System.out.println("Check Bit >> "+((n & checkBit)>0));
    }
}
