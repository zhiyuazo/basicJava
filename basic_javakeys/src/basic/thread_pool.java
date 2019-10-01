package basic;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.hutool.core.util.RandomUtil;

public class thread_pool {
	
	
	public static void main(String[] args) {
		ThreadPoolExecutor  tp = new ThreadPoolExecutor(10, 
														15, 
														65, 
														TimeUnit.SECONDS, 
														new LinkedBlockingDeque<Runnable>());
		Runnable r = new Runnable() {
				public void run() {
					String word = RandomUtil.randomString(3);
					while(true) {
						System.out.println(Thread.currentThread().getName() + " says: " + word);
					}
				}
		};
		for (int i = 0; i < 100; i++) {
			tp.execute(r);
		}
	}
}
