package com.stockinfo.entities;

import com.stockinfo.util.Keys;

/**
 * @author amol.shinde
 *
 */
public class Stock {

	private String stockName;
	private String stockPrice;
	private String yearTargetPrice;
	private String yearLow;
	private String yearHigh;
	private String stockSym;
	
	public Stock(String stockSym) {
		this.setStockSym(stockSym);
	}
	public Stock(String stockSym,String stockName,String stockPrice, String yearTargetPrice,String yearLow, String yearHigh) {
		this.setStockSym(stockSym);
		this.setStockName(stockName);
		this.setStockPrice(stockPrice);
		this.setYearTargetPrice(yearTargetPrice);
		this.setYearLow(yearLow);
		this.setYearHigh(yearHigh);
	}

	public String getStockPrice() {
		return stockPrice==null?"-1":stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getYearTargetPrice() {
		return yearTargetPrice==null?"-1":yearTargetPrice;
	}

	public void setYearTargetPrice(String yearTargetPrice) {
		this.yearTargetPrice = yearTargetPrice;
	}

	public String getYearLow() {
		return yearLow==null?"-1":yearLow;
	}

	public void setYearLow(String yearLow) {
		this.yearLow = yearLow;
	}

	public String getYearHigh() {
		return yearHigh==null?"-1":yearHigh;
	}

	public void setYearHigh(String yearHigh) {
		this.yearHigh = yearHigh;
	}

	public String getStockName() {
		return stockName==null?"-1":stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockSym() {
		return stockSym==null?"-1":stockSym;
	}

	public void setStockSym(String stockSym) {
		this.stockSym = stockSym;
	}

	public void printStock() {
		System.out.println(":: Stock Details ::");
		System.out.println("Symbol : "+getStockSym());
		System.out.println("Name : "+getStockName());
		System.out.println("Price : "+getStockPrice());
		System.out.println("Year Target Price : "+getYearTargetPrice());
		System.out.println("Year Low Price : "+getYearLow());
		System.out.println("Year High Price : "+getYearHigh());
	}
	
	@Override
	public String toString() {
		String separator = Keys.CSV_SEPARATOR;
		return getStockSym()+separator+getStockPrice()+separator+getYearTargetPrice()+separator+getYearHigh()+separator+getYearLow();
	}

}
