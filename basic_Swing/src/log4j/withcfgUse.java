package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class withcfgUse {

	static Logger  LOG = Logger.getLogger(withcfgUse.class);
	public static void main(String[] args) {
		//PropertyConfiguration correspond with properties-file
		PropertyConfigurator.configure("src/log4j/log4j.properties");
		  for (int i = 0; i < 5; i++) {
	            LOG.trace("������Ϣ");
	            LOG.debug("������Ϣ");
	            LOG.info("�����Ϣ");
	            LOG.warn("������Ϣ");
	            LOG.error("������Ϣ");
	            LOG.fatal("������Ϣ");
	        }
	}
}
