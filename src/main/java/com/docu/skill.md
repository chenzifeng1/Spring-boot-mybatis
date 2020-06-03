# 开放中可能使用的小技巧

1. 修改JSON对象中的key对应的value数据,由于```com.alibaba.fastjson.JSONObject```底层存储实现是一个
```final Map<String, Object> map``` 故不需要再将JSON对象转为map，便可以直接通过Json对象的put方法，通过设置相同的key来修改对应的value。  