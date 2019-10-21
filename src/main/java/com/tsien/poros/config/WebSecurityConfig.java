package com.tsien.poros.config;

import com.tsien.poros.constant.Const;
import com.tsien.poros.service.UserService;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/9/23 0023 18:03
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserService userService;

    @Resource
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

    @Resource
    private UrlAccessDecisionManager urlAccessDecisionManager;

    @Resource
    private MyAuthenticationAccessDeniedHandler myAuthenticationAccessDeniedHandler;

    @Resource
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Resource
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Resource
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Resource
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/index.html", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        object.setAccessDecisionManager(urlAccessDecisionManager);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .loginProcessingUrl(Const.LOGIN_PROCESSING_URL)
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl(Const.LOGOUT_PROCESSING_URL)
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .permitAll()
                .and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                .accessDeniedHandler(myAuthenticationAccessDeniedHandler);
    }
}
