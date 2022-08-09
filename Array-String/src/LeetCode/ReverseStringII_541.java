public class ReverseStringII_541{
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args){
        // String str= "abcdefg";
        // int k=2;
        String str="abcd";
        int k=4;
        System.out.println(reverse(str,k));
    }
    public static String reverse(String str,int k){
        char[] arr=str.toCharArray();
        for(int start=0;start<str.length();start+=2*k){
            int i=start;
            int j=Math.min(start + k - 1, str.length() - 1);;
            while(j>i){
                char temp=arr[i];
                arr[i++]=arr[j];
                arr[j--]=temp;
            }
        }
        return new String(arr);
    }
}
