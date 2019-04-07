package com.jarret;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		APIGrabber Crypto = new APIGrabber();
		try {
			Crypto.APIcall();
			System.out.println("call done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
