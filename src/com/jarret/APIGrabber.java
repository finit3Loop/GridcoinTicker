package com.jarret;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class APIGrabber {




	public String APIcall() throws IOException {
		HttpsURLConnection connection = null;
		URL url = new URL("https://api.coinmarketcap.com/v1/ticker/gridcoin/");

		// make connection set properties
		connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-length", "0");
		connection.setUseCaches(false);
		connection.setAllowUserInteraction(false);
		connection.setConnectTimeout(100);
		connection.setReadTimeout(500);
		connection.connect();

		// print response code
		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {
			// get result
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String l = null;
			String retString = null;

			while ((l = br.readLine()) != null) {
				if (l.contains("price_usd") == true) {

					// String[] temp = new String[500];

					String[] temp = l.split("\"");
					
					//int length = temp.length;
					
					//System.out.println(length);
					/*
					 * System.out.println(temp[3] + "first"); for (int i = 0; i < temp.length; i++)
					 * { System.out.println(temp[i]); } ;
					 * 
					 * while (i <= 100) { System.out.println(temp[i]);
					 * 
					 * } ;
					 */

					retString = temp[3];
				}
			}
			br.close();
			return retString;
		} else {
			return "Someting is wrong";
		}
	}
};
