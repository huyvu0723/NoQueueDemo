package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.fragment.ProductFragment;
import com.example.cuong.noqueuedemo.model.Product;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentPagerItemAdapter mAdapter;
    private ImageView mImgBack, mImgRefresh, mImgSearch;
    private LinearLayout mLnlCheckOut;
    private EditText mEdtShopName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initialData();
        intialView();
    }

    private void intialView() {
        mImgBack = findViewById(R.id.image_view_icon_back);
        mImgBack.setOnClickListener(this);
        mLnlCheckOut = findViewById(R.id.linear_layout_checkout_cart);
        mLnlCheckOut.setOnClickListener(this);
        mImgRefresh = findViewById(R.id.image_view_refresh);
        mImgRefresh.setOnClickListener(this);

        mImgSearch = findViewById(R.id.image_view_search);
        mImgSearch.setOnClickListener(this);
        mEdtShopName = findViewById(R.id.edit_text_shop_name);
        mEdtShopName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mEdtShopName.setHint("Phúc Long");
                mLnlCheckOut.requestFocus();
            }
        });

    }

    private void initialData() {

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(getApplicationContext());

        Bundle bundle = new Bundle();
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(R.mipmap.ic_traxanhdaxay, "Trà xanh đá xay", 35000));
        productList.add(new Product(R.mipmap.ic_travaisen, "Trà vải sen", 35000));
        productList.add(new Product(R.mipmap.ic_trasenhazelnutkemsua, "Trà sen hazelnut kem sữa", 35000));
        productList.add(new Product(R.mipmap.ic_traxanhxayalmond, "Trà xanh xay almond", 35000));
        productList.add(new Product(R.mipmap.ic_sinhtotraicaynhietdoi, "Sinh tố trái cây nhiệt đới", 35000));
        productList.add(new Product(R.mipmap.ic_sinhtotonghop, "Sinh tố tổng hợp", 35000));
        productList.add(new Product(R.mipmap.ic_sinhtochanh, "Sinh tố chanh", 35000));
        productList.add(new Product(R.mipmap.ic_ca_phe_bac_ha_da_xay, "Cà phê bạc hà đá xay", 35000));
        productList.add(new Product(R.mipmap.ic_caphecarameldaxay, "Cà phê caramel đá xay", 35000));
        bundle.putSerializable(ConstantDataManager.BUNDLE_HOME_DRINK, productList);
        bundle.putInt(ConstantDataManager.BUNDLE_IS_CATEGORY, 1);
        creator.add("Nước uống", ProductFragment.class, bundle);

        bundle = new Bundle();
        productList = new ArrayList<>();
        productList.add(new Product(R.mipmap.ic_comcalocbongkhoto, "Cơm chiên cá bông kho tộ", 35000));
        productList.add(new Product(R.mipmap.ic_comchien, "Cơm chiên", 35000));
        productList.add(new Product(R.mipmap.ic_comchiencamangaxe, "Cơm chiên cá mặn gà xé", 35000));
        productList.add(new Product(R.mipmap.ic_comchienphuclong, "Cơm chiên Phúc Long", 35000));
        productList.add(new Product(R.mipmap.ic_comduigaquayt, "Cơm đùi gà quay", 35000));
        productList.add(new Product(R.mipmap.ic_commuaxaochuacay, "Cơm mực xào chua cay", 35000));
        productList.add(new Product(R.mipmap.ic_hutieumytho, "Hủ tiếu Mỹ Tho", 35000));
        productList.add(new Product(R.mipmap.ic_myxaochay, "Mỳ xao chay", 35000));
        productList.add(new Product(R.mipmap.ic_myythitbobam, "Mỳ Ý Thịt Bò Bằm", 35000));
        bundle.putSerializable(ConstantDataManager.BUNDLE_HOME_DRINK, productList);
        bundle.putInt(ConstantDataManager.BUNDLE_IS_CATEGORY, 2);
        creator.add("Đồ ăn mặn", ProductFragment.class, bundle);

        bundle = new Bundle();
        productList = new ArrayList<>();
        productList.add(new Product(R.mipmap.ic_brownie_pax, "Brownie Pax", 35000));
        productList.add(new Product(R.mipmap.ic_butter_croissant, "Butter Croissant", 35000));
        productList.add(new Product(R.mipmap.ic_chocolatecroissant, "Chocolate Croissant", 35000));
        productList.add(new Product(R.mipmap.ic_passioncheesepax, "Passion Cheese Pax", 35000));
        productList.add(new Product(R.mipmap.ic_raisindanish, "Raisin Danish", 35000));
        productList.add(new Product(R.mipmap.ic_tiramisu, "Tiramisu", 35000));
        bundle.putSerializable(ConstantDataManager.BUNDLE_HOME_DRINK, productList);
        bundle.putInt(ConstantDataManager.BUNDLE_IS_CATEGORY, 3);
        creator.add("Bánh tráng miệng", ProductFragment.class, bundle);

        mAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(5);
        SmartTabLayout viewPagerTab = findViewById(R.id.view_pager_tab);
        viewPagerTab.setViewPager(viewPager);
    }


    public static void intentToOrderActivity(Activity activity) {
        Intent intent = new Intent(activity, OrderActivity.class);
        activity.startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_checkout_cart:
                CartActivity.intentToCartActivity(OrderActivity.this);
                break;
            case R.id.image_view_icon_back:
                finish();
                break;
            case R.id.image_view_refresh:
                showRefreshOrderDetailDialog();
                break;
            case R.id.image_view_search:

                mEdtShopName.requestFocus();
                mEdtShopName.setHint("Nhập tên món");
                break;

        }
    }

    private void showRefreshOrderDetailDialog() {
        final Dialog dialog = new Dialog(OrderActivity.this);
        dialog.setContentView(R.layout.dialog_refresh_order);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOK = dialog.findViewById(R.id.button_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
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
