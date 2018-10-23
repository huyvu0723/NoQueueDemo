package com.example.cuong.noqueuedemo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.OrderAdapter;
import com.example.cuong.noqueuedemo.model.Product;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;
import com.example.cuong.noqueuedemo.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

public class ProductFragment extends Fragment {
    private RecyclerView mRecycleViewFood;
    private ArrayList<Product> mProductList;
    private OrderAdapter mOrderAdapter;
    private int isCategory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getInitialIntent();
        initialView();
        initialData();
    }

    private void getInitialIntent() {
        Bundle bundle = getArguments();
        mProductList = (ArrayList<Product>) bundle.getSerializable(ConstantDataManager.BUNDLE_HOME_DRINK);
        isCategory = bundle.getInt(ConstantDataManager.BUNDLE_IS_CATEGORY);
    }

    private void initialView() {
        mRecycleViewFood = getView().findViewById(R.id.recycle_view_food);
        mRecycleViewFood.setHasFixedSize(true);
        int numberOfColumn = calculateNumberOfColumns(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), numberOfColumn);
        mRecycleViewFood.setLayoutManager(gridLayoutManager);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.dp10);
        mRecycleViewFood.addItemDecoration(new GridSpacingItemDecoration(
                numberOfColumn, spacingInPixels, true));
    }

    private void initialData() {
        mOrderAdapter = new OrderAdapter(mProductList, getActivity());
        mRecycleViewFood.setAdapter(mOrderAdapter);
        mOrderAdapter.setmOnClickToProductItem(new OrderAdapter.OnClickToProductItem() {
            @Override
            public void setOnClickToProductItem(int position) {
                showBottomSheet(position);
            }
        });
    }

    private int calculateNumberOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }

    private void showBottomSheet(final int position) {
        final OrderExtraFragment addOrderExtraBottomDialogFragment = OrderExtraFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantDataManager.BUNDLE_IS_CATEGORY, isCategory);
        addOrderExtraBottomDialogFragment.setArguments(bundle);
        addOrderExtraBottomDialogFragment.show(getFragmentManager(), "Show bottom sheet diaplog product detail");
    }
}
