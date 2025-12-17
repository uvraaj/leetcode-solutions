class Solution {
    public long maximumProfit(int[] prices, int k) {
      int n=prices.length;
      long[] cur=new long[n];
      long[] prev=new long[n];

      for(int j=1;j<=k;j++)
      {
        long bb=-prices[0];
        long bs=prices[0];
        cur[0]=0;
        for(int i=1;i<n;i++)
        {

            cur[i]=Math.max(cur[i-1],Math.max(prices[i]+bb,bs-prices[i]));

            bb=Math.max(bb,prev[i-1]-prices[i]);
            bs=Math.max(bs,prev[i-1]+prices[i]);
        }
        long[] t=prev;
        prev=cur;
        cur=t;
      }  
      return prev[n-1];
    }
}