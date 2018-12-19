package com.cjc035.customutil.activitycontrol;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Creator juncai
 * @Date 18-12-19 下午3:21
 * @Des 集合管理应用中的Activity
 */

public class ActivityController {

    private static List<Activity> sActivityList = new ArrayList<>();

    /**
     * 私有构造方法，不允许创建本类对象
     */
    private ActivityController() {

    }

    /**
     * 将Activity添加到集合中
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (activity == null) {
            return;
        }
        sActivityList.add(activity);
    }

    /**
     * 将Activity从集合中移除
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        sActivityList.remove(activity);
    }

    /**
     * 关闭所有的Activity
     */
    public static void closeAll() {
        for (Activity activity : sActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
