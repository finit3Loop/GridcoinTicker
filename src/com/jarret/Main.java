package com.jarret;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		APIGrabber Crypto = new APIGrabber();
		try {
			double price = Double.parseDouble(Crypto.APIcall());
			System.out.println(Crypto.APIcall());

			Component CryptoQuote = new TextArea(Crypto.APIcall());
			CryptoQuote.setFont(new Font("Dialog", Font.BOLD, 26));

			Color color = new Color(0, 204, 204);

			JFrame ticker = new JFrame();
			ticker.setTitle("GRC ticker");
			ticker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ticker.setSize(400, 100);
			ticker.setResizable(false);
			ticker.add(CryptoQuote);
			ticker.setVisible(true);
			ticker.setBackground(Color.GREEN);

			// System.out.println("call done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
