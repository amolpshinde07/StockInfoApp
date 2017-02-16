/**
 * 
 */
package com.stockinfo.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.stockinfo.entities.Stock;
import com.stockinfo.services.IFileWriter;
import com.stockinfo.util.Keys;
import com.stockinfo.util.StockUtil;

/**
 * @author sony
 *
 */
public class FileWriterImpl implements IFileWriter {

	private String outputCsv;

	public FileWriterImpl(String outputCsv) {
		this.setOutputCsv(outputCsv);
	}

	/* (non-Javadoc)
	 * @see com.stockinfo.services.IFileWriter#writeStockDetailsIntoCSV(java.util.List)
	 */
	@Override
	public void writeStockDetails(List<Stock> stockDetailsList) {
		try {
			FileWriter writer = new FileWriter(getOutputCsv());
			writeStockDetails(writer, stockDetailsList);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * It writes stock details into csv file
	 * @param writer
	 * @param stockDetailsList
	 * @throws IOException
	 */
	public void writeStockDetails(Writer writer, List<Stock> stockDetailsList) throws IOException {
		StockUtil.addCSVHeader(writer);
		if(stockDetailsList!=null){
			for (Stock eachStock : stockDetailsList) {
				if(eachStock!=null){
					StringBuilder sbEach = new StringBuilder();
					sbEach.append(StockUtil.replaceCSVChar(eachStock.toString()));
					sbEach.append(Keys.NEW_LINE);
					writer.append(sbEach.toString());
				}
			}
		}
	}
	/* (non-Javadoc)
	 * @see com.stockinfo.services.IFileWriter#isFileCached()
	 */
	@Override
	public boolean isFileCached() {
		File file = new File(getOutputCsv());
		if(!file.exists()){
			return false;
		}
		long lastModified = file.lastModified();
		long currentTimeMillis = System.currentTimeMillis();
		long gap = currentTimeMillis-lastModified;

		if(gap<60000 && file.exists()){
			return true;
		}
		
		return false;
	}

	public String getOutputCsv() {
		return outputCsv;
	}

	public void setOutputCsv(String outputCsv) {
		this.outputCsv = outputCsv;
	}

}
