package com.huongtlu.app_thuc_don;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by BEHUONG on 2/25/2018.
 */

public class BuaAnAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BuaAn> buaan;
    private ArrayList<BuaAn> arrayList;

    public BuaAnAdapter(Context context, int layout, List<BuaAn> buaan) {
        this.context = context;
        this.layout = layout;
        this.buaan = buaan;
        this.arrayList=new ArrayList<BuaAn>();
        this.arrayList.addAll(buaan);
    }

    @Override
    public int getCount() {
        return buaan.size();
    }

    @Override
    public Object getItem(int i)
    {
        return buaan.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Số dòng trên item. Lấy phần từ contexxt.
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        //Ánh xạ view.
        TextView txtTen=(TextView) view.findViewById(R.id.txtName);
        TextView txtMota=(TextView) view.findViewById(R.id.txtOverview);
        ImageView imgHinh=(ImageView) view.findViewById(R.id.image);
        //Gán giá trị.
        BuaAn traicay=buaan.get(i);
        txtTen.setText(traicay.getName());
        txtMota.setText(traicay.getOverview());
        imgHinh.setImageResource(traicay.getImage());

        return view;
    }
    public void filter(String charText){
        charText=charText.toLowerCase(Locale.getDefault());

        buaan.clear();
        if(charText.length()==0){
            buaan.addAll(arrayList);
        }
        else
        {
            for(BuaAn buaAn:arrayList){
                if(buaAn.name.toLowerCase(Locale.getDefault()).contains(charText)){
                    buaan.add(buaAn);
                }
            }
        }
        notifyDataSetChanged();
    }
}
