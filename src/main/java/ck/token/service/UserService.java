package ck.token.service;

import ck.token.entity.CoreUser;
import ck.token.mapper.CoreUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jinbin
 * @date 2018-07-08 20:52
 */
@Service("UserService")
public class UserService {

    @Autowired
    private CoreUserMapper userMapper;


    public CoreUser findByUserPhone(String phone) {
        return userMapper.findByUserPhone(phone);
    }

    public CoreUser findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}
