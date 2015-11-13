public class StockProblem1{
	public static void main(String[] args){
		int[] stocks = {100,70,80,120,300,20};
		int profit = getStock(stocks);
		System.out.println("The maximum profit is :"+profit);
	}
	public static int getStock(int[] stocks){
		int profit=0;
		int stock_min = Integer.MAX_VALUE;
	//	System.out.println("profit ="+profit+" stock_min"+stock_min);
		for(int i=0;i<stocks.length;i++){
			profit = Math.max(profit,stocks[i]-stock_min);
			stock_min = Math.min(stock_min,stocks[i]);
	//		System.out.println("profit ="+profit+" stock_min"+stock_min+" stocks[i]="+stocks[i]);
		}
		return profit;
	}
}
