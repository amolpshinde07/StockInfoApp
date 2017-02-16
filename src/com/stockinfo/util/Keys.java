package com.stockinfo.util;

/**
 * @author amol.shinde
 *
 */
public class Keys {
	public static final String INPUT_STOCKS_TXT = "stocks.txt";
	public static final String URL_WITH_SYMBOL_AS_PARAMETER="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22{0}%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
	public static final String CSV_HEADER = "Stock Symbol,Current Price,Year Target Price,Year High,Year Low";
	public static final String OUTPUT_CSV = "output.csv";
	public static final String CSV_SEPARATOR = ",";
	public static final String BACK_SLASH_SEPARATOR = "\"\"";
	public static final String BACK_SLASH = "\"";
	public static final String NEW_LINE = "\n";
	public static final String NAME_KEY = "Name";
	public static final String YEAR_LOW_KEY = "YearLow";
	public static final String YEAR_HIGH_KEY = "YearHigh";
	public static final String YEAR_TARGET_PRICE_KEY = "PriceEPSEstimateCurrentYear";
	public static final String STOCK_PRICE_KEY = "Bid";
	public static final String QUOTE_KEY = "quote";
	public static final String RESULTS_KEY = "results";
	public static final String RESPONSE_HEAD_KEY = "query";
}
