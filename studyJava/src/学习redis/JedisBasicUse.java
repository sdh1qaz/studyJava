package 学习redis;

import org.junit.Test;
import redis.clients.jedis.ShardedJedis;

/**
 * @ClassName： JedisBasicUse
 * @Author: dhSu
 * @Description:redis的java客户端jedis的基本使用
 * @Date:Created in 2019年6月12日
 */

public class JedisBasicUse {
	
	public static final ShardedJedis JEDIS = RedisUtils.getJedis();
	
	//操作string
	@Test
	public void jedisOperateString() {
		JEDIS.set("hello", "world");
		String res = JEDIS.get("hello");
		System.out.println(res);
	}
}
