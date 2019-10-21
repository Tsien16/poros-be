package com.tsien.poros.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsien.poros.util.ServerResponse;
import com.tsien.poros.util.UserUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * 定义登录认证成功时候的返回内容
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/14 0014 2:13
 */

@Configuration
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(new ObjectMapper().writeValueAsString(
                ServerResponse.ok("登录成功", UserUtil.getCurrentUser())));
        printWriter.flush();
        printWriter.close();
    }
}
