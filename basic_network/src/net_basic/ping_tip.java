package net_basic;

import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ping_tip {
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("ping" + " 135.1.237.212"); //invoke the windows command ping via Runtime...
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		String  line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null) {
			if(line.length() != 0) {
				sb.append(line + "\r\n");
			}
		}
		System.out.println("Return Message are: ");
		System.out.println(sb.toString());
	}
}
