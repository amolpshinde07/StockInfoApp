package com.stockinfo.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.stockinfo.entities.Stock;

/**
 * @author amol.shinde
 *
 */
public interface IStockReader {

	/**
	 * It find out Stock for provided symbol list
	 * @param symbolList
	 * @return
	 */
	List<Stock> getStockList(List<String> symbolList);

	/**
	 * It return Stock details for single symbol
	 * @param symbol
	 * @return
	 */
	Stock getStock(String symbol);

	/**
	 * It return Stock details in the form of JSONObject for single symbol
	 * @param symbol
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ParseException
	 */
	JSONObject getStockJSON(String symbol) throws MalformedURLException,IOException, ParseException;

}
