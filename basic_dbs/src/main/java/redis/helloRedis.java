package redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class helloRedis {
	JedisPool pool;
	Jedis jr;
	
	@Before 
	public void setUp() {
		jr = new Jedis("www.coolidea.store");
		jr.auth("zzy-redis");
		jr.select(1);
		System.out.println("Connect to Redis@www.coolidea.com OK..");
	}
	
	@Test
	public void TestString() {
		jr.set("name","meepo"); 
		System.out.println(jr.get("name"));
		jr.append("name","dota"); 
		System.out.println(jr.get("name")); 
		jr.set("name","poofu"); 
		System.out.println(jr.get("name"));
		jr.del("name"); 
		System.out.println(jr.get("name"));
		jr.mset("name","meepo","dota","poofu"); 
		System.out.println(jr.mget("name","dota")); 
	}
	
	@Test
	public void TestMap() {
		Map<String,String> user=new HashMap<String,String>(); 
        user.put("name","meepo"); 
        user.put("pwd","password"); 
        jr.hmset("user",user); 
        List<String> rsmap = jr.hmget("user", "name"); 
        System.out.println(rsmap); 
        System.out.println(jr.hmget("user", "pwd"));
        System.out.println(jr.hlen("user")); 
        System.out.println(jr.exists("user")); 
        System.out.println(jr.hkeys("user")); 
        System.out.println(jr.hvals("user")); 
        Iterator<String> iter=jr.hkeys("user").iterator(); 
        while (iter.hasNext()){ 
            String key = iter.next(); 
            System.out.println(key+":"+jr.hmget("user",key)); 
        }  
	}
	
	@Test
	public void TestList() {
	   jr.del("java framework"); 
	   System.out.println(jr.lrange("java framework",0,-1)); 
	   jr.lpush("java framework","spring"); 
	   jr.lpush("java framework","struts"); 
	   jr.lpush("java framework","hibernate"); 
	   System.out.println(jr.lrange("java framework",0,-1));  
	}
	
	@Test
	public void TestSet() {
	   jr.sadd("sname","meepo"); 
       jr.sadd("sname","dota"); 
       jr.sadd("sname","poofu"); 
       jr.sadd("sname","noname");
       jr.srem("sname","noname"); 
       System.out.println(jr.smembers("sname")); 
       System.out.println(jr.sismember("sname", "meepo")); 
       System.out.println(jr.srandmember("sname")); 
       System.out.println(jr.scard("sname")); 
	}  
}
