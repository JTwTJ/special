package com.jwt.special.util;

import com.jwt.special.model.User;

/**
 * <用户工具类></>
 * @author jiangwentao
 * @date 2018/12/26 0026 下午 4:52
 */
public final class UserUtil {
    private static ThreadLocal<User> user = new ThreadLocal<User>();

    /** 将当前用户信息存入当前线程 */
    public static void putCurrentUser(User baseUser) {
        user.set(baseUser);
    }
    /** 获取当前用户信息 */
    public static User getCurrentUser() {
        return user.get();
    }
    /** 清除当前用户信息 */
    public static void clearCurrentUser() {
        user.remove();
    }
    /** 通过id查询当前用户信息 */
    public static Long getUserId() {
        User baseUser = getCurrentUser();
        if (baseUser != null) {
            return baseUser.getUserId();
        }
        return null;
    }
}
