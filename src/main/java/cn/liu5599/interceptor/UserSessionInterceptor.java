package cn.liu5599.interceptor;


import cn.liu5599.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserSessionInterceptor implements HandlerInterceptor
{
    private Logger logger = Logger.getLogger(UserSessionInterceptor.class.getName());

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws IOException {
        User user = (User)req.getSession().getAttribute("LoginUser");
        if (user == null)
        {
            logger.log(Level.INFO, "user not login");
            res.sendRedirect("/myEmail/login.html");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mav) throws Exception {
    }

    public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception excptn) throws Exception {
    }
}
