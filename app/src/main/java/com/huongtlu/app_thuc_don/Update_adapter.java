package com.huongtlu.app_thuc_don;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BEHUONG on 3/4/2018.
 */

public class Update_adapter extends BaseAdapter {
    private Update_Activity context;

    private int layout;
    private List<GhiChu_update> arrGhichu;

    public Update_adapter(Update_Activity context, int layout, List<GhiChu_update> arrGhichu) {
        this.context = context;
        this.layout = layout;
        this.arrGhichu = arrGhichu;
    }

    @Override
    public int getCount() {
        return arrGhichu.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtTen;
        ImageView imgd, imge;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = (TextView) view.findViewById(R.id.txtNoidung);
            holder.imgd = (ImageView) view.findViewById(R.id.imgDelete);
            holder.imge = (ImageView) view.findViewById(R.id.imgEdit);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final GhiChu_update ghiChu_update = arrGhichu.get(i);
        holder.txtTen.setText(ghiChu_update.getTenGC());

        //Bắt sự kiện
        holder.imgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoaGC(ghiChu_update.getTenGC(), ghiChu_update.getIdGC());
            }
        });
        holder.imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogSua(ghiChu_update.getIdGC(), ghiChu_update.getTenGC());
            }
        });
        return view;
    }
}
