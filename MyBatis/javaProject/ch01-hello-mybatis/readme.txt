ch01-hello-mybatis

实现步骤：
1.新建的student表
2.加入maven的MyBatis坐标，MyBatis驱动的坐标
3.创建实体类，Student--保存表中的一行数据
4.创建持久层的dao接口，定义操作数据库的方法
5.创建一个MyBatis使用的配置文件
  叫做sql映射文件：写sql语句的。一般一个表一个sql映射文件
  这个文件是xml文件
  （写在接口所在的目录中，名称和接口保持一致）
6.创建MyBatis的主配文件：
  一个项目就一个主配置文件。
  主配置文件提供了数据库的连接信息和sql映射文件的位置信息
7.创建使用mybatis类
  通过MyBatis访问数据库