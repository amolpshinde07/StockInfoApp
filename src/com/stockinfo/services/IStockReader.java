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

	List<Stock> getStockList(List<String> symbolList);

	Stock getStock(String symbol);

	JSONObject getStockJSON(String symbol) throws MalformedURLException,IOException, ParseException;

}
