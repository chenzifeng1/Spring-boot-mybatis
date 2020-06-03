package com.chenzifeng.learn.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Permissions;
import com.chenzifeng.learn.bean.Role;
import com.chenzifeng.learn.bean.User;
import com.chenzifeng.learn.dao.UserDao;
import com.chenzifeng.learn.service.LoginService;
import com.chenzifeng.learn.service.PermissionService;
import com.chenzifeng.learn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * SecurityManager需要到Realm中去验证用户信息，所以为SecurityManager创建Realm
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Session session = SecurityUtils.getSubject().getSession();


        logger.info("realm中doGetAuthorizationInfo得session=======:" + session.getId());
        // 获取登录用户信息
        // 传进来的参数principalCollection是一个登录用户Object的集合，我们用getPrimaryPrincipal()方法获取当前登录者的对象，
        // 但由于是个Object类，所以我们将它强转为User，或者是本来的传递参数principalCollection中就已经封装了一个上转型为Object的User对象
        User user = (User) principalCollection.getPrimaryPrincipal();

        // 我们在登录的时候把用户信息存session，session里面包含username，role，或者不需要role直接存permission
        // session里面不存密码，这样我们在这里从session里面直接拿这些信息即可

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("username", user.getUsername());
        jsonObject.put("userId", user.getId());
        //在这里可以向Session里面添加一些用户信息
        session.setAttribute("username", user.getUsername());
        session.setAttribute("userId", user.getId());

        // 根据用户名去数据库查询用户信息
        JSONObject permissions1 = permissionService.getUserPermissions(jsonObject);
        // 添加角色和权限
        // **************************************此处有问题*************************************
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<String> permissionCode = (List<String>) permissions1.get("permissionCode");
        if (permissionCode.size() > 0) {
            for (String p : permissionCode) {
                simpleAuthorizationInfo.addStringPermission(p);
                logger.info(p);
            }
            session.setAttribute("permissionCode", permissionCode);
        } else {
            // 如果登录用户没有任何权限，则默认为游客权限，只能访问部分接口。
            simpleAuthorizationInfo.addStringPermission("visitor:visit");
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1. 获取用户输入的账号
        String username = (String) token.getPrincipal();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);

        // 2. 通过username从数据库中获取到user的实体
        User user = userService.getUserByName(jsonObject);
        ;
        if (null == user) {
            return null;
        }
        // 3. 通过SimpleAuthenticationInfo做身份处理
        // 该构造方法的第一个参数是 从数据库获取的User对象
        //           第二个参数是 数据库获取的密码
        //           第三个参数是 当前Realm的名称
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user, user.getPassword(), user.getUsername());

        // 4. 应该验证用户账号状态：比如说已被禁用则不能登录 但是这里暂不考虑

        // 5. 返回用户身份信息
        return simpleAuthenticationInfo;

    }
}
