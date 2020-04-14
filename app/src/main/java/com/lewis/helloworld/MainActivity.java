package com.lewis.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView1, textView2, textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView1 = findViewById(R.id.imei);
        textView2 = findViewById(R.id.imei2);
        textView3 = findViewById(R.id.android_id);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("imei:" + DevicesUtils.getDeivce(MainActivity.this.getApplicationContext()));
                textView2.setText("slot0:" + DevicesUtils.getSlotImei(0, MainActivity.this.getApplicationContext()));
                String id = Settings.Secure.getString(v.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                textView3.setText("androidId:" + id);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "通话权限申请成功", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
