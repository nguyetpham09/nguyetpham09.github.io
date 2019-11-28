package com.example.quanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityKhoanThu extends AppCompatActivity {
    //CustomAdapter.ItemFilter filter;
    private Button btnADD,btnBack;
    private ListView lvKC;
    private EditText edtND,edtST;
    private List<KhoanChi> arrayKhoanThu;
    private CustomAdapter adapter;
    public static DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_chi);
        db = new DBManager(this);
        btnADD=findViewById(R.id.btnADD);
        lvKC=findViewById(R.id.lvKC);
        edtND=findViewById(R.id.edtND);
        edtST=findViewById(R.id.edtST);
        arrayKhoanThu=new ArrayList<>();
        arrayKhoanThu=db.getAllKC();
        adapter=new CustomAdapter(this,R.layout.item_listview,arrayKhoanThu);
        lvKC.setAdapter(adapter);
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addKC(view);
            }
        });
        btnBack=findViewById(R.id.btnback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityKhoanThu.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void addKC(View view){
        if ( view.getId()==R.id.btnADD){
            String noidung=edtND.getText().toString().trim();
            String sotien=edtST.getText().toString().trim();
            if(TextUtils.isEmpty(noidung)||TextUtils.isEmpty(sotien)){
                Toast.makeText(this,"Nhập nội dung và số tiền",Toast.LENGTH_SHORT).show();
            }
            else {

                KhoanChi khoanThu=new KhoanChi(noidung,sotien);
                arrayKhoanThu.add(khoanThu);
            }
            adapter.notifyDataSetChanged();
        }
    }

}
