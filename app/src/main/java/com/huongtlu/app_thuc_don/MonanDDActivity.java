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
import android.widget.Button;
import android.widget.SearchView;

public class MonanDDActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnda,btntminh,btnndong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monan_dd);
        btnda=findViewById(R.id.btnda);
        btntminh=findViewById(R.id.btnthongminh);
        btnndong=findViewById(R.id.btnnangdong);
        btnda.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btnda){
            Intent intent=new Intent(MonanDDActivity.this,DepdaActivity.class);
            startActivity(intent);
        }
        if (id==R.id.btnthongminh){

        }
        if(id==R.id.btnnangdong){

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudd, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.update:
                Intent intent = new Intent(MonanDDActivity.this, Update_Activity.class);
                startActivity(intent);
                break;
            case R.id.thucdon:
                Intent intent1 = new Intent(MonanDDActivity.this, ThucdonActivity.class);
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
