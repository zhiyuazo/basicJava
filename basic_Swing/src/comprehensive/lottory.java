package comprehensive;

import java.util.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.lang.*;



public class lottory {
	
	public static void main(String[] args) {
		
		String lucky = "lucky: ";
		Random r = new Random(110);
		for(int i = 0;i<6;i++) {
			int rnd_red = r.nextInt(33)+1;
			lucky = lucky.concat(","+ String.valueOf(rnd_red));
		}
		
		int rnd_blue = new Random().nextInt(16)+1;
		lucky = lucky.concat(","+ String.valueOf(rnd_blue));
		System.out.println(lucky);
	}
}
