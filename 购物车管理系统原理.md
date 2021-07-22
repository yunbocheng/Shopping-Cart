## 1.HttpSession接口

1. 介绍：

    1. HttpSession接口来源于Servlet规范下一个接口。存在于Tomcat中servlet-api.jar

       其实现类由Http服务器提供。Tomcat提供实现类存在于servlet-api.jar。

       	2. 如果两个Servlet来自于同一个网站，并且为同一个浏览器/用户提供服务，

       此时借助于HttpSession对象进行数据共享。

       	3. 开发人员习惯讲HttpSession接口修饰对象称为【会话作用域对象】 

2. HttpSession 与 Cookie 区别：【面试题】

    1. 存储位置：

       Cookie：存放在客户端计算机（浏览器内存/硬盘）

       HttpSession：存放在服务端计算机内存

    2. 数据类型：

       Cookie对象存储共享数据类型只能是String

       HttpSession对象可以存储任意类型的共享数据Object

    3. 数据数量

       一个Cookie对象只能存储一个共享数据，只能存放一个键值对

       Cookie相当于一个小盒子，只能存放String

       HttpSession使用map集合存储共享数据，所以可以存储任意数量共享数据

       HttpSession相当于一个大盒子，可以存储任意的数据类型。

    4. 参照物

       Cookie相当于客户在服务端【会员卡】

       HttpSession相当于客户在服务端【私人保险柜】

    5. 命令实现：

       ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210722095804.png)

       ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210722095934.png)

    6. Http服务器如何将用户与HttpSession关联起来 : Cookie

    7. getSession() 与 getSession(false)  的区别

        1. getSession():如果当前用户在服务端已经拥有了自己的私人储物柜，

           要求Tomcat将这个私人储物柜进行返回

           如果当前用户在服务端未拥有自己的私人储物柜，

           要求Tomcat为当前用户创建一个全新的私人储物柜。

        2. getSession(false)  ：如果当前用户在服务端已经拥有了自己的私人储物柜，

           要求Tomcat将这个私人储物柜进行返回。

           如果当前用户在服务端未拥有自己的私人储物柜，

           此时Tomcat将返回null。

    8. HttpSession销毁时机：

        1. 用户与HttpSession关联时使用的Cookie只能存放在浏览器缓存中

        2. 在浏览器关闭时，意味着用户与他的HttpSession关系被切断。

        3. 由于Tomcat无法检测浏览器何时关闭，因此子啊浏览器关闭时并不会

           导致Tomcat将浏览器关联的HttpSession进行销毁。

        4. 为了解决这个问题，Tomcat为每一个HttpSession对象设置【空闲时间】

           这个空闲时间默认为30分钟，如果当前HttpSession对象空闲时间达到30分钟

           此时Tomcat认为用户已经放弃了自己的HttpSession，此时Tomcat就会销毁

           掉这个HttpSession。

    9. HttpSession空闲时间的手动设置

       在当前网站/web/WEB-INF/web.xml

       ```xml
       <session-config>   
        <!--当前网站中最大的空闲时间为5分钟-->   
        <session-timeout>5</session-timeout>
       </session-config>
       ```



## 2.购物车管理系统演示HttpSession接口用法

1. 工作原理图
   ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210722140616.png)