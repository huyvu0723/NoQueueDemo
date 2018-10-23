package com.example.cuong.noqueuedemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class OrderExtraFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private Button mBtnClose;
    private RecyclerView mRecycleViewExtra;
    private ExtraAdapter mExtraAdapter;
    private ArrayList<ProductExtra> mExtraList;
    private LinearLayout mLnlAddToCart, mLnlAdd, mLnlSubstract, mLnlExtraList;
    private TextView mTxtUnitPrice, mTxtQuantity, mTxtTotal,
            mTxtProductname, mTxtDescription, mTxtDungThem;
    private RadioButton mRbSizeM, mRbSizeL;
    private RadioGroup mRgSize;
    private ImageView mImgProduct;
    private View mViewLine;


    private int isCategory;

    private double mUnitPrice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_extra, container, false);
    }

    public static OrderExtraFragment newInstance() {
        return new OrderExtraFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialView();
    }

    private void initialView() {
        mBtnClose = getView().findViewById(R.id.button_extra_close);
        mBtnClose.setOnClickListener(this);
        mLnlAddToCart = getView().findViewById(R.id.linear_layout_add_to_cart);
        mLnlAddToCart.setOnClickListener(this);
        mRecycleViewExtra = getView().findViewById(R.id.recycle_view_extra);
        mRecycleViewExtra.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecycleViewExtra.setLayoutManager(layoutManager);
        mLnlAdd = getView().findViewById(R.id.linear_layout_plus_green);
        mLnlAdd.setOnClickListener(this);
        mLnlSubstract = getView().findViewById(R.id.linear_layout_decrease_green);
        mLnlSubstract.setOnClickListener(this);
        mTxtUnitPrice = getView().findViewById(R.id.text_view_product_price);
        mTxtQuantity = getView().findViewById(R.id.text_view_order_extra_quantity);
        mTxtTotal = getView().findViewById(R.id.text_view_total);
        mViewLine = getView().findViewById(R.id.view_line);

        mLnlExtraList = getView().findViewById(R.id.linear_layout_extra_list);

        mRgSize = getView().findViewById(R.id.radio_group_size);
        mRbSizeM = getView().findViewById(R.id.radio_button_size_M);
        mRbSizeL = getView().findViewById(R.id.radio_button_size_L);
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

        mTxtProductname = getView().findViewById(R.id.text_view_product_name);
        mTxtDescription = getView().findViewById(R.id.text_view_description);
        mImgProduct = getView().findViewById(R.id.image_view_pic_url);
        mTxtDungThem = getView().findViewById(R.id.text_view_dung_them);


        initialData();
    }

    private void initialData() {
        Bundle bundle = getArguments();
        isCategory = bundle.getInt(ConstantDataManager.BUNDLE_IS_CATEGORY);
        switch (isCategory) {
            case 1:
                mUnitPrice = 35000;
                mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice, " đ"));
                mTxtProductname.setText("Trà xanh đá xay");
                mTxtDescription.setText("Hương trà xanh thơm mát hòa quyện vào sữa tươi nguyên chất");
                mImgProduct.setImageResource(R.mipmap.ic_traxanhdaxay);

                mExtraList = new ArrayList<>();
                mExtraList.add(new ProductExtra(1, "Thêm đá", 0, false));
                mExtraList.add(new ProductExtra(1, "Thêm đường", 0, false));

                mExtraAdapter = new ExtraAdapter(mExtraList, getActivity());
                mRecycleViewExtra.setAdapter(mExtraAdapter);
                break;
            case 2:
                mUnitPrice = 35000;
                mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice, " đ"));
                mTxtProductname.setText("Cơm cá lóc bông kho tộ");
                mTxtDescription.setText("Cá lóc thơm đậm, béo chắc giúp bữa cơm thêm nóng hổi, ngon miệng.");
                mImgProduct.setImageResource(R.mipmap.ic_comcalocbongkhoto);

                mRgSize.setVisibility(View.GONE);

                mExtraList = new ArrayList<>();
                mExtraList.add(new ProductExtra(1, "Thêm cơm", 0, false));
                mExtraList.add(new ProductExtra(1, "Thêm canh", 0, false));

                mExtraAdapter = new ExtraAdapter(mExtraList, getActivity());
                mRecycleViewExtra.setAdapter(mExtraAdapter);
                break;
            case 3:
                mRgSize.setVisibility(View.GONE);
                mRecycleViewExtra.setVisibility(View.GONE);
                mTxtDungThem.setVisibility(View.GONE);

                mUnitPrice = 35000;
                mTxtUnitPrice.setText(CurrencyManager.getPrice(mUnitPrice, " đ"));
                mTxtProductname.setText("Brownie Pax");
                mTxtDescription.setText("Brownies ngọt ngào quyện với cái béo ngậy và chua dịu của cream cheese");
                mImgProduct.setImageResource(R.mipmap.ic_brownie_pax);

                break;
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_extra_close:
                dismiss();
                break;
            case R.id.linear_layout_add_to_cart:
                dismiss();
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

}
