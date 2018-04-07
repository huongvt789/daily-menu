package com.huongtlu.app_thuc_don;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Update_Activity extends AppCompatActivity {

    Database_update database_update;
    ListView lvGhichu;
    ArrayList<GhiChu_update> arrGhiChu;
    Update_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);
        lvGhichu = (ListView) findViewById(R.id.listghichu);
        arrGhiChu = new ArrayList<>();
        adapter = new Update_adapter(this, R.layout.dong_update, arrGhiChu);
        lvGhichu.setAdapter(adapter);

        database_update = new Database_update(this, "ghichu.sqlite", null, 1);
        database_update.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenGC VARCHAR(255))");
//        database_update.QueryData("INSERT INTO CongViec VALUES(null,'Món đậu kho cà chua mẹ thích')");
        GetDataCongViec();
    }

    private void GetDataCongViec() {
        //Xóa mảng cập nhật dữ liệu mới
        Cursor dataGhichu = database_update.GetData("SELECT * FROM CongViec");
        //here
        arrGhiChu.clear();
        while (dataGhichu.moveToNext()) {
            String ten = dataGhichu.getString(1);
            int id = dataGhichu.getInt(0);
            arrGhiChu.add(new GhiChu_update(id, ten));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_update, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            DialogThem();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogThem() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_addupdate);
        final EditText editThem = dialog.findViewById(R.id.editText);
        Button btnThem = dialog.findViewById(R.id.btnThem);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tennd = editThem.getText().toString();
                if (tennd.equals("")) {
                    Toast.makeText(Update_Activity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
                } else {
                    database_update.QueryData("INSERT INTO CongViec VALUES(null,'" + tennd + "')");
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });
        dialog.show();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void DialogXoaGC(String tengc, final int id) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        final AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa ghi chú" + tengc + "thật sự?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database_update.QueryData("DELETE FROM CongViec WHERE Id='" + id + "'");
                dialog.dismiss();
                GetDataCongViec();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialogXoa.show();
    }

    public void DialogSua(final int Id, String tenGC) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dong_edit);
        final EditText edt = (EditText) dialog.findViewById(R.id.edtSua);
        Button btnluu = (Button) dialog.findViewById(R.id.btnSave);
        edt.setText(tenGC);
        Button btnthoat = (Button) dialog.findViewById(R.id.btnCancel);
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tennd = edt.getText().toString();
                if (tennd.equals("")) {
                    Toast.makeText(Update_Activity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
                } else {
                    database_update.QueryData("UPDATE CongViec SET TenGC = '" + tennd + "' WHERE Id = '" + Id + "' ");
                    Toast.makeText(Update_Activity.this, "Đã sửa ghi chú", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
