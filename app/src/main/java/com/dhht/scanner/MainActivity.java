package com.dhht.scanner;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dhht.library.CaptureActivity;

public class MainActivity extends AppCompatActivity {


    TextView tvHello;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CaptureActivity.setTopbarColor(getColor(R.color.colorPrimary));

        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
        tvHello = findViewById(R.id.tvHello);
        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                intent.putExtra(CaptureActivity.SHOW_MANUAL_VIEW,false);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data.getBooleanExtra(CaptureActivity.NEED_MANUAL, false)) {
                Toast.makeText(MainActivity.this, "手动输入", Toast.LENGTH_SHORT).show();
            } else {
                String code = data.getStringExtra(CaptureActivity.SCAN_CODE);
                tvHello.setText("返回结果：" + code);
                Toast.makeText(MainActivity.this, "返回：" + code, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
