package com.stockinfo.services;

import java.util.List;

import com.stockinfo.entities.Stock;

/**
 * @author amol.shinde
 *
 */
public class StockDetailsService {  
	
	private IFileReader fileReader;
	private IStockReader stockReader;
	private IFileWriter fileWriter;

	private List<String> symbolList;
	private List<Stock> stockDetailsList;
	
	/**
	 * @param reader
	 * @param stockReader
	 * @param fileWriter
	 */
	public StockDetailsService(IFileReader reader, IStockReader stockReader, IFileWriter fileWriter) {
		this.setFileReader(reader);
		this.setStockReader(stockReader);
		this.setFileWriter(fileWriter);
	}

	/**
	 * It calls to symbol reader and find out stocks for them using Stock reader then finally write it to csv
	 * @return
	 */
	public boolean processSymbolList() {
		if(!this.getFileWriter().isFileCached()){
			this.setSymbolList(this.getFileReader().getListOfSymbolsFromFile());
			this.setStockDetailsList(this.getStockReader().getStockList(getSymbolList()));
			this.getFileWriter().writeStockDetails(getStockDetailsList());
			return false;
		}
		return true;
	}

	public IFileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(IFileReader fileReader) {
		this.fileReader = fileReader;
	}

	public IStockReader getStockReader() {
		return stockReader;
	}

	public void setStockReader(IStockReader stockReader) {
		this.stockReader = stockReader;
	}

	public List<String> getSymbolList() {
		return symbolList;
	}

	public void setSymbolList(List<String> symbolList) {
		this.symbolList = symbolList;
	}

	public List<Stock> getStockDetailsList() {
		return stockDetailsList;
	}

	public void setStockDetailsList(List<Stock> stockDetailsList) {
		this.stockDetailsList = stockDetailsList;
	}

	public IFileWriter getFileWriter() {
		return fileWriter;
	}

	public void setFileWriter(IFileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
}
