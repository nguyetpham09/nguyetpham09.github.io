package com.example.quanlichitieu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<KhoanChi> {
    private Context context;
    private int resource;
    private List<KhoanChi> arrayKhoanChi;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<KhoanChi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrayKhoanChi=objects;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
            viewHolder.tvNoidung=convertView.findViewById(R.id.tvND);
            viewHolder.tvSotien=convertView.findViewById(R.id.tvsotien);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        KhoanChi khoanChi=arrayKhoanChi.get(position);
        viewHolder.tvNoidung.setText(khoanChi.getmNoiDung());
        viewHolder.tvSotien.setText(khoanChi.getmSoTien());
        return convertView;
    }
    public class ViewHolder{
        TextView tvNoidung,tvSotien;
    }
}
