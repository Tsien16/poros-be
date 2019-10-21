package com.tsien.poros.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsien.poros.util.ServerResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * 自定义登录认证失败时候，返回的内容
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/14 0014 2:17
 */

@Configuration
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter printWriter = response.getWriter();
        String errorMsg = "";
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            errorMsg = "用户名或密码输入错误，登录失败!";
        } else if (exception instanceof DisabledException) {
            errorMsg = "账户被禁用，登录失败，请联系管理员!";
        } else {
            errorMsg = "登录失败!";
        }
        printWriter.write(new ObjectMapper().writeValueAsString(ServerResponse.error(errorMsg)));
        printWriter.flush();
        printWriter.close();
    }
}
