package com.stockinfo.util;

import java.io.IOException;
import java.io.Writer;

import org.json.simple.JSONObject;

/**
 * @author amol.shinde
 *
 */
public class StockUtil {
	
	public StockUtil() {
		
	}
	/**
	 * It converts JSONObject value for provided key into string
	 * @param quoteObj
	 * @param key TODO
	 * @return
	 */
	public static String getValueFromJSONObject(JSONObject quoteObj, String key) {
		Object obj = quoteObj.get(key);
		return obj==null?null:String.valueOf(obj);
	}
	/**
	 * It return JSONObject for provied Key
	 * @param json
	 * @param key TODO
	 * @return 
	 */
	public static JSONObject getJSONObjectForKey(JSONObject json, String key) {
		Object object = json.get(key);
		if(object!=null && object instanceof JSONObject){
			return (JSONObject) object;
		}
		return null;
	}
	/**
	 * It adds csv header into csv file
	 * @param writer
	 * @throws IOException
	 */
	public static void addCSVHeader(Writer writer) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(Keys.CSV_HEADER);
		sb.append(Keys.NEW_LINE);
		writer.append(sb.toString());
	}
	/**Replaces back slash with apropriate char
	 * @param value
	 * @return
	 */
	public static String replaceCSVChar(String value) {
		if (value.contains(Keys.BACK_SLASH)) {
			value = value.replace(Keys.BACK_SLASH, Keys.BACK_SLASH_SEPARATOR);
		}
		return value;
	}
	

}