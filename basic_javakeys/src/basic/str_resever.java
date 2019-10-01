package basic;

public class str_resever {
	
	public static void main(String[] args) {
		String a = "abcdefghijklmn";
		System.out.println(reverse(a));
		
		
		int b = 1;
		assert(b==0);
		
	}
	
	public static String  reverse(String s) {
		
		if(s==null || s.length()<=1) {
			return s;
		}
		
		return reverse(s.substring(1)) + s.charAt(0);
		
		
		
	}
	
}
