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

	/**
	 * It writes all stock details into csv file
	 * @param stockDetailsList
	 */
	void writeStockDetails(List<Stock> stockDetailsList);
	/**
	 * It checks whether data is already cached and its not expired
	 * @return 
	 */
	boolean isFileCached();
}
