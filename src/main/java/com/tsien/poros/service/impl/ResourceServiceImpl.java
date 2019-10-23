package com.tsien.poros.service.impl;

import com.tsien.poros.dao.ResourceDAO;
import com.tsien.poros.model.ResourceDO;
import com.tsien.poros.service.ResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 14:44
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Resource
    private ResourceDAO resourceDAO;

    /**
     * 查询所有资源
     *
     * @return resources
     */
    @Override
    public List<ResourceDO> listResources() {
        return resourceDAO.listResources();
    }

    /**
     * 通过userId查询个人的所有资源
     *
     * @param userId userId
     * @return resources
     */
    @Override
    public List<ResourceDO> listResourcesByUserId(Long userId) {
        return null;
    }
}
