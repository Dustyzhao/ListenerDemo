package cache;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录用户与session缓存对象
 * @author DUSTY
 */
public class LoginCache {

    //先单例化
    private static LoginCache instance = new LoginCache();

    /**
     * httpSession对象创建后都会有一个唯一的ID用于与其他的session做标志区别。
     * 但因为3.0的servlet api中已经不允许直接通过sessionId来获得session对象，
     * 我们依然是通过sessionId来获取session对象，但现在只好间接地通过两步来获取，
     * 我们把用户名和sessionID联系起来，即：1.通过用户名获取sessionId，2.通过sessionId获取session。
     */
    private Map<String,String> loginUserSession = new HashMap<>();
    private Map<String,HttpSession> loginSession = new HashMap<>();


    private LoginCache() {

    }

    public static LoginCache getInstance() {
        return instance;
    }

    /**
     * 通过登录名获取对应登录用户的sessionId
     * @param username
     * @return
     */
    public String getSessionIdByUsername(String username){
        return loginUserSession.get(username);
    }

    /**
     * 通过sessionId获取对应的session对象
     * @param sessionId
     * @return
     */
    public HttpSession getSessionBySessionId(String sessionId) {
        return loginSession.get(sessionId);
    }

    /**
     * 存储登录名与对应的登录sessionID至缓存对象
     * @param username
     * @param sessionId
     */
    public void setSessionIdByUsername(String username,String sessionId){
        loginUserSession.put(username,sessionId);
    }

    /**
     * 存储sessionId与对应的session对象至缓存对象
     * @param sessionId
     * @param session
     */
    public void setSessionBySessionId(String sessionId,HttpSession session){
        loginSession.put(sessionId,session);
    }

}
