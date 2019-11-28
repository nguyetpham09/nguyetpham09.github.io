package com.example.quanlichitieu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="khoanthuchi_list";
    private static final String TABLE_NAME="khoanthuchi";
    private static final String NOIDUNG="noidung";
    private static final String SOTIEN="sotien";
    private Context context;
    public DBManager(Context context){
        super(context,DATABASE_NAME,null,1);
        Log.d("DBManager","DBManager: ");
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery="CREATE TABLE "+TABLE_NAME+" ("+NOIDUNG+" TEXT,"+SOTIEN+" TEXT)";
        sqLiteDatabase.execSQL(sqlQuery);
        Toast.makeText(context,"Create successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
        Toast.makeText(context,"Drop successfully",Toast.LENGTH_SHORT).show();
    }
    //Add a new KC
    public void addKTC(KhoanChi khoanChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOIDUNG,khoanChi.getmNoiDung());
        values.put(SOTIEN,khoanChi.getmSoTien());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public List<KhoanChi> getAllKC(){
        List<KhoanChi> listKTC = new ArrayList<KhoanChi>();
        String  selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                KhoanChi khoanChi = new KhoanChi();
                khoanChi.setmNoiDung(cursor.getString(0));
                khoanChi.setmSoTien(cursor.getString(1));
                listKTC.add(khoanChi);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listKTC;
    }
    public void hello(){
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show();
    }
}
