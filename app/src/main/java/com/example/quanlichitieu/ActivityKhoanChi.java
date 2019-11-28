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

public class ActivityKhoanChi extends AppCompatActivity {
    //CustomAdapter.ItemFilter filter;
    private Button btnADD,btnBack,btnReset;
    private ListView lvKC;
    private EditText edtND,edtST;
    private List<KhoanChi> arrayKhoanChi;
    private CustomAdapter adapter;
    public static DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_chi);
        db = new DBManager(this);
        btnBack=findViewById(R.id.btnback);
        btnADD=findViewById(R.id.btnADD);
        lvKC=findViewById(R.id.lvKC);
        edtND=findViewById(R.id.edtND);
        edtST=findViewById(R.id.edtST);
        arrayKhoanChi=new ArrayList<>();
        arrayKhoanChi=db.getAllKC();
        setAdapter();
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhoanChi khoanChi= createKC();
                if(khoanChi!=null){
                    db.addKTC(khoanChi);
                    setAdapter();
                }
                arrayKhoanChi.clear();
                arrayKhoanChi.addAll(db.getAllKC());
                setAdapter();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ActivityKhoanChi.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnReset=findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtND.setText("");
                edtST.setText("");
            }
        });
    }

    public KhoanChi createKC(){
       String noidung = edtND.getText().toString();
       String sotien=edtST.getText().toString();
       KhoanChi khoanChi= new KhoanChi(noidung,sotien);
       return khoanChi;
    }
    public void setAdapter(){
        if(adapter==null){
            adapter=new CustomAdapter(this,R.layout.item_listview,arrayKhoanChi);
            lvKC.setAdapter(adapter);
           // adapter.notifyDataSetChanged();
        }
        else{
            adapter.notifyDataSetChanged();
           // lvKC.setSelection(adapter.getCount()-1);
        }
    }
}
