package com.cjc035.androidfastdevelop.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cjc035.androidfastdevelop.util.activitycontrol.ActivityController;

/**
 * @Creator juncai
 * @Date 18-12-20 上午10:44
 * @Des 应用内Activity的父类
 */

public class BaseActivity extends AppCompatActivity {

    private String[] mPermissionArray = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_SMS,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private int mPermissionIndex = 0;
    private int mRequestPermissionCode = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        initPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActivityController.removeActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 初始化动态权限申请
     */
    private void initPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mPermissionIndex >= mPermissionArray.length) {
                return;
            }
            if (checkSelfPermission(mPermissionArray[mPermissionIndex]) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{mPermissionArray[mPermissionIndex]}, mRequestPermissionCode);
            } else {
                mPermissionIndex++;
                initPermission();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (grantResults.length > 0 && requestCode == mRequestPermissionCode) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    if (!shouldShowRequestPermissionRationale(permissions[0])) {
                        //勾选了拒绝后不再提示
                        goToAppDetail();
                    } else {
                        initPermission();
                    }
                } else {
                    mPermissionIndex++;
                    initPermission();
                }
            }
        }
    }

    /**
     * 跳转到应用详情页面
     */
    private void goToAppDetail() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getApplicationContext().getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
        finish();
    }
}

