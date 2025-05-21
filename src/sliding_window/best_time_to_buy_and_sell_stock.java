package sliding_window;


public class best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        System.out.println(
                maxProfit(new int[]{10,1,5,6,7,1})
        );
    }

    public static int maxProfit(int[] prices) {
        var buy = 0;
        var sell = 1;
        var maxP = 0;

        while(sell < prices.length){
            if(prices[sell] > prices[buy]){
                var prof = prices[sell] - prices[buy];
                maxP = Math.max(prof, maxP);
            } else {
                buy = sell;
            }
            sell++;
        }
        return maxP;
    }

}