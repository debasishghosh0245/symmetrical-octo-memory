public class BestTimeBuyAndSellStockII_122{

	public static void main(String[] args){
		 int[] prices ={7,1,5,3,6,4};
		//int[] prices={1,2,3,4,5};
		Integer[][] memo=new Integer[prices.length][2];
		System.out.println(maxProfitTabular_SpaceOptimized(prices));
	}
	
	//Approach1: Recursive 
	public static int maxProfit(int[] prices,int day,int buy) {
		if(day >= prices.length) return 0;
		int profit=0;
		if(buy==1){
			int profitWithBuy=-prices[day]+maxProfit(prices,day+1,0);
			int profitWithNotBuy=0+maxProfit(prices,day+1,1);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]+maxProfit(prices,day+1,1);
			int profitWithNotSell=0+maxProfit(prices,day+1,0);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		return profit;
    } 
	
	//Approach 2: Memoziation 
	public static int maxProfitMemo(int[] prices,int day,int isBuy,Integer[][] memo) {
		if(day >= prices.length) return 0;
		if(memo[day][isBuy]!=null) return memo[day][isBuy];
		int profit=0;
		if(isBuy==1){
			int profitWithBuy=-prices[day]+maxProfitMemo(prices,day+1,0,memo);
			int profitWithNotBuy=0+maxProfitMemo(prices,day+1,1,memo);
			profit=Math.max(profitWithBuy,profitWithNotBuy);
		}
		else{
			int profitWithSell=prices[day]+maxProfitMemo(prices,day+1,1,memo);
			int profitWithNotSell=0+maxProfitMemo(prices,day+1,0,memo);
			profit=Math.max(profitWithSell,profitWithNotSell);
		}
		memo[day][isBuy]=profit;
		return profit;
    } 
	
	//approach 3: Top - Down  
	public static int maxProfitTabular(int[] prices) {
		int[][] dp=new int[prices.length+1][2];
		for(int day=dp.length-1;day>=0;day--){
			for(int isBuy=0;isBuy<=1;isBuy++){
				if(day==dp.length-1){
					dp[day][isBuy]=0;
				}else{
					int profit=0;
					if(isBuy==1){
						int profitWithBuy=-prices[day]+dp[day+1][0];
						int profitWithNotBuy=0+dp[day+1][1];
						profit=Math.max(profitWithBuy,profitWithNotBuy);
					}
					else {
						int profitWithSell=prices[day]+dp[day+1][1];
						int profitWithNotSell=0+dp[day+1][0];
						profit=Math.max(profitWithSell,profitWithNotSell);
					} 
					dp[day][isBuy]=profit;
				}
			}
		}
		
		//print the final dp
		for(int row=0; row < dp.length;row++) {
			for(int col=0;col < dp[row].length; col++){
				System.out.print(dp[row][col]+" ");
			}
			System.out.println("");
		}
		return dp[0][1];
    } 
	
	public static int maxProfitTabular_SpaceOptimized(int[] prices) {		
		int[] current=new int[2];
		int[] previous=new int[2];
		for(int day=prices.length-1;day>=0;day--){
			for(int isBuy=0;isBuy<=1;isBuy++){
				if(day==prices.length-1){
					current[isBuy]=0;
				}else{
					int profit=0;
					if(isBuy==1){
						int profitWithBuy=-prices[day]+previous[0];
						int profitWithNotBuy=0+previous[1];
						profit=Math.max(profitWithBuy,profitWithNotBuy);
					}
					else {
						int profitWithSell=prices[day]+previous[1];
						int profitWithNotSell=0+previous[0];
						profit=Math.max(profitWithSell,profitWithNotSell);
					} 
					current[isBuy]=profit;
					previous=current;
				}
			}
		}
		return current[1];
    } 
}