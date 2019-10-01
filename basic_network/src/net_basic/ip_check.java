package net_basic;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ip_check {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress host = InetAddress.getLocalHost();
		String local_ip = host.getHostAddress();
		//String prefix = local_ip.substring(0,local_ip.lastIndexOf("."));
		String prefix = local_ip.split("\\.")[0] + "."+ local_ip.split("\\.")[1]+ "." +local_ip.split("\\.")[2];
		
		List<String> ips = Collections.synchronizedList(new ArrayList<>());
		
		ThreadPoolExecutor thread_pool = new ThreadPoolExecutor(10,15,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		AtomicInteger number = new AtomicInteger();
		
		for(int i=0; i<255 ;i++) {
			String tmp_ip = prefix + "." + String.valueOf(i+1);
			thread_pool.execute(new Runnable() {
				public void run() {
					boolean avaliable;
					try {
						avaliable = ping(tmp_ip);
						if(avaliable) {
							ips.add(tmp_ip);
							synchronized(number) {
								System.out.println("Complete " + number.incrementAndGet() + " ip-checking @" + Thread.currentThread().getName());
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		thread_pool.shutdown();
		if(thread_pool.awaitTermination(1, TimeUnit.HOURS)) {
			for(String i :ips) {
				System.out.println("Avaliable Address: " + i +"\r\n");
			}
			System.out.println("Totle avaliable ips: " + ips.size() +"\r\n");
		}
		
	}

	public static boolean ping(String ip) throws IOException {

		Process p = Runtime.getRuntime().exec("ping -n 1  -w 200" +" " + ip);
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		String line =null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine())!=null ) {
			if(line.length()!= 0) {
				sb.append(line + "\r\n");
				//System.out.println("Avaliable Address: " + tmp_ip +"\r\n");
			}
		}
		if(sb.toString().contains("TTL")){
			br.close();
			return true;
		}
		return false;
	}	
}

