package basic;

import cn.hutool.core.util.ReUtil;

public class reg {
	
	
	
	public static void main(String[] args) {
		
		String  content  = "a2bxc";
		
		String regex = "(a|b)+[0-9]*.c";
		
		Object res = ReUtil.get(regex, content, 0);
		System.out.println(res);
		
		
	}

}
