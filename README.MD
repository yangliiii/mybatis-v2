MyBatis-v2

一、MyBatis环境搭建
1、添加jar包 ：主要包含 mybatis slf4j 数据库连接驱动包
2、MyBatis配置文件 - configeration
3、实体类 Mapper接口 mapper.xml文件 （以上可通过逆向工程实现）
4、代码：加载配置文件，生成sqlsession实例。
    SqlSessionFactoryBuilder -  SqlSessionFactory - SqlSession
    SqlSession为接口，其实现类一般为DefaultSqlSession