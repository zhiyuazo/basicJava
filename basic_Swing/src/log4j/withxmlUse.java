package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class withxmlUse {
	static Logger  LOG = Logger.getLogger(withxmlUse.class);
	
	public static void main(String[] args) {
		//DOMConfiguration correspond with XML-file
		DOMConfigurator.configure("src/log4j/log4j.xml");
		  for (int i = 0; i < 5; i++) {
	            LOG.trace("跟踪信息");
	            LOG.debug("调试信息");
	            LOG.info("输出信息");
	            LOG.warn("警告信息");
	            LOG.error("错误信息");
	            LOG.fatal("致命信息");
	        }
		
	}
}
