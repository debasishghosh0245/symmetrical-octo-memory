public class RotateImage_48{

    public static void main(String[] args){
        //int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        transponse(matrix);
        rotate(matrix);
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void transponse(int[][] matrix){
        for(int row=0;row<matrix[0].length;row++){
            for(int col=0;col<row;col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
    }

    public static void rotate(int[][] matrix){
        for(int row=0;row<matrix.length;row++){
            int i=0;
            int j=matrix[row].length-1;
            while(i<j){
                int temp=matrix[row][i];
                matrix[row][i]=matrix[row][j];
                matrix[row][j]=temp;
                i++;
                j--;
            }
        }
    }
}
