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
import com.example.cuong.noqueuedemo.model.Food;
import com.example.cuong.noqueuedemo.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

public class FoodFragment extends Fragment {
    private RecyclerView mRecycleViewFood;
    private ArrayList<Food> mFoodList;
    private OrderAdapter mOrderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialView();
        initialData();
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

    private void initialData(){
        mFoodList = new ArrayList<>();
        mFoodList.add(new Food(R.mipmap.ic_1, "Cà phê đá", 30000));
        mFoodList.add(new Food(R.mipmap.ic_2, "Cà phê sữa", 30000));
        mFoodList.add(new Food(R.mipmap.ic_3, "Cà phê đá xây", 30000));
        mFoodList.add(new Food(R.mipmap.ic_4, "Latte coffee", 30000));
        mFoodList.add(new Food(R.mipmap.ic_5, "Matcha coffee", 30000));
        mFoodList.add(new Food(R.mipmap.ic_6, "Trà sữa", 30000));

        mOrderAdapter = new OrderAdapter(mFoodList, getActivity());
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
        addOrderExtraBottomDialogFragment.show(getFragmentManager(), "Show bottom sheet diaplog product detail");

    }
}
