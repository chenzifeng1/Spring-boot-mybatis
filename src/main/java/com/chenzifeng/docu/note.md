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
<mapper namespace="与之绑定的Dao接口">
    <!--resultMap：这个是定义sql查询返回的结果. type字段是标识将该结果应该被包装为何种类型 公司一般使用JSONObject或者与特定的bean进行绑定-->
    <resultMap id="唯一标识接收类的id（自己根据需求定义）" type="com.alibaba.fastjson.JSONObject">
        <id column="id" property="id"/>
        <result  column="数据库字段" property="返回结果中与该数据库字段对应的类的字段" javaType="property的类型"/>
    </resultMap>


    <insert id="addUser" useGeneratedKeys="true" keyProperty="id">
        <!--insert Sql-->
    </insert>


    <delete id="deleteUser">
        <!--delete sql-->
    </delete>

    <select id="getUser" resultType="org.json.JSONObject">
        <!--select sql-->
        <foreach collection="list/array/paramName" item="自定义循环内的元素名" index="索引" separator=",">
        
        </foreach>
    </select>

    <update id="updateUser">
        <!--update sql-->
    </update>

</mapper>
```
需要注意的是mapper标签下的namespace的值应该关联到相应的Dao接口，根据Dao层方法分为（insert，update，delete，select）
四种方法中必有字段是id，对应的是Dao层的方法。另外还有其他一些差别：
1. insert标签里面独有的是```useGeneratedKeys="true" keyProperty="id"``` 用来标注插入记录主键自增  
2. select标签里面需要标注返回结果的类型 ```resultType="org.json.JSONObject"```
3. delete返回结果是int型，根据返回值来判断记录是否删除成功
4. resultType是sql映射文件中定义返回值类型 
   resultType:
   
   1、基本类型  ：resultType=基本类型
   
   2、List类型：   resultType=List中元素的类型
   
   3、Map类型     resultType =map

注： 
    
    <resultMap> 
            <result column = "@解释1" property ="@解释2" />
    </resultMap>

解释1： column是数据库查询返回结果的字段名，但是有时候连表查询时可能会为查询字段起个别名，故此时column为别名的名称。
解释2： property是实体类定义对象的名称。当我们用JSONObject时，会被自动装配为key的名称，其值为查询的value。

    <foreach collection="list/array/paramName" item="自定义循环内的元素名" index="索引" separator=",">
    </foreach>
解释1：在insert实现批量插入 可以使用foreach标签来实现。collection对应Dao层方法的集合类参数，有一下两种情况：  
    1. 集合类参数是唯一参数：那么Collection的value就是list或是array,list对list，数组对array
    2. 集合类参数不是唯一参数，但是集合类参数被注解@Param("paramName")标注，则collection的value就是注解内的"paramName"

查询中，foreach的用法参考
```xml
    <select id="getPermissionCodeById" resultType="java.lang.String">
      SELECT permission_code
      FROM   permission
      WHERE id IN
      <foreach collection="list" item="item" open="(" separator="," close=")">
          #{item}
      </foreach>
    </select>
```
### JavaBean实现Serializable接口
javabean实现该接口的目的是为了持久化，javabean需要写一个空构造方法。