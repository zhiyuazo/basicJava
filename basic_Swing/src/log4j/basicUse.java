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
		LOG.trace("������Ϣ");
		LOG.debug("������Ϣ");
		LOG.info("�����Ϣ");
		Thread.sleep(1000);
		LOG.warn("������Ϣ");
		LOG.error("������Ϣ");
		LOG.fatal("������Ϣ");
		
	}	
}
