ch07-spring-mybatis

步骤：
1.新建maven项目
2、加入maven的依赖
  1）spring依赖
  2）mybatis依赖
  3）mysql依赖
  4）spring的事务依赖
  5）mybatis和spring集成的依赖；mybatis
3、创建实体类
4、创建dao接口和mapper文件
5、创建mybatis主配置文件
6、创建Service接口和实现类。属性是dao
7、创建spring的配置文件，声明mybatis对象
 1）数据源  DataSource
 2）SqlSessionFactory
 3)Dao对象
 4）声明定义的service

 8、创建测试类，获取Service对象，通过service调用dao完成数据库的访问