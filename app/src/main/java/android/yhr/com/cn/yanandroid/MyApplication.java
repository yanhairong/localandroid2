package android.yhr.com.cn.yanandroid;

import android.app.Application;
import android.content.Context;
import android.yhr.com.cn.commonmoudle.common.CommonModule;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by yhr on 19-5-20.
 */

public class MyApplication extends Application {
    public static Context mContext;
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) { // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog(); // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        //初始化CommonMudle
        CommonModule.init(this, BuildConfig.APPLICATION_ID);
        instance = this;
        mContext = this;
    }
}
