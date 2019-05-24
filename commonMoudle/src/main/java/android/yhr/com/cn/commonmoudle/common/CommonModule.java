package android.yhr.com.cn.commonmoudle.common;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

/**
 * Created by yhr on 19-5-20.
 */

public class CommonModule {

    private static Application APPLICATION;

    private static String APP_ID ;

    public static void init(Application application,String appId) {
        APPLICATION = application;
        APP_ID = appId;
    }

    public static Application getApplication() {
        if (APPLICATION == null) {
            throw new RuntimeException("CommonModule未初始化init()");
        }
        return APPLICATION;
    }

    public static Context getContext() {
        if (APPLICATION == null) {
            throw new RuntimeException("CommonModule未初始化init()");
        }
        return APPLICATION.getApplicationContext();
    }

    public static String getAppId(){

        if (TextUtils.isEmpty(APP_ID)) {
            throw new RuntimeException("CommonModule未初始化init()");
        }
        return APP_ID;
    }
}
