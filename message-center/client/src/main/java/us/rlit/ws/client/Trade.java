package us.rlit.ws.client;

import java.util.Date;

public class Trade {
	
	private String ticker;
	private double quantity;
	private double price;
	private Date tradeTime;
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Trade [ticker=" + ticker + ", quantity=" + quantity + ", price=" + price + ", tradeTime=" + tradeTime
				+ "]";
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}


}
