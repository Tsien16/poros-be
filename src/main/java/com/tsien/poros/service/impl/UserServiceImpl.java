package com.tsien.poros.service.impl;

import com.tsien.poros.dao.UserDAO;
import com.tsien.poros.model.UserDO;
import com.tsien.poros.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 13:06
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    /**
     * 根据用户名查询用户
     *
     * @param username username
     * @return UserDetails
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDO userDO = userDAO.getUserByUsername(username);
        if (userDO == null) {
            throw new UsernameNotFoundException("用户名错误");
        }
        return userDO;
    }
}
