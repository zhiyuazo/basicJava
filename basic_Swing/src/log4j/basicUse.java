package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class basicUse {

	
	static Logger LOG = Logger.getLogger(basicUse.class);
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Strat test....");
		
		BasicConfigurator.configure();
		LOG.setLevel(Level.DEBUG);
		LOG.trace("跟踪信息");
		LOG.debug("调试信息");
		LOG.info("输出信息");
		Thread.sleep(1000);
		LOG.warn("警告信息");
		LOG.error("错误信息");
		LOG.fatal("致命信息");
		
	}	
}
