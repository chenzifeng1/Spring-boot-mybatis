出现过的bug
1. IllegalArgumentException: argument type mismatch
    可能出现的问题: 对应Controller的方法接收JSONObject时可能没有加@RequestBody注解
    
2. Invalid bound statement (not found): 某个Dao类
    可能出现的问题：  
    1. mapper.xml中的namespace写错，没有和对应的Dao类绑定
    2. mapper.xml中的操作标签内的id写错，没有和对应Dao类的方法名绑定
    3. mapper.xml文件名写错，文件名格式为XXMapper.xml，不能写错，不然扫描器会忽略该文件
                 
3. incorrect string value: '\xE7\x94\xA8\xE6\x88\xB7...' for column 'menu_name' at row 1
    可能出现的问题：数据库编码问题
    解决方案： 去设置数据库表的编码，我使用的是Navicat，不知道为什么改了数据库或表的字符集但是没改掉字段的字符集。所以花了一些时间。
            另外就是在application.yml中关于数据库驱动后面加字符集```jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8```
            
4.  遇到过为数不多的由于依赖冲突所引起的错误，这个错误是由pom.xml文件中<parent>标签中的版本与<jaws>依赖包版本冲突了
```
Description:

The Bean Validation API is on the classpath but no implementation could be found

Action:

Add an implementation, such as Hibernate Validator, to the classpath
```  
  解决方法:从[这篇博客](https://blog.csdn.net/Jerry_liu20080504/article/details/84287009)找到的
                            