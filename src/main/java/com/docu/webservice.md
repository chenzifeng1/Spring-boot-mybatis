# webservice

## @WebService注解  
(实现类上可以不加该注解)字段解释：  

1. serviceName： 对外发布的服务名，指定 Web Service 的服务名称：wsdl:service。缺省值为 Java 类的简单名称 + Service。  
2. endpointInterface： 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
3. name：此属性的值包含XML Web Service的名称。在默认情况下，该值是实现XML Web Service的类的名称，wsdl:portType 的名称。缺省值为 Java 类或接口的非限定名称。
4. targetNamespace：指定你想要的名称空间，默认是使用接口实现类的包名的反缀
5.  6、wsdlLocation：指定用于定义 Web Service 的 WSDL 文档的 Web 地址。Web 地址可以是相对路径或绝对路径。

wsdl页面中 portType标签的name 是发布的服务的名字  
里面的operation的name是服务提供的方法名。  

## 复杂对象
webservice传递对象的时候，如果传递的类的属性与xml中的属性进行了绑定，我们可以在wsdl中查看类的属性和xml元素的映射时，传递对象时就不需要序列化。  
如果传递对象流时，没有绑定xml元素，这时候对象需要进行序列化。

## Apache CXF核心架构

Apache CXF 主要由以下组件构成：
- 总线(Bus)组件
- 前段编程(Frontend)模型
- 消息(Message)和拦截器(Interceptors)组件
- 服务模型(Service Mode)组件
- 数据绑定(Data Bindings)组件
- WSDL绑定(WSDL Bindings)组件
- 传输协议(Transport)组件
- Apache CXF注释组件

#### 组件介绍：
1. Bus: CXF架构的主干，为共享资源提供一个可配置的场所，作用类似于Spring的ApplicationContext。
共享资源包括WSDL管理器、绑定工厂等。默认Bus实现基于Spring框架，通过依赖注入，在运行时将组件串联起来。
2. Frontend: 为CXF提供创建服务的编程模型，当前主要前段是JAX-WS。可以看一下客户端创建service接收器时都是使用的jaxws开头的类。
3. Messaging and Interceptor: CXF建立在一个通用消息层上，主要由消息、拦截器和拦截器链(InterceptorChain)组成。拦截器主要有
两个方法：handleMessage和handleFault，分别对应消息处理和错误处理。在开发拦截器时注意两点：拦截器不是线程安全的，不要定义实例并使用；
不要调用下一个拦截器的handleMessage或handleFault，这个工作由InterceptorChain来完成。
4. Service Model: CXF服务通过服务模型来表示，主要有两部分:ServiceInfo和服务本身，ServiceInfo作用类似WSDL,包含接口信息、绑定、端点(EndPoint)等信息。
服务则包含ServiceInfo、数据绑定、拦截器和服务属性等信息。可使用Java类和WSDL来创建服务。
5. Bindings:提供传输过程中映射的具体格式和协议方法，主要的两个类是Binding和BindingFactory。BindingFactory负责创建Binding
6. Transport: CXF提供自己的传输协议抽象，主要有两个对象:Conduit和Destination。前者是消息发送的基础，后者对应消息接收。开发者可以给Conduit和Destination
注册MessageObserver（观察者），以便在消息发送和接收时得到通知。

#### 使用总结
进行spring boot整合cxf开发时，踩到几个大坑：
1. 依赖版本冲突问题：spring boot通过parent设置spring组件的版本，会同jaxws(cxf的前端编程模型)的版本产生冲突。目前我使用的pom.xml配置见下方
```xml
<projects>
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.3.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<dependency>
			<groupId>org.apache.cxf</groupId>
			<artifactId>cxf-spring-boot-starter-jaxws</artifactId>
			<version>3.2.5</version>
		</dependency>
		<dependency>
			<groupId>org.apache.cxf</groupId>
			<artifactId>cxf-rt-transports-http</artifactId>
			<version>3.2.5</version>
		</dependency>

	</dependencies>
	</projects>
```
spring 组件版本是2.0.3，而jaxws的版本是3.2.5。引入的cxf依赖包是```cxf-spring-boot-starter-jaxws```,这个依赖包适用于spring boot整合cxf使用。

另一个就是关于服务找不到的问题以及bus无法自动注入的问题。这两个问题都是因为引用依赖不恰当导致的。
我之前用的jaxws依赖包是```cxf-core```，使用这个依赖包spring框架是没办法自动注入Bus的，要手动实现一个bean。
因为bus无法自动注入，所以就没法将服务自动配置到对应的url上去，故访问路径[http://localhost:8080/services/ServiceName?wsdl]()也就会报404错误了。
By the way，服务会被默认注册到```/services```路径上，故我们调用服务时需要在路径上加上。


