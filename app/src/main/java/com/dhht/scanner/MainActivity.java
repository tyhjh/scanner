package com.dhht.scanner;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.dhht.library.CaptureActivity;

public class MainActivity extends AppCompatActivity {


    TextView tvHello;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CaptureActivity.setBackActivity(MainActivity.class);
        CaptureActivity.setScannerResultActivity(MainActivity.class);
        CaptureActivity.setManualActivity(MainActivity.class);
        CaptureActivity.setTopbarColor(getColor(R.color.colorPrimary));

        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
        tvHello = findViewById(R.id.tvHello);
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "返回结果：" + CaptureActivity.getCodeMsg());
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvHello.setText("返回结果：" + CaptureActivity.getCodeMsg());
        Log.e("onResume", "返回结果：" + CaptureActivity.getCodeMsg());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "返回结果：" + CaptureActivity.getCodeMsg());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "返回结果：" + CaptureActivity.getCodeMsg());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "返回结果：" + CaptureActivity.getCodeMsg());
    }
}
