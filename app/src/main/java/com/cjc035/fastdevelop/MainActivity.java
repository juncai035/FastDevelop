package com.cjc035.fastdevelop;

import android.os.Bundle;
import android.widget.Toast;

import com.cjc035.androidfastdevelop.base.BaseActivity;
import com.cjc035.androidfastdevelop.util.log.Logger;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.e(TAG, "This is MainActivity");
        Logger.e("This is MainActivity");
        Toast.makeText(this, "哈哈哈", Toast.LENGTH_SHORT).show();
    }
}
