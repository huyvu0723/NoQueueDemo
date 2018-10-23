package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.ExtraAdapter;
import com.example.cuong.noqueuedemo.model.ProductExtra;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;
import com.example.cuong.noqueuedemo.utils.CurrencyManager;

import java.util.ArrayList;
import java.util.List;

public class EditOrderDetailActivity extends AppCompatActivity implements OnClickListener {

    private Button mBtnDone;
    private RecyclerView mRecyclerViewExtra;
    private ExtraAdapter mExtraAdapter;
    private TextView mTxtDeleteItem;
    private RadioButton mRbSizeM, mRbSizeL;
    private RadioGroup mRgSize;
    private TextView mTxtUnitPrice, mTxtTotal, mTxtQuantity, mTxtProductName;
    private LinearLayout mLnlDescrease, mLnlPlus, mLnlExtraList;
    private ImageView mImgProduct;
    private View mViewLine;

    private List<ProductExtra> mExtraList;
    private double mUnitPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order_detail);

        initialView();
        initialData();
    }

    private void initialView() {
        mRecyclerViewExtra = findViewById(R.id.recycle_view_extra);
        mRecyclerViewExtra.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(EditOrderDetailActivity.this
                , LinearLayoutManager.VERTICAL, false);
        mRecyclerViewExtra.setLayoutManager(layoutManager);

        mBtnDone = findViewById(R.id.button_done);
        mBtnDone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTxtUnitPrice = findViewById(R.id.text_view_product_price);
        mTxtTotal = findViewById(R.id.text_view_total);

        mTxtDeleteItem = findViewById(R.id.text_view_delete_product_item);
        mTxtDeleteItem.setOnClickListener(this);

        mRgSize = findViewById(R.id.radio_group_size);
        mRbSizeM = findViewById(R.id.radio_button_size_M);
        mRbSizeL = findViewById(R.id.radio_button_size_L);
        mTxtQuantity = findViewById(R.id.text_view_order_extra_quantity);
        mLnlPlus = findViewById(R.id.linear_layout_plus_green);
        mLnlPlus.setOnClickListener(this);
        mLnlDescrease = findViewById(R.id.linear_layout_decrease_green);
        mLnlDescrease.setOnClickListener(this);

        mImgProduct = findViewById(R.id.image_view_pic_url);
        mTxtProductName = findViewById(R.id.text_view_description);
        mLnlExtraList = findViewById(R.id.linear_layout_extra_list);
        mViewLine = findViewById(R.id.view_line);

        mRgSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int quantity = Integer.parseInt(mTxtQuantity.getText().toString());
                switch (checkedId) {
                    case R.id.radio_button_size_M:
                        mUnitPrice = 35000;
                        mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
                        mTxtTotal.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
                        break;
                    case R.id.radio_button_size_L:
                        mUnitPrice = 45000;
                        mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
                        mTxtTotal.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
                        break;
                }
            }
        });
    }

    private void initialData() {
        Bundle bundle = getIntent().getBundleExtra(ConstantDataManager.BUNDLE);
        int position = bundle.getInt(ConstantDataManager.BUNDLE_IS_PRODUCT);
        switch (position) {
            case 0:
                mUnitPrice = 35000;
                mImgProduct.setImageResource(R.mipmap.ic_traxanhdaxay);
                mTxtProductName.setText("Trà xanh đá xay");
                mRgSize.setVisibility(View.VISIBLE);
                mLnlExtraList.setVisibility(View.VISIBLE);
                mViewLine.setVisibility(View.VISIBLE);

                mExtraList = new ArrayList<>();
                mExtraList.add(new ProductExtra(1, "Thêm đá", 0, false));
                mExtraList.add(new ProductExtra(1, "Thêm đường", 0, false));

                mExtraAdapter = new ExtraAdapter((ArrayList<ProductExtra>) mExtraList,
                        EditOrderDetailActivity.this);
                mRecyclerViewExtra.setAdapter(mExtraAdapter);
                break;
            case 1:
                mUnitPrice = 35000;
                mImgProduct.setImageResource(R.mipmap.ic_comcalocbongkhoto);
                mTxtProductName.setText("Cơm cá lóc bông kho tộ");
                mRgSize.setVisibility(View.GONE);
                mLnlExtraList.setVisibility(View.VISIBLE);
                mViewLine.setVisibility(View.GONE);

                mExtraList = new ArrayList<>();
                mExtraList.add(new ProductExtra(1, "Thêm cơm", 0, false));
                mExtraList.add(new ProductExtra(1, "Thêm canh", 0, false));

                mExtraAdapter = new ExtraAdapter((ArrayList<ProductExtra>) mExtraList,
                        EditOrderDetailActivity.this);
                mRecyclerViewExtra.setAdapter(mExtraAdapter);
                break;
            case 2:
                mUnitPrice = 35000;
                mImgProduct.setImageResource(R.mipmap.ic_raisindanish);
                mTxtProductName.setText("Raisin Danish");
                mRgSize.setVisibility(View.GONE);
                mLnlExtraList.setVisibility(View.GONE);
                mViewLine.setVisibility(View.GONE);
                break;

        }
        mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice, " đ"));
        mTxtTotal.setText(CurrencyManager.getPrice(mUnitPrice, " đ"));


    }

    public static void intentToEditOrderDetailActivity(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, EditOrderDetailActivity.class);
        intent.putExtra(ConstantDataManager.BUNDLE, bundle);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_delete_product_item:
                showDeleteOrderDetailDialog();
                break;
            case R.id.linear_layout_plus_green:
                clickToButtonPlus();
                break;
            case R.id.linear_layout_decrease_green:
                clickToButtonDecrease();
                break;
        }
    }

    private void clickToButtonPlus() {
        int quantity = Integer.parseInt((String) mTxtQuantity.getText());
        quantity += 1;
        mTxtQuantity.setText(String.valueOf(quantity));
        mTxtTotal.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
        mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
    }


    private void clickToButtonDecrease() {
        int quantity = Integer.parseInt((String) mTxtQuantity.getText());
        if (quantity >= 2) {
            quantity -= 1;
        }
        mTxtQuantity.setText(String.valueOf(quantity));
        mTxtTotal.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
        mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice * quantity, " đ"));
    }


    private void showDeleteOrderDetailDialog() {
        final Dialog dialog = new Dialog(EditOrderDetailActivity.this);
        dialog.setContentView(R.layout.dialog_delete_order_detail);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOK = dialog.findViewById(R.id.button_ok);
        btnOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                EditOrderDetailActivity.this.finish();
            }
        });
        Button btnCancel = dialog.findViewById(R.id.button_cancel);
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
