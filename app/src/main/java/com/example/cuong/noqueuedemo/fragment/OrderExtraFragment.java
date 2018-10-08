package com.example.cuong.noqueuedemo.fragment;

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
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.ExtraAdapter;
import com.example.cuong.noqueuedemo.model.ProductExtra;

import java.util.ArrayList;

public class OrderExtraFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private Button mBtnClose;
    private RecyclerView mRecycleViewExtra;
    private ExtraAdapter mExtraAdapter;
    private ArrayList<ProductExtra> mExtraList;
    private LinearLayout mLnlAddToCart;


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
        initialData();
    }

    private void initialData() {
        mExtraList = new ArrayList<>();
        mExtraList.add(new ProductExtra(1, "Cơm thêm", 5000, false));
        mExtraList.add(new ProductExtra(1, "Canh", 5000, false));

        mExtraAdapter = new ExtraAdapter(mExtraList, getActivity());
        mRecycleViewExtra.setAdapter(mExtraAdapter);
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
        }
    }
}
