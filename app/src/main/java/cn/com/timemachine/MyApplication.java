package cn.com.timemachine;

import android.app.Application;

import cn.com.timemachine.utils.AppUtils;

/**
 * Created by apple on 2018/2/26.
 */

public class MyApplication extends Application {
    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppUtils.init(this);
    }
    public static MyApplication getInstance(){
        return instance;
    }

}
