package com.hoctienganh.demomvp0.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hoctienganh.demomvp0.R;
import com.hoctienganh.demomvp0.data.DanhSach;

import java.util.List;

public class MainListAdapter extends BaseAdapter{
    private int layout;
    private List<DanhSach> list;
    private Context context;

    public MainListAdapter(int layout, List<DanhSach> list, Context context) {
        this.layout = layout;
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    class ViewHolder{
        TextView txtNoiDung;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtNoiDung = convertView.findViewById(R.id.txtNoiDung);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        DanhSach danhSach = list.get(position);
        holder.txtNoiDung.setText(danhSach.getNoiDung());

        return convertView;
    }
}
