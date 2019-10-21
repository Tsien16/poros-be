package com.tsien.poros.exception;

import com.tsien.poros.util.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author tsien
 * @version 1.0.0
 * @date 2019/10/19 0019 15:24
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 数据库SQL异常处理
     *
     * @param e e
     * @return 异常
     */
    @ExceptionHandler(SQLException.class)
    public ServerResponse sqlExceptionHandler(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return ServerResponse.error("该数据有关联数据，操作失败");
        }

        return ServerResponse.error("数据库异常，操作失败");
    }

    /**
     * 404 异常处理
     *
     * @param request request
     * @param e       e
     * @return 404
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ServerResponse<Map<Object, Object>> noHandlerFoundExceptionHandler(HttpServletRequest request,
                                                                              HttpServletResponse response,
                                                                              NoHandlerFoundException e) {

        response.setStatus(HttpStatus.NOT_FOUND.value());
        String requestMethod = request.getMethod();
        String requestUri = request.getRequestURI();
        Map<Object, Object> map = new HashMap<>(2);
        map.put("requestMethod", requestMethod);
        map.put("requestUri", requestUri);

        return ServerResponse.errorCodeMessage(HttpStatus.NOT_FOUND.value(), "请求的地址不存在", map);

    }
}
