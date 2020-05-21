package com.chenzifeng.learn.service;

import com.chenzifeng.learn.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginService {
     User getUserByName(String getMapByName);
}
