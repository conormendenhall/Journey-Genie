package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer{
	private static PrintWriter p;
	
	public static void startPrinter() {
		FileWriter w = null;
		boolean ret = false;
		try {
			w = new FileWriter("index.html", ret);
		} catch (IOException e) {
		}
		BufferedWriter bw = new BufferedWriter(w);
		p = new PrintWriter(bw);
	}
	
	public static void closePrinter() throws IOException {
		p.close();
	}
	
	public static PrintWriter getPrinter()
	{
		return p;
	}
}
