package edu.gxu.sdqrps.interceptor;

import edu.gxu.sdqrps.model.vo.UserDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author cz
 * @date 2020/2/2 1:18 下午
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDetail userDetail = (UserDetail) request.getSession().getAttribute("userDetail");
        if(Objects.isNull(userDetail)){
            response.sendRedirect("/sdqrps");
            return false;
        }
        return true;
    }
}
