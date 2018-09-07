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
        //监听到session属性值发生添加操作，获取对应操作的属性名
        String attrName = httpSessionBindingEvent.getName();

        //若属性名为登录属性名，判定为用户登录操作
        if (LOGIN_USER.equals(attrName)) {
            //获取添加的属性值，即用户登录名
            String attrVal = (String) httpSessionBindingEvent.getValue();
            //该次操作的session对象
            HttpSession session = httpSessionBindingEvent.getSession();
            //该次操作的session对象ID
            String sessionId = session.getId();

            //从缓存对象里面，获得该用户登录名对应的sessionID值
            String sessionId2 = LoginCache.getInstance().getSessionIdByUsername(attrName);
            if (null == sessionId2) {
                //未获得结果，不需要清理前次登录用户会话信息
            }else {
                //获取前次该用户登录对应的session对象
                HttpSession session2 = LoginCache.getInstance().getSessionBySessionId(sessionId2);
                //清理前次登录用户会话存储信息，使得前次登录失效
                session2.invalidate();
            }

            //完成该次登录用户登录名、sessionID，session对象的缓存对象存储
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
