# spring boot + mybatis
同事推荐了一个插件 mybatisX 
可以将dao层方法关联到mapper上的对应标签上。

idea中打插件的方法 File -> Settings -> Plugins 选下方的Browser Repositories 输入MybatisX找到对应的插件，打上就OK。

### 关于spring boot和mybatis
与spring boot jpa不同，mybatis需要我们通过一个.xml文件来和dao层的方法做映射。
如果对sql调优比较熟悉，这样的开发方式会提高效率。  
具体说一下：我们需要在resources文件夹下建立一个mapper的文件夹来存放我们的*mapper.xml。
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<!--namespace:绑定对应的dao层-->
<mapper namespace="com.chenzifeng.learn.dao.UserDao">
    <insert id="addUser"></insert>


    <delete id="deleteUser"></delete>

    <select id="getUser" resultType="org.json.JSONObject">
        SELECT * FROM USER
        WHERE 1=1
        <if test="getUser!=null">
           AND  USERNAME =#{}
        </if>>

    </select>



</mapper>
```
需要注意的是mapper标签下的namespace的值应该关联到相应的Dao接口，根据Dao层方法分为（insert，update，delete，select）



### JavaBean实现Serializable接口
javabean实现该接口的目的是为了持久化