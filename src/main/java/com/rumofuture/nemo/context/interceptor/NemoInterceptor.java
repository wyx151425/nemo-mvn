package com.rumofuture.nemo.context.interceptor;

import com.rumofuture.nemo.model.domain.User;
import com.rumofuture.nemo.util.constant.NemoConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 王振琦
 */
public class NemoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(NemoInterceptor.class);

    private static final String USER_REGISTER_URI = "%s/users/register";
    private static final String USER_LOGIN_URI = "%s/users/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("NemoInterceptor: preHandle");
        logger.info("User Address: " + request.getRemoteHost());
        logger.info("Request URL: " + request.getRequestURL().toString());
        logger.info("Request Method: " + request.getMethod());

        /* 1.请求相关数据 操作 */
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");

        /* 2.非拦截路由 检查 */
        if (String.format(USER_REGISTER_URI, contextPath).equals(uri)
                || String.format(USER_LOGIN_URI, contextPath).equals(uri)) {
            return true;
        }

        /* 3.Token 检查 */
        User user = (User) request.getSession().getAttribute(NemoConst.USER);
        if (null == user) {
            response.sendRedirect(request.getContextPath() + "/mvc/login");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("NemoInterceptor: postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        logger.info("NemoInterceptor: afterCompletion");
    }
}
