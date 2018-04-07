package com.huongtlu.app_thuc_don;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_cb, btn_tp, btn_yt, btn_tt, btn_tv, btn_qn, btn_cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btn_cb.setOnClickListener(this);
        btn_tp.setOnClickListener(this);
        btn_qn.setOnClickListener(this);
        btn_cn.setOnClickListener(this);
        btn_tv.setOnClickListener(this);
        btn_yt.setOnClickListener(this);
    }

    private void Anhxa() {
        btn_cb = (Button) findViewById(R.id.btnChebien);
        btn_tp = (Button) findViewById(R.id.btnThucpham);
        btn_yt = (Button) findViewById(R.id.btnBuaan);
        btn_tt = (Button) findViewById(R.id.btnTintuc);
        btn_tv = (Button) findViewById(R.id.btnTuvan);
        btn_qn = (Button) findViewById(R.id.btnQuanan);
        btn_cn = (Button) findViewById(R.id.btnCapnhat);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId ();
        if (id == R.id.btnChebien) {
            //Menu tìm kiếm: theo Bữa sáng, trức, tối.
            Intent intent = new Intent (this, ThucdonActivity.class);
            startActivity(intent);
        }
        if (id == R.id.btnThucpham) {
            //Gọi tới activi list view tương tự như chế biến.
            Intent intent = new Intent (this, MonanDDActivity.class);
            startActivity(intent);
        }
        if (id == R.id.btnBuaan) {
            //Gọi tới hàm bữa ăn yêu thích.
            Toast.makeText (this, "Bữa ăn yêu thích trống", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.btnTintuc) {
            //Gọi tơi 1 activity tin tức: Đó là load trang Vnexpress đã làm( về chủ để sức khỏe. Phải có kết nói internet
            Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://suckhoe.vnexpress.net/"));
            startActivity (intent);
        }
        //Tư vấn người dùng
        if (id == R.id.btnTuvan) {
            doCalling();
        }
        if (id == R.id.btnQuanan) {
            //Call to quanngon on internet.
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.foody.vn/"));
            startActivity(i);
        }
        if (id == R.id.btnCapnhat) {
            //Gọi tới hàm cập nhật
            Intent intent = new Intent(this, Update_Activity.class);
            startActivity(intent);
        }
    }

    @SuppressLint("MissingPermission")
    public void doCalling() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0971865431"));
        startActivity(intent);
    }
}
