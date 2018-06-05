package cn.com.timemachine.utils;

import android.app.Application;
import android.widget.Toast;

import cn.com.timemachine.MyApplication;


/**
 * @author apple
 *
 */
public class ToastUtils {

    private static Toast mToast;

    /**
     * 显示Toast
     */
    public static void showToast( CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }


}
