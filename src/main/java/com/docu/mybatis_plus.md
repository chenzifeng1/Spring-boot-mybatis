# Mybatis-plus
本文记述一下spring boot集成mybatis-plus的相关内容  
mybatis-plus的[maven地址](https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter)
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.1.2</version>
</dependency>
```
### 项目包结构
#### entity
mybatis-plus的实体类通过注释```@TableName("表名")```与数据库中的表进行映射  
```java
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;
@Data
@TableName("test_station")
public class StationEntity {

    @TableId
    private int id;

    @TableField(exist = false)
    private List<String> tankCodes;

    @TableField("STATION_NAME")
    private String name;

    private int stationCode;
    private int orgId;
    private String orgName;
    private int orgCode;
    
}
```
注解解释：  
```@Data```:lombok的该注解会在编译期间为我们的类加上这些方法：1. 所有属性的get/set方法 2.toString() 3. hashCode() 4. equals()  
```@TableName("表名")```:mybatis-plus的该注解会将该实体类与配置文件中数据库的表做映射，属性名与数据库中字段以驼峰的格式做映射
```@TanleId```:表明该字段是主键id
```@TableField```:当我们没有和数据库字段以驼峰格式映射时就可以在该标签上手动将属性绑定到字段上，注解的标签*exist*是表明该属性是否为数据库中的字段
 
