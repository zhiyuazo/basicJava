package basic;

import java.util.LinkedList;

import cn.hutool.core.util.RandomUtil;

public class thread_pool_self {
    public static void main (String [] args)
    {
        thread_pool_draft tp = new thread_pool_draft();
        int rst = 1000;

        while(true){
            Runnable tmp = new Runnable(){
                public void run(){
                	String word = RandomUtil.randomString(5);
                    System.out.println("________________________Love is Forever..." + word);
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            };
            tp.add(tmp);
            try{
                Thread.sleep(rst);
                rst = rst>100 ?rst-100:rst;
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
    }

}

//自制线程池...
class thread_pool_draft{
    int size ; 
    LinkedList<Runnable> l = new LinkedList<>();
    
    public thread_pool_draft(){
        size =  10 ; 
        synchronized(l){
            for (int i=0;i<size;i++ ){
                new thread_consumer("thread-"+i+"-consume").start();
            }
        }
    }
    
    public void add(Runnable r){
        synchronized(l){
            l.add(r);
            l.notifyAll();
        }
    }

    class thread_consumer extends Thread{
        public thread_consumer(String name){
            super(name);
        }

        Runnable tmp;

        public void run(){
            System.out.println("Start:  "+this.getName());
            while(true){
                synchronized(l){
                    while(l.isEmpty()){
                        try{
                            l.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    tmp = l.removeLast();
                    l.notifyAll();
                }
                System.out.println(this.getName()+" get task and execute...");
                tmp.run();
            }
        }
    }

}
