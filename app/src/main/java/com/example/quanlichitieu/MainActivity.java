package com.example.quanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnKhoanThu,btnKhoanChi,btnThongKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnKhoanThu=findViewById(R.id.btnKT);
        btnKhoanChi=findViewById(R.id.btnKC);
        btnThongKe=findViewById(R.id.btnTK);
        btnKhoanThu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ActivityKhoanThu.class);
            startActivity(intent);
        }
    });
        btnKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityKhoanChi.class);
                startActivity(intent);
            }
        });
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ActivityThongKe.class);
                startActivity(intent);
            }
        });
    }

}
