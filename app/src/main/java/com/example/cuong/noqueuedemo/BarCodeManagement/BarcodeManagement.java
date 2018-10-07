package com.example.cuong.noqueuedemo.BarCodeManagement;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class BarcodeManagement {
    public static final int BARCODE = 1;
    public static final int QRCODE = 2;
    public static Bitmap getBarCode(Activity activity, String barcodeId, int mode) {
        WindowManager manager = (WindowManager) activity.getSystemService(activity.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        //Encode with a QR Code image
        QRCodeEncoder  barCodeEncoder = new QRCodeEncoder(barcodeId,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.CODE_128.toString(),
                smallerDimension);

        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(barcodeId,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.QR_CODE.toString(),
                smallerDimension);

        Bitmap bitmap = null;
        try {
            if (mode == QRCODE) {
                bitmap = qrCodeEncoder.encodeAsBitmap();
            } else {
                bitmap = barCodeEncoder.encodeAsBitmap();
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
