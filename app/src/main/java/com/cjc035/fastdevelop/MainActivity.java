package com.cjc035.fastdevelop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cjc035.customutil.log.Logger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.e(TAG, "This is MainActivity");
        Logger.e("This is MainActivity");
    }
}
