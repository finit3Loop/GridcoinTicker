/*
	 * Stolen from http://xml.nig.ac.jp/tutorial/rest/index.html
	 * and http://www.dr-chuck.com/csev-blog/2007/09/calling-rest-web-services-from-java/
*/

package com.jarret;

import java.io.*;
import java.net.*;

import javax.net.ssl.HttpsURLConnection;

public class APIGrabber {

	private static String APIkey = "993e0cb5-7605-4660-956e-7b9846ec9467";

	public void APIcall() throws IOException {
		HttpsURLConnection c = null;
		URL url = new URL("https://api.coinmarketcap.com/v1/ticker/gridcoin/");
		// String query = "id:GRC";

		// make connection
		// URLConnection urlc = url.openConnection();
		c = (HttpsURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.setRequestProperty("Content-length", "0");
		c.setUseCaches(false);
		c.setAllowUserInteraction(false);
		c.setConnectTimeout(100);
		c.setReadTimeout(500);
		c.connect();

		System.out.println((c.getResponseCode()));
		// urlc.setRequestProperty("Content-Type", "application/json");

		// urlc.getInputStream();
		// send query
		// PrintStream ps = new PrintStream(urlc.getOutputStream());
		// ps.print(query);
		// ps.close();

		// get result
		BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String l = null;

		while ((l = br.readLine()) != null) {
			System.out.println(l);
		}
		br.close();
		return;
	};

}
