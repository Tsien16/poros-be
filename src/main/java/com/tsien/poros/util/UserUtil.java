package com.tsien.poros.util;

import com.tsien.poros.model.RoleDO;
import com.tsien.poros.model.UserDO;
import com.tsien.poros.vo.RoleVO;
import com.tsien.poros.vo.UserVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/23 0023 18:24
 */

public class UserUtil {

    /**
     * 通过SecurityContextHolder获取到用户信息
     *
     * @return UserDO
     */
    public static UserDO getCurrentUser() {
        return (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 组装UserVO
     *
     * @param userDO userDO
     * @return UserVO
     */
    public static UserVO assembleUserVO(UserDO userDO) {

        UserVO userVO = new UserVO();
        List<RoleVO> roleVos = new ArrayList<>();

        List<RoleDO> roles = userDO.getRoles();
        if (CollectionUtils.isNotEmpty(roles)) {
            for (RoleDO roleDO : roles) {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(roleDO, roleVO);
                roleVos.add(roleVO);
            }
        }
        BeanUtils.copyProperties(userDO, userVO);
        userVO.setBirthday(LocalDateUtil.dateToString(userDO.getBirthday()));
        userVO.setRoles(roleVos);

        return userVO;
    }
}
