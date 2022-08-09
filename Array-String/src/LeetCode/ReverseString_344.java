public class ReverseString_344{

    public static void main(String[] args){
        String str="Hello";
        reverseString(str);
    }

    public static String reverseString(String str){
        int i=0;
        int j=str.length-1;
        while(j>i){
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }
        System.out.println(str);
    }
}
