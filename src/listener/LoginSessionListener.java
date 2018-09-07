package listener;

import cache.LoginCache;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author DUSTY
 */
public class LoginSessionListener implements HttpSessionAttributeListener {

    //为了保证判断的准确性，我们创建一个常量
    private static final String LOGIN_USER = "loginUser";

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();

        if (LOGIN_USER.equals(attrName)) {
            //获取当前登录名attrVal
            String attrVal = (String) httpSessionBindingEvent.getValue();
            HttpSession session = httpSessionBindingEvent.getSession();
            String sessionId = session.getId();

            //通过登录名获取缓存中的sessionId
            String sessionId2 = LoginCache.getInstance().getSessionIdByUsername(attrName);
            if (null == sessionId2) {


            }else {
                HttpSession session2 = LoginCache.getInstance().getSessionBySessionId(sessionId2);
                session2.invalidate();
            }

            LoginCache.getInstance().setSessionIdByUsername(attrVal,sessionId);
            LoginCache.getInstance().setSessionBySessionId(sessionId,session);
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
