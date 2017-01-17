### **邮件系统**

&#8195;&#8195;该系统可以进行简单的收发邮件以及查看详情。

&#8195;&#8195;运行在Tomcat8.0之上。

- pom.xml中有该系统需要依赖的包，tomcat中的servlet-api包需要自己添加。
- src中的java为java代码，为本系统后台代码。
- src中的resources中文件为资源文件。
- src中的webapp下为前端相关代码。

#### **成果展示**

登录界面

![登录界面](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/1.png)

登录后展示收信箱

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/2.png)

进行发送邮件，向我的QQ邮箱发送邮件

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/3.png)

QQ邮箱收信结果如下

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/4.png)

发信箱进行更新，并查看详情

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/5.png)

使用QQ邮箱对本系统发送邮件

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/6.png)

前端收到邮件，响应

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/7.png)

查看收信箱，出现最新邮箱

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/8.png)

查看详情

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/9.png)

在个人中心修改个人资料，修改昵称

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/10.png)

修改成功后，右上角用户昵称也进行修改

![收信箱](https://github.com/yangliu0/myEmail/blob/master/src/main/webapp/img/11.png)

- 本系统后端使用Spring、Spring MVC、Mybatis。
- 数据库使用mysql，数据库名为email，数据库表在webapp/sql中。
- 查看详情由于我修改了tomcat端口为18080，所以需要在代码中将修改发信箱和收信箱查看详情的地址。
- 发信使用SMTP协议、收信使用POP3协议。
- 发信和收信分别使用的是新浪的STMP服务器和POP服务器，需要在新浪邮箱中手动开始，POP3也需要手动开启。
- 发信的bean在spring-mybatis.xml内，收信基本信息填写在java/svr/imp/ReceiveMailServiceImp.java中。
- 编辑器使用的是ueditor。发送html格式的邮件。