package 学习redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.Tuple;

/**
 * @ClassName： JedisBasicUse
 * @Author: dhSu
 * @Description:redis的java客户端jedis的基本使用
 * @Date:Created in 2019年6月12日
 */

public class JedisBasicUse {
	
	public static final ShardedJedis JEDIS = RedisUtils.getJedis();
	
	/**
	* @Description:jedis操作String  
	 */
	@Test
	public void jedisOperateString() {
		JEDIS.set("hello", "world");
		String res = JEDIS.get("hello");
		System.out.println(res);
	}
	
	/**
	* @Description:jedis操作Hash
	 */
	@Test
	public void jedisOperateHash() {
		JEDIS.hset("myhash", "f1","v1");
		JEDIS.hset("myhash", "f2","v2");
		Map<String, String> map = JEDIS.hgetAll("myhash");
		System.out.println(map);
	}
	
	/**
	* @Description:jedis操作List
	 */
	@Test
	public void jedisOperateList() {
		JEDIS.rpush("mylist", "1");
		JEDIS.rpush("mylist", "2");
		JEDIS.rpush("mylist", "3");
		List<String> list = JEDIS.lrange("mylist", 0, 1);
		System.out.println(list);
	}
	
	/**
	* @Description:jedis操作Set
	 */
	@Test
	public void jedisOperateSet() {
		JEDIS.sadd("myset", "1");
		JEDIS.sadd("myset", "1");
		JEDIS.sadd("myset", "1");
		Set<String> set = JEDIS.smembers("myset");
		System.out.println(set);
	}
	
	/**
	* @Description:jedis操作zset
	 */
	@Test
	public void jedisOperateZset() {
		JEDIS.zadd("myZset", 1, "abc");
		JEDIS.zadd("myZset", 3, "bcd");
		JEDIS.zadd("myZset", 3, "efg");
		Set<Tuple> zset = JEDIS.zrangeWithScores("myZset", 0, -1);
		System.out.println(zset);
	}
	
	
	
	
	
}
