package com.tsien.poros.controller;

import com.tsien.poros.service.ResourceService;
import com.tsien.poros.util.ServerResponse;
import com.tsien.poros.util.UserUtil;
import com.tsien.poros.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/22 0022 14:13
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private ResourceService resourceService;

    /**
     * 查询个人信息
     *
     * @return userVo
     */
    @GetMapping("info")
    public ServerResponse getUserInfo() {
        UserVO userVO = UserUtil.assembleUserVO(UserUtil.getCurrentUser());
        return ServerResponse.ok(userVO);
    }


    /**
     * 查询个人的访问资源配置
     *
     * @return userVo
     */
    @GetMapping("resource")
    public ServerResponse getUserResources() {
        UserVO userVO = UserUtil.assembleUserVO(UserUtil.getCurrentUser());
        return ServerResponse.ok(userVO);
    }


}
