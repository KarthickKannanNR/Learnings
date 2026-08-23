package org.example;

public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int []stocksPrice = {7,1,5,3,6,8};
        System.out.println(findMaxProfit2(stocksPrice));
    }

    public static int findMaxProfit(int []arr){
        int buyPrice = Integer.MAX_VALUE,sellPrice = 0,profit = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] < buyPrice){
                buyPrice = arr[i];
            }
            if(arr[i+1] - buyPrice > profit){
                profit = arr[i+1]-buyPrice;
            }
        }
        return profit;
    }

    public static int findMaxProfit2(int []prices){
        int minprice=Integer.MAX_VALUE;
        int maxprice=0;
        for(int p:prices){
            if(p<minprice){
                minprice=p;
            }else{
                maxprice=Math.max(maxprice,p-minprice);
            }
        }
        return maxprice;
    }
}
