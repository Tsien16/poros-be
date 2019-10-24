package com.tsien.poros.controller;

import com.tsien.poros.service.ResourceService;
import com.tsien.poros.util.ServerResponse;
import com.tsien.poros.util.UserUtil;
import com.tsien.poros.vo.NavVO;
import com.tsien.poros.vo.PermissionVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 查询的菜单和操作权限
     *
     * @return userVo
     */
    @GetMapping("nav_permission")
    public ServerResponse getUserNavAndPermissions() {
        Map<String, List> map = new HashMap<>(2);
        Long userId = UserUtil.getCurrentUser().getUserId();
        List<NavVO> nav = resourceService.listNavByUserId(userId);
        List<PermissionVO> permissions = resourceService.listPermissionsByUserId(userId);
        map.put("nav", nav);
        map.put("permissions", permissions);

        return ServerResponse.ok(map);
    }

    /**
     * 查询用户的菜单
     *
     * @return nav
     */
    @GetMapping("nav")
    public ServerResponse getUserNav() {

        List<NavVO> nav = resourceService.listNavByUserId(UserUtil.getCurrentUser().getUserId());
        return ServerResponse.ok(nav);
    }


}
