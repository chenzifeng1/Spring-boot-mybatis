# 索引调优

### 可能导致查询不走索引的情况

参考博客:  
[sql中索引不会被用到的几种情况](https://www.cnblogs.com/xuyou551/p/9482315.html)

对于 开放区间的查询 （!=或<>）可能或导致索引字段不走索引，
改为between

```TIME <![CDATA[ >= ]]> #{startTime} AND TIME <![CDATA[ <= ]]> #{endTime}```   
改为
```sql
TIME BETWEEN #{startTime} AND #{endTime}
```
如果还不走索引，进行细化分段或者是“逐条提取+批绑定”

具体措施-分段：
根据STATION_CODE 分段



具体措施-逐条提取+批绑定：


```sql
ORDER BY TIME DESC 
```
这里在查询之后会再次对所有结果进行一次排序，需要优化
```sql
order by STATION_CODE, TANK_CODE, TIME 
```

建立组合索引，但查询谓词并未使用组合索引的第一列，此处有一个INDEX SKIP SCAN概念,

[SQL常见优化Sql查询性能的方法](https://www.cnblogs.com/williamjie/p/9389530.html)


可以使用EXPLAIN命令来查看查询语句具体执行信息，从中获得可能优化的地方
[EXPLAIN命令介绍](https://www.cnblogs.com/DreamDrive/p/7752960.html)


查询谓词 