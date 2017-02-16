package com.stockinfo;

import javax.swing.JOptionPane;

import com.stockinfo.impl.FileWriterImpl;
import com.stockinfo.impl.StockReaderImpl;
import com.stockinfo.impl.TextFileReaderImpl;
import com.stockinfo.services.IFileReader;
import com.stockinfo.services.IFileWriter;
import com.stockinfo.services.IStockReader;
import com.stockinfo.services.StockDetailsService;
import com.stockinfo.util.Keys;

/**
 * @author amol.shinde
 *
 */
public class StockDetailsExample {
	
	public static void main(String[] args) {
		System.out.println("Stock processing started..");
		long startTime = System.currentTimeMillis();
		
		IFileReader fileReader = new TextFileReaderImpl(Keys.INPUT_STOCKS_TXT);
		IStockReader stockReader = new StockReaderImpl(Keys.URL_WITH_SYMBOL_AS_PARAMETER);
		IFileWriter fileWriter = new FileWriterImpl(Keys.OUTPUT_CSV);
		
		StockDetailsService si = new StockDetailsService(fileReader,stockReader,fileWriter);
		boolean isFromCache = si.processSymbolList();
		
		String totalTimeMsg = "Generated Stock details from cache.";
		if(!isFromCache){
			long timeRequired = (System.currentTimeMillis()-startTime)/1000;
			totalTimeMsg = "Stock processing completed."+"\nTotal Time required is '"+timeRequired+"' seconds";
			System.out.println(totalTimeMsg);
		}
		JOptionPane.showMessageDialog(null, totalTimeMsg);
	}
}
