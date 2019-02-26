package com.zj.modules.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zj.modules.domain.UserEntity;
import com.zj.modules.service.User1Service;
import com.zj.modules.util.UserSexEnum;

import java.util.List;

/**
 * Created by Kane on 2018/1/17.
 */
@Service
@RestController
public class UserController {

    @Autowired
    private User1Service user1Service;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users= user1Service.getUsers();
        return users;
    }
    
    /**
     * 获取用户分页
     * zj
     * 2019年1月24日
     */
    @RequestMapping("/getUsersByPage")
    public List<UserEntity> getUsersByPage() {
        List<UserEntity> users= user1Service.getUsersByPage();
        return users;
    }
    
    

    //测试
    @RequestMapping(value="update1")
    public String updateTransactional(@RequestParam(value = "id") Long id,
                                    @RequestParam(value = "user_id") Long user_id,
                                    @RequestParam(value = "order_id") Long order_id,
                                    @RequestParam(value = "nickName") String nickName,
                                    @RequestParam(value = "passWord") String passWord,
                                    @RequestParam(value = "userName") String userName
                                    ) {
        UserEntity user2 = new UserEntity();
        user2.setId(id);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        user1Service.updateTransactional(user2);
        return "test";
    }
}