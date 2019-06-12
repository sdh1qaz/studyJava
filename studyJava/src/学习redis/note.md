0.jedis依赖
<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.0.1</version>
</dependency>


1.本地redis信息（戴尔电脑dhsu2上安装的）

	1.地址     D:\Redis-x64-3.2.100
		
	2.端口     6379

	3.运行服务  redis-server.exe redis.windows.conf

	4. redis-cli.exe -h 127.0.0.1 -p 6379

	5.设置键值对  set myKey abc

	6.取出键值对  get myKey

	7.初始化Redis密码：

	   在配置文件中有个参数： requirepass  这个就是配置redis访问密码的参数；

	   比如 requirepass test123；

	   （Ps:需重启Redis才能生效）

	8.(error) NOAUTH Authentication required的问题
	   设置了认证密码，输入密码就可以了。
	   auth test123

	9.检测本地redis服务是否启动
	   ping    返回pong则正常 可能取自谐音乒乓