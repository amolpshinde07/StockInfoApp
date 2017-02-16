/**
 * 
 */
package com.stockinfo.services;

import java.util.List;

import com.stockinfo.entities.Stock;

/**
 * @author amol.shinde
 *
 */
public interface IFileWriter {

	void writeStockDetailsIntoCSV(List<Stock> stockDetailsList);
	boolean isFileCached();
}
