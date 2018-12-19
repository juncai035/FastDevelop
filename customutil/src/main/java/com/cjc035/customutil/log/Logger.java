package com.cjc035.customutil.log;

import android.text.TextUtils;
import android.util.Log;

import com.cjc035.customutil.BuildConfig;

/**
 * @Creator juncai
 * @Date 18-12-19 下午2:42
 * @Des 自定义打印日志的工具类
 */

public class Logger {

    private static String TAG = "Logger";

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int OTHER = 6;

    private static int LEVEL = BuildConfig.DEBUG ? VERBOSE : OTHER;

    /**
     * 私有构造方法，不允许创建本类对象
     */
    private Logger() {

    }

    /**
     * 打印Verbose级别的日志
     *
     * @param TAG
     * @param message
     */
    public static void v(String TAG, String message) {
        message = getMessage(message);
        if (LEVEL <= VERBOSE) {
            Log.v(TAG, message);
        }
    }

    /**
     * 打印Verbose级别的日志
     *
     * @param message
     */
    public static void v(String message) {
        v(TAG, message);
    }

    /**
     * 打印Debug级别的日志
     *
     * @param TAG
     * @param message
     */
    public static void d(String TAG, String message) {
        message = getMessage(message);
        if (LEVEL <= DEBUG) {
            Log.d(TAG, message);
        }
    }

    /**
     * 打印Debug级别的日志
     *
     * @param message
     */
    public static void d(String message) {
        d(TAG, message);
    }

    /**
     * 打印Info级别的日志
     *
     * @param TAG
     * @param message
     */
    public static void i(String TAG, String message) {
        message = getMessage(message);
        if (LEVEL <= INFO) {
            Log.i(TAG, message);
        }
    }

    /**
     * 打印Info级别的日志
     *
     * @param message
     */
    public static void i(String message) {
        i(TAG, message);
    }

    /**
     * 打印Warn级别的日志
     *
     * @param TAG
     * @param message
     */
    public static void w(String TAG, String message) {
        message = getMessage(message);
        if (LEVEL <= WARN) {
            Log.w(TAG, message);
        }
    }

    /**
     * 打印Warn级别的日志
     *
     * @param message
     */
    public static void w(String message) {
        w(TAG, message);
    }

    /**
     * 打印Error级别的日志
     *
     * @param TAG
     * @param message
     */
    public static void e(String TAG, String message) {
        message = getMessage(message);
        if (LEVEL <= ERROR) {
            Log.e(TAG, message);
        }
    }

    /**
     * 打印Error级别的日志
     *
     * @param message
     */
    public static void e(String message) {
        e(TAG, message);
    }

    /**
     * 过滤打印空的日志
     *
     * @param message
     * @return
     */
    private static String getMessage(String message) {
        if (TextUtils.isEmpty(message)) {
            message = "message is null";
        }
        return message;
    }
}
