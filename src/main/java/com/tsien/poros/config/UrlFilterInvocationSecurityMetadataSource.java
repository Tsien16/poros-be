package com.tsien.poros.config;

import com.tsien.poros.constant.Const;
import com.tsien.poros.model.ResourceDO;
import com.tsien.poros.model.RoleDO;
import com.tsien.poros.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
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
        String beforeRequestUrl = ((FilterInvocation) object).getRequestUrl();
        String requestMethod = ((FilterInvocation) object).getRequest().getMethod();
        String[] afterRequestUrl = beforeRequestUrl.split("\\?");
        String requestUrl = afterRequestUrl.length > 0 ? afterRequestUrl[0] : beforeRequestUrl;

        /*
        1、从数据库获取所有的资源，并且查询出每个资源关联了哪几个角色（即哪几个角色可访问）放在roles里
        2、如果在数据库配置的URL，但是没关联角色（Role),就不会执行if判断
        3、如果请求的URL没在数据库里配置，也不会进入执行if判断
         */
        List<ResourceDO> resources = resourceService.listResources();
        for (ResourceDO resourceDO : resources) {
            if (antPathMatcher.match(resourceDO.getResourceUrl(), requestUrl)
                    && Objects.equals(resourceDO.getRequestMethod(), requestMethod)
                    && resourceDO.getRoles().size() > 0) {
                List<RoleDO> roles = resourceDO.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleCode();
                }
                return SecurityConfig.createList(values);
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
