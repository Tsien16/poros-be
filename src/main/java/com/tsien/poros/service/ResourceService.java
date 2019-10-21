package com.tsien.poros.service;

import com.tsien.poros.model.ResourceDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/21 0021 14:44
 */

public interface ResourceService {

    /**
     * 查询所有资源
     *
     * @return resources
     */
    List<ResourceDO> listResources();
}
