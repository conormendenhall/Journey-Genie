package travelApp;

import java.io.IOException;

import servlets.APIcall;

public class MainMethod {

	public static void main(String[] args) throws IOException {
		String s = APIcall.callAPI();
		System.out.println(s);
	}

}
