package cn.com.timemachine.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by necer on 2017/9/28.
 * QQ群:127278900
 */

public class Utils {

    /**
     * 获取当前版本信息.
     *
     * @param context
     */
    public static String getCurrentVersion(Context context) {
        String versionName = "";
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
    public  static String getMonth(int month){
        String enMonth="";

        switch (month){
            case 1:
                enMonth="JANUARY";
                break;
            case 2:
                enMonth="FEBRUARY";
                break;
            case 3:
                enMonth="MARCH";
                break;
            case 4:
                enMonth="APRIL";

                break;
            case 5:
                enMonth="MAY";
                break;
            case 6:
                enMonth="JUNE";

                break;
            case 7:
                enMonth="JULY";

                break;
            case 8:

                enMonth="AUGUST";

                break;
            case 9:
                enMonth="SEPTEMBER";
                break;
            case 10:
                enMonth="OCTOBER";

                break;
            case 11:
                enMonth="NOVEMBER";

                break;
            case 12:
                enMonth="DECEMBER";
                break;
            default:
                break;
        }
        return enMonth;
    }

}
