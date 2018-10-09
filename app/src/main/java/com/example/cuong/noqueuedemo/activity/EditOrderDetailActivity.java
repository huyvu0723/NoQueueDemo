package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;

public class EditOrderDetailActivity extends AppCompatActivity {
    private ImageView mImgDescrease;
    private Button mBtnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order_detail);
        mImgDescrease = findViewById(R.id.image_view_decrease);
        mImgDescrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteOrderDetailDialog();
            }
        });
        mBtnDone =  findViewById(R.id.button_done);
        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void intentToEditOrderDetailActivity(Activity activity){
        Intent intent = new Intent(activity, EditOrderDetailActivity.class);
        activity.startActivity(intent);
    }


    private void showDeleteOrderDetailDialog() {
        final Dialog dialog = new Dialog(EditOrderDetailActivity.this);
        dialog.setContentView(R.layout.dialog_delete_order_detail);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOK = dialog.findViewById(R.id.button_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                EditOrderDetailActivity.this.finish();
            }
        });
        Button btnCancel = dialog.findViewById(R.id.button_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
