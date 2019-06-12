package 学习redis;

import java.util.LinkedList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisUtils {
	
	private static ShardedJedisPool pool;
	
	static {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);//最大连接数
		config.setMaxIdle(50);//最大空闲数
		config.setMaxWaitMillis(3000);//最大等待时间
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		
		//可以有多个JedisShardInfo作为集群
		JedisShardInfo jedisShardInfo = new JedisShardInfo("127.0.0.1", 6379);
		jedisShardInfo.setPassword("test123");
		List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
		list.add(jedisShardInfo);
		pool = new ShardedJedisPool(config, list);
	}

	//从连接池中返回一个jedis连接对象
	public static ShardedJedis getJedis() {
		return pool.getResource();
	}
	
	public static void main(String[] args) {
		ShardedJedis jedis = pool.getResource();
		String keys = "myname";
		String vaule = jedis.set(keys, "lxr");
		System.out.println(vaule);
	}
}