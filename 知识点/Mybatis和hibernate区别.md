#Mybatie和Hibernate区别
###相同点：

（1）Hibernate与MyBatis都是通过SessionFactoryBuider由XML配置文件生成SessionFactory，由SessionFactory 生成Session，由Session来开启执行事务和SQL(Structured Query Language，结构化查询语言)语句。

（2）Hibernate和MyBatis都支持JDBC（Java DataBase Connectivity，java数据库连接）和JTA（Java Transaction API，Java事务API（Application Programming Interface，应用程序编程接口））事务处理。

注：jdbc和jta的主要作用是增强数据访问能力。

（3）基于ORM（Object Relational Mapping， 对象关系映射）思想解决了entity和数据库的映射问题



###不同点：

（1）sql方面：mybaits通过mapper.xml维护映射结果，程序员手动编写sql相比hibernate自动生成hql（hibernate sql）更加灵活，sql调优更加容易（hibernate因为更好的封装性，开发效率提高的同时，sql语句调优要更费力，当然可以手动修改sql来优化，但是同时也会影响开发效率）；hibernate的hql数据库移植性更好，体现在强壮性。hibernate在级联删除的时候效率低；数据量大， 表多的时候，基于关系操作会变得复杂。

（2）缓存方面：mybatis和hibernate都可以使用第三方缓存，而hibernate相比maybatis有更好的二级缓存机制。