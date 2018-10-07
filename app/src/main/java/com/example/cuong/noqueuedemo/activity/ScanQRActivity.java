package com.example.cuong.noqueuedemo.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.noqueuedemo.R;

import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;

public class ScanQRActivity extends AppCompatActivity implements View.OnClickListener{
    private ScannerLiveView camera;
    private LinearLayout mLnlBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);
        initialView();
        initialData();
    }

    public static void intentToScanQRActivity(Activity activity) {
        Intent intent = new Intent(activity, ScanQRActivity.class);
        activity.startActivity(intent);
    }


    private void initialView() {
        camera = findViewById(R.id.camView);
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
    }

    private void initialData() {
        shouldAskPermission();
        camera.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
            @Override
            public void onScannerStarted(ScannerLiveView scanner) {

            }

            @Override
            public void onScannerStopped(ScannerLiveView scanner) {

            }

            @Override
            public void onScannerError(Throwable err) {

            }

            @Override
            public void onCodeScanned(String data) {
//                Toast.makeText(ScanQRActivity.this, data, Toast.LENGTH_SHORT).show();

                showTableNumberDialog(data);
                if (camera != null) {
                    if (camera.getCamera() != null && camera.getCamera().getController() != null) {
                        camera.getCamera().getController().switchFlashlight(false);
                    }
                    camera.stopScanner();
                }
            }
        });
    }

    private void showTableNumberDialog(String tableNumber) {
        Dialog dialog = new Dialog(ScanQRActivity.this);
        dialog.setContentView(R.layout.dialog_table_number);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView txtTableNumber = dialog.findViewById(R.id.text_view_table_number);
        txtTableNumber.setText("Bạn đang ở bàn số " + tableNumber);
        Button btnChooseFood = dialog.findViewById(R.id.button_choose_food);
        btnChooseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderActivity.intentToOrderActivity(ScanQRActivity.this);
                finish();
            }
        });
        dialog.show();
    }

    private void shouldAskPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    100);
        } else {
            startScanner();
        }
    }

    private void startScanner() {
        ZXDecoder decoder = new ZXDecoder();
        decoder.setScanAreaPercent(0.5);
        camera.setDecoder(decoder);
        camera.startScanner();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startScanner();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_icon_back:
                finish();
                break;
        }
    }
}
