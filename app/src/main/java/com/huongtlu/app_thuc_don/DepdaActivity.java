package com.huongtlu.app_thuc_don;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class DepdaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lstda;
    public static ArrayList<BuaAn> arrTraicay;
    BuaAnAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depda);
        lstda=findViewById(R.id.listdepda);
        arrTraicay = new ArrayList<>();
        arrTraicay.add(new BuaAn("depda1", "Cháo trà xanh", R.drawable.depda1));
        arrTraicay.add(new BuaAn("depda2", "Cháo trai bổ dưỡng", R.drawable.depda2));
        arrTraicay.add(new BuaAn("Thông minh đẳng cấp", "Mỳ tôm Nhật thật", R.drawable.thongminh1));
        arrTraicay.add(new BuaAn("Đệ nhất gia đình", "Đậu, thịt, đỗ, kho", R.drawable.thongminh2));
        adapter = new BuaAnAdapter(this, R.layout.list_mon_an, arrTraicay);
        lstda.setAdapter(adapter);
        //Bắt sự kiện click
        lstda.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this,ViewMonanddActivity.class);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudd, menu);
        SearchView searchView;
        searchView = (SearchView) findViewById(R.id.txtSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s.trim());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.update:
                Intent intent = new Intent(DepdaActivity.this, Update_Activity.class);
                startActivity(intent);
                break;
            case R.id.thucdon:
                Intent intent1 = new Intent(DepdaActivity.this, ThucdonActivity.class);
                startActivity(intent1);
                break;
            case R.id.tuvan:
                doCalling();
        }
        return super.onOptionsItemSelected(item);
    }

    public void doCalling() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0971865431"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }
}
