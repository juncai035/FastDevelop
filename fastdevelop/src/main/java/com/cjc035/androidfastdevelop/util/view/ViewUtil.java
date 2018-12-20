package com.cjc035.androidfastdevelop.util.view;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * @Creator juncai
 * @Date 18-12-20 上午11:39
 * @Des 与界面相关的工具类
 */

public class ViewUtil {

    /**
     * 私有构造方法，不允许创建本类对象
     */
    private ViewUtil() {

    }

    /**
     * 状态栏颜色可变
     * 沉浸式状态栏
     *
     * @param activity
     * @param color
     */
    public static void setColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //生成一个状态栏大小的矩形
            View statusView = createStatusView(activity, color);
            //添加到statusView布局中
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.addView(statusView);
            //设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    /**
     * 创建一个和状态栏一样大小的View
     *
     * @param activity
     * @param color
     * @return
     */
    public static View createStatusView(Activity activity, int color) {
        //获得状态栏高度
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(identifier);

        //绘制一个和状态栏高度一样的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }
}
