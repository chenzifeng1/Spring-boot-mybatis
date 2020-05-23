package com.chenzifeng.learn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.chenzifeng.learn.utils
 *
 * @author: chenzifeng
 *
 * @description: 服务器缓存管理
 *
 * @create: 2020-05-23 17:15
 **/

public class ManageCache {

    private static volatile ManageCache instance;

    private static List<String> sessionList = new ArrayList<>();


    //双重校验锁 实现单例
    public static ManageCache getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null)
                    instance = new ManageCache();
            }
        }
        return instance;
    }


    /**
     * 增加session，其实这个session就是服务器放在cookie里面的sessionId，用户对服务器进行访问时，
     * 拿着SessionId就可以得到对应的Session及里面的信息
     *
     * @param session
     */
    public static void addSession(String session) {
        sessionList.add(session);
    }

    /**
     * 查看是否有该Session对象
     *
     * @param session
     * @return
     */
    public static boolean hasSession(String session) {
        if (sessionList.size() > 0) {
            if (sessionList.contains(session))
                return true;
        }
        return false;
    }

    /**
     * 删除该Session
     *
     * @param session
     */
    public void removeSession(String session) {
        if (hasSession(session)) {
            sessionList.remove(session);
        }
    }
}
