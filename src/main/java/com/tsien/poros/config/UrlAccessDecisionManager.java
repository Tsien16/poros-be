package com.tsien.poros.config;

import com.tsien.poros.constant.Const;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/23 0023 15:56
 */

@Configuration
public class UrlAccessDecisionManager implements AccessDecisionManager {


    /**
     * 判断用户的权限跟访问url的权限是否一致
     *
     * @param authentication   保存登录用户的信息
     * @param object           object
     * @param configAttributes 登录url需要的权限集合
     * @throws AccessDeniedException               AccessDeniedException
     * @throws InsufficientAuthenticationException InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        for (ConfigAttribute configAttribute : configAttributes) {

            // 获取当前请求，哪几个角色可以访问（来源于UrlFilterInvocationSecurityMetadataSource），从数据库查询得到的
            String needRole = configAttribute.getAttribute();
            if (Objects.equals(Const.ROLE_LOGIN, needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("用户未登录");
                } else {

                    // return的含义：不执行后续代码，方法结束
                    return;
                }
            }

            // 用当前用户具有的权限，去比较访问的url需要的权限，只要匹配上一个，就跳出循环，认证通过
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (Objects.equals(authority.getAuthority(), needRole)) {

                    // return的含义：不执行后续代码，方法结束；
                    return;
                }
            }
        }

        // 如果前面一直未能匹配上，抛出权限不足异常
        throw new AccessDeniedException("权限不足");
    }

    /**
     * Indicates whether this <code>AccessDecisionManager</code> is able to process
     * authorization requests presented with the passed <code>ConfigAttribute</code>.
     * <p>
     * This allows the <code>AbstractSecurityInterceptor</code> to check every
     * configuration attribute can be consumed by the configured
     * <code>AccessDecisionManager</code> and/or <code>RunAsManager</code> and/or
     * <code>AfterInvocationManager</code>.
     * </p>
     *
     * @param attribute a configuration attribute that has been configured against the
     *                  <code>AbstractSecurityInterceptor</code>
     * @return true if this <code>AccessDecisionManager</code> can support the passed
     * configuration attribute
     */
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    /**
     * Indicates whether the <code>AccessDecisionManager</code> implementation is able to
     * provide access control decisions for the indicated secured object type.
     *
     * @param clazz the class that is being queried
     * @return <code>true</code> if the implementation can process the indicated class
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
