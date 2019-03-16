package ck.token.api;

import ck.token.entity.CoreUser;
import ck.token.service.TokenService;
import ck.token.service.UserService;
import ck.token.util.MD5Util;
import ck.token.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author chenk
 * @Description //TODO $
 * @Date 2019/3/16  12:47
 **/
@RestController
@RequestMapping("api")
@CrossOrigin
    public class UserApi {
        @Autowired
        UserService userService;
        @Autowired
        TokenService tokenService;

        //登录
        @PostMapping("/login")
        public ResultMsg login(@RequestBody CoreUser user){
            CoreUser userForBase=userService.findByUserPhone(user.getPhone());
            if(userForBase==null){
                return new ResultMsg("登录失败,用户不存在",false);
            }else {
                if (!userForBase.getPsw().equals(MD5Util.MD5(user.getPsw()))){
                    return new ResultMsg("登录失败,密码错误",false);
                }else {
                    String token = tokenService.getToken(userForBase);
                    userForBase.setToken(token);
                    return new ResultMsg(userForBase);
                }
            }
        }
}
