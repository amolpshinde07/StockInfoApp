/**
 * 
 */
package com.stockinfo.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.stockinfo.entities.Stock;
import com.stockinfo.services.IStockReader;
import com.stockinfo.util.Keys;
import com.stockinfo.util.StockUtil;

/**
 * @author amol.shinde
 *
 */
public class StockReaderImpl implements IStockReader {
//	private final Logger logger = Logger.getLogger(StockReaderImpl.class.getName());
	
	private String urlWithSymbolAsParameter;
	
	public StockReaderImpl(String urlWithSymbolAsParameter) {
		this.setUrlWithSymbolAsParameter(urlWithSymbolAsParameter);
	}
	/* (non-Javadoc)
	 * @see com.stockinfo.services.IStockReader#getStockList(java.util.List)
	 */
	@Override
	public List<Stock> getStockList(List<String> symbolList) {
		if(symbolList==null){
			return null;
		}
		List<Stock> stockDetailsList = new ArrayList<Stock>();
		Consumer<? super String> action = eachSymbol->{
			if(eachSymbol!=null && !eachSymbol.trim().isEmpty()){
				stockDetailsList.add(getStock(eachSymbol));
			}
		};
		symbolList.stream().parallel().forEach(action);
//		System.out.println("Time required to fetch all stocks is '"+(totalOnlyQueryTime/1000)+"' Second");
		return stockDetailsList;
	}
	/* (non-Javadoc)
	 * @see com.stockinfo.services.IStockReader#getStock(java.lang.String)
	 */
	@Override
	public Stock getStock(String stockCompSymbol) {  
		try {
			String symbol = stockCompSymbol.toUpperCase();
			JSONObject json = getStockJSON(symbol);

			JSONObject queryObj = StockUtil.getJSONObjectForKey(json, Keys.RESPONSE_HEAD_KEY);
			JSONObject resultsObj = StockUtil.getJSONObjectForKey(queryObj, Keys.RESULTS_KEY);
			JSONObject quoteObj = StockUtil.getJSONObjectForKey(resultsObj, Keys.QUOTE_KEY);

			String name = StockUtil.getValueFromJSONObject(quoteObj, Keys.NAME_KEY);

			String stockPrice = StockUtil.getValueFromJSONObject(quoteObj, Keys.STOCK_PRICE_KEY);

			String yearTargetPrice = StockUtil.getValueFromJSONObject(quoteObj, Keys.YEAR_TARGET_PRICE_KEY);

			String yearHigh = StockUtil.getValueFromJSONObject(quoteObj, Keys.YEAR_HIGH_KEY);

			String yearLow = StockUtil.getValueFromJSONObject(quoteObj, Keys.YEAR_LOW_KEY);

			return new Stock(symbol,name,stockPrice,yearTargetPrice,yearLow,yearHigh);
		} catch (ParseException | IOException e) {
			return null;
		}
	}
	/**
	 * @param symbol
	 * @param urlWithSymbolAsParameter TODO
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ParseException 
	 */
	public JSONObject getStockJSON(String symbol) throws MalformedURLException, IOException, ParseException {
//		long startTime = System.currentTimeMillis();

		String urlStr = java.text.MessageFormat.format(getUrlWithSymbolAsParameter(),new Object[]{symbol});
		URL yahoo = new URL(urlStr);
		URLConnection connection = yahoo.openConnection(); 
		InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());
		BufferedReader reader = new BufferedReader(inputStream);  
		String responseLine = reader.readLine();
		reader.close();
		inputStream.close();

//		long eachQueryTime = System.currentTimeMillis()-startTime;
//		System.out.println("Each query time required [getStockJSON]"+(eachQueryTime));

		JSONParser parser = new JSONParser(); 
		return (JSONObject) parser.parse(responseLine);
	}
	
	public JSONObject getStockJSONHttpURLConnection(String symbol) throws MalformedURLException, IOException, ParseException {
//		long startTime = System.currentTimeMillis();

		String urlStr = java.text.MessageFormat.format(getUrlWithSymbolAsParameter(),new Object[]{symbol});
		URL obj = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
	    
//		long eachQueryTime = System.currentTimeMillis()-startTime;
//		System.out.println("Each query time required [getStockJSON2] "+(eachQueryTime));

		JSONParser parser = new JSONParser(); 
		return (JSONObject) parser.parse(response.toString());
	}
	public String getUrlWithSymbolAsParameter() {
		return urlWithSymbolAsParameter;
	}
	public void setUrlWithSymbolAsParameter(String urlWithSymbolAsParameter) {
		this.urlWithSymbolAsParameter = urlWithSymbolAsParameter;
	}

}
