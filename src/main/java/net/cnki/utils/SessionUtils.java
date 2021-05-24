package net.cnki.utils;



import net.cnki.common.entity.UserInfo;

import java.util.Map;

/**
 * Session
 */
public class SessionUtils {
    private static ThreadLocal<Session> userThreadLocal = new ThreadLocal<>();

    public static void setUser(UserInfo user) {
        Session session =new Session();
        session.setUserInfo(user);
        userThreadLocal.set(session);
    }

    public static void setUser(UserInfo user, String groupId){
        Session session =new Session();
        session.setUserInfo(user);
        userThreadLocal.set(session);
    }

    public static UserInfo getUser() {
        return userThreadLocal.get().getUserInfo();
    }

    public static String getUserId() {
        Session session = userThreadLocal.get();
        return session != null ? session.getUserInfo().getUserId() : null;
    }

    public static void removeUser() {
        userThreadLocal.remove();
    }


    public static void setGroupId(String groupId){
        Session session =userThreadLocal.get();
        userThreadLocal.set(session);
    }

    public static void setRoleMap(Map<String, Boolean> map) {
        Session session =userThreadLocal.get();
        session.setRoleMap(map);
        userThreadLocal.set(session);
    }

    public static Map getRoleMap(){
        return userThreadLocal.get().getRoleMap();
    }


    public static void setSubmitToken(String token){
        Session session =userThreadLocal.get();
        session.setDoubleSubmitToken(token);
        userThreadLocal.set(session);
    }

    public static String getSubmitToken(){
        return userThreadLocal.get().getDoubleSubmitToken();
    }
}
