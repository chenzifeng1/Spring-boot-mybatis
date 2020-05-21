# shiro学习笔记

shiro是Apache下的一个开源项目，属于轻量级安全框架，相对spring security相对简单。

### shiro用户认证流程
1. 创建*SecurityManager*安全管理器
2. 主体*Subject*提交认证信息
3. *SecurityManager*安全管理器认证
4. *SecurityManager*调用*Authenticator*认证器认证
5. *Realm*验证

- Subject（主体）：代表了当前的用户；我们把所有的Subject绑定到SecurityManager，
与Subject的所有交互都委托给SecurityManager；可以把Subject认为是一个门面；SecurityManager才是实际的执行者。  
          
- SecurityManager（安全管理器）：所有与安全有关的操作都会与SecurityManager交互；并且管理着所有subject。

- Realm（域）：Shiro从Realm获取安全数据（用户，角色，权限）。即SecurityManager要进行用户身份验证，必须从Realm中获取
相应的用户进行比较来确定用户身份是否合法。也需要从Realm中得到用户相应的角色/权限来确定用户能否进行相应的操作。可以将Realm看做DataSource，即安全数据源           