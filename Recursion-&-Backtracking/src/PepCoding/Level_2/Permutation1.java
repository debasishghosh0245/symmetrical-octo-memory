public class Permutation1{
	
	public static void main(String[] args){
		int[] boxes={0,0,0,0};
		permutaion(boxes,1,3);
	}
	
	public static void permutaion(int[] boxes,int currentItem,int totalItem){
		if(totalItem < currentItem){
			for(int i : boxes){
				System.out.print(i);
			}
			System.out.println();
			return ;
		}
		for(int i=0;i<boxes.length;i++){
			if(boxes[i]==0){
				boxes[i]=currentItem;
				permutaion(boxes,currentItem+1,totalItem);
				boxes[i]=0;
			}
		}
	}
}