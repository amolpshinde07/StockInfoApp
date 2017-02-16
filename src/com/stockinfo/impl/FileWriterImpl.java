/**
 * 
 */
package com.stockinfo.impl;

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

	@Override
	public void writeStockDetailsIntoCSV(List<Stock> stockDetailsList) {
		try {
			FileWriter writer = new FileWriter(getOutputCsv());
			writeEachStockDetails(writer, stockDetailsList);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void writeEachStockDetails(Writer writer, List<Stock> stockDetailsList) throws IOException {
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

	public String getOutputCsv() {
		return outputCsv;
	}

	public void setOutputCsv(String outputCsv) {
		this.outputCsv = outputCsv;
	}

}
