package com.huongtlu.app_thuc_don;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class ViewMonanddActivity extends AppCompatActivity {
    ViewPager viewPager;
    BuaAnDetail_Adapter adapter;
    ArrayList<BuaAn> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_monandd);
        viewPager=(ViewPager) findViewById(R.id.pager2);
        adapter=new BuaAnDetail_Adapter(this,DepdaActivity.arrTraicay);
        viewPager.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudd, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.update:
                Intent intent = new Intent(ViewMonanddActivity.this, Update_Activity.class);
                startActivity(intent);
                break;
            case R.id.thucdon:
                Intent intent1 = new Intent(ViewMonanddActivity.this, ThucdonActivity.class);
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
