package com.tsien.poros.config;

import com.tsien.poros.constant.Const;
import com.tsien.poros.model.ResourceDO;
import com.tsien.poros.model.RoleDO;
import com.tsien.poros.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/23 0023 16:49
 */

@Slf4j
@Configuration
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private ResourceService resourceService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 根据请求的url，从数据库读取分析访问这个url需要哪些权限
     *
     * @param object object
     * @return 权限集合
     * @throws IllegalArgumentException IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        /*
        1、获取请求的Url地址和请求的方法,并进行处理
        2、主要是处理url里的'?'
         */
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        if (requestUrl.contains(Const.QUESTION_MARK)) {
            requestUrl = requestUrl.substring(0, requestUrl.indexOf(Const.QUESTION_MARK));
        }
        String requestMethod = ((FilterInvocation) object).getRequest().getMethod();

        /*
        1、从数据库里查询所有的资源（权限）清单
        2、根据请求的匹配规则和请求方法，用antPathMatcher去匹配前端发来的请求地址
        3、如果角色为空，不会进入到if
         */
        List<ResourceDO> resources = resourceService.listResources();

        for (ResourceDO resourceDO : resources) {
            if (antPathMatcher.match(resourceDO.getResourceMatchingRule(), requestUrl)
                    && resourceDO.getRoles().size() > 0
                    && Objects.equals(resourceDO.getRequestMethod(), requestMethod)) {
                List<RoleDO> roleDos = resourceDO.getRoles();
                if (CollectionUtils.isNotEmpty(roleDos)) {
                    return SecurityConfig.createList(roleDos.stream().map(RoleDO::getRoleCode)
                            .collect(Collectors.toList()).toArray(new String[]{}));
                }
            }
        }

        /*
        1、没有匹配上的资源或者没有设定权限的资源，如果是GET方法，登录即可访问，其它的拒绝访问
        2、这边这是做个ROLE_LOGIN的权限标记
        3、需要在下一步（UrlAccessDecisionManager）里做判断的
         */
        if (HttpMethod.GET.matches(requestMethod)) {
            return SecurityConfig.createList(Const.ROLE_LOGIN);
        }

        throw new AccessDeniedException("权限不足");
    }

    /**
     * If available, returns all of the {@code ConfigAttribute}s defined by the
     * implementing class.
     * <p>
     * This is used by the {@link AbstractSecurityInterceptor} to perform startup time
     * validation of each {@code ConfigAttribute} configured against it.
     *
     * @return the {@code ConfigAttribute}s or {@code null} if unsupported
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * Indicates whether the {@code SecurityMetadataSource} implementation is able to
     * provide {@code ConfigAttribute}s for the indicated secure object type.
     *
     * @param clazz the class that is being queried
     * @return true if the implementation can process the indicated class
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
