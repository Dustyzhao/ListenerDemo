package cache;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DUSTY
 */
public class LoginCache {

    private static LoginCache instance = new LoginCache();

    //通过用户名获取sessionId，通过sessionId获取session。
    private Map<String,String> loginUserSession = new HashMap<>();
    private Map<String,HttpSession> loginSession = new HashMap<>();


    private LoginCache() {

    }

    public static LoginCache getInstance() {
        return instance;
    }

    public String getSessionIdByUsername(String username){
        return loginUserSession.get(username);
    }

    public HttpSession getSessionBySessionId(String sessionId) {
        return loginSession.get(sessionId);
    }

    public void setSessionIdByUsername(String username,String sessionId){
        loginUserSession.put(username,sessionId);
    }

    public void setSessionBySessionId(String sessionId,HttpSession session){
        loginSession.put(sessionId,session);
    }

}
