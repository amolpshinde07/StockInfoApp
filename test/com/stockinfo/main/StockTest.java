package com.stockinfo.main;
import org.junit.Test;

import com.stockinfo.services.FileWriterImpl;
import com.stockinfo.services.IFileReader;
import com.stockinfo.services.IFileWriter;
import com.stockinfo.services.IStockReader;
import com.stockinfo.services.StockDetailsService;
import com.stockinfo.services.StockReaderImpl;
import com.stockinfo.services.TextFileReaderImpl;
import com.stockinfo.util.Keys;

public class StockTest { 
	
	@Test
	public void testStock() {
		
		System.out.println("Stock processing started..");
		long startTime = System.currentTimeMillis();
		
		IFileReader fileReader = new TextFileReaderImpl(Keys.INPUT_STOCKS_TXT);
		IStockReader stockReader = new StockReaderImpl(Keys.URL_WITH_SYMBOL_AS_PARAMETER);
		IFileWriter fileWriter = new FileWriterImpl(Keys.OUTPUT_CSV);
		
		StockDetailsService si = new StockDetailsService(fileReader,stockReader,fileWriter);
		si.processSymbolList();

		long timeRequired = (System.currentTimeMillis()-startTime)/1000;
		System.out.println("Stock processing completed.");
		System.out.println("Total Time required to execute app is '"+timeRequired+"'");
	} 

}