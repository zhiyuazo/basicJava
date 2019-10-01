package basic;

import java.util.Random;

class java_heap {
    private String res;
    private int length;
    StringBuffer sb = new StringBuffer();
    public java_heap(int leng) {
        this.length = leng;
        int i = 0;
        while (i < leng) {
            i++;
            try {
                sb.append("a");
            } catch (OutOfMemoryError e) {
               e.printStackTrace();
               break;
            }
        }
        this.res = sb.toString();

    }

    public String getRes() {
        return res;
    }

    public int getLength() {
        return length;
    }

}

public class jvisual{
    public static void main(String[] args) {
    	System.out.println(new Random().nextInt(65) + 1);
    }
	
}