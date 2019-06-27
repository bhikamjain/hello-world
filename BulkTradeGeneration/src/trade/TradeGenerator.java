package trade;

import java.util.ArrayList;
import java.util.Date;

public class TradeGenerator {
	
	public static ArrayList generateTrades(int count) 
	{
		ArrayList tradeList = new ArrayList();
		
		int i = 0;
		do
		{
			Trade aTrade = new Trade();
			aTrade.setPrice(Math.abs(Math.random()*100));
			aTrade.setQuantity(Math.abs(Math.random()*100));
			aTrade.setTicker("ABC");		
			aTrade.setTradeTime(new Date("06/27/2019"));
			
			tradeList.add(aTrade);
		}
		while(i++ < count);
		
		return tradeList;
	}
	
	public static void main(String args[])
	{
		ArrayList tradeList = TradeGenerator.generateTrades(100);
		
		if (tradeList != null && tradeList.size() > 0)
		{
			System.out.println("Number of trades = " + tradeList.size());
			int i = 0;
			do
			{
				Trade aTrade = (Trade) tradeList.get(i);
				if (aTrade != null)
				{
					System.out.println("Ticker: " + aTrade.getTicker());
					System.out.println("Quantity: " + aTrade.getQuantity());
					System.out.println("Price: " + aTrade.getPrice());
					System.out.println("Trade Time: " + aTrade.getTradeTime());
				}
			}
			while (i++ < tradeList.size());
		}
		else
		{
			System.out.println("No trades");
		}	
	}
}
