#LINUX换机下redis安装教程
###一、Redis介绍
Redis是当前比较热门的NOSQL系统之一，它是一个key-value存储系统。和Memcache类似，但很大程度补偿了Memcache的不足，它支持存储的value类型相对更多，包括string、list、set、zset和hash。这些数据类型都支持push/pop、add/remove及取交集并集和差集及更丰富的操作。在此基础上，Redis支持各种不同方式的排序。
和Memcache一样，Redis数据都是缓存在计算机内存中，不同的是，Memcache只能将数据缓存到内存中，无法自动定期写入硬盘，这就表示，一断电或重启，内存清空，数据丢失。所以Memcache的应用场景适用于缓存无需持久化的数据。而Redis不同的是它会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，实现数据的持久化。

###二、Redis安装
在线下载redis
http://download.redis.io/releases/redis-4.0.1.tar.gz
解压安装包
tar zxvf redis-3.2.1.tar.gz
cd redis-3.2.1
make && make install

###三、启动redis服务
cd src/
./redis-server redis.config


###四、启动redis客户端
cd ..
./redis-cl



linux匹配字符串
/daemonize


#####安装链接
https://blog.csdn.net/jc_benben/article/details/77140936

linux匹配字符串
/daemonize
