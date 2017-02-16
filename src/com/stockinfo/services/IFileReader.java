/**
 * 
 */
package com.stockinfo.services;

import java.util.List;

/**
 * @author amol.shinde
 *
 */
public interface IFileReader {

	/**
	 * It reads symbols from stock.txt
	 * @return
	 */
	List<String> getListOfSymbolsFromFile();

}
