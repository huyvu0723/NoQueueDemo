package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.adapter.CartAdapter;
import com.example.cuong.noqueuedemo.model.OrderHistoryDetail;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout mLnlPromotion, mLnlNote, mLnlOrder;
    private TextView mLnlPayment;
    private RecyclerView mRecycleViewCart;
    private CartAdapter mCartAdapter;
    private ArrayList<OrderHistoryDetail> mFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        intialView();
        initalData();
    }


    public static void intentToCartActivity(Activity activity){
        Intent intent = new Intent(activity, CartActivity.class);
        activity.startActivity(intent);
    }

    private void intialView(){
        mLnlPromotion = findViewById(R.id.linear_layout_coupon);
        mLnlPromotion.setOnClickListener(this);
        mLnlNote = findViewById(R.id.linear_layout_note);
        mLnlNote.setOnClickListener(this);
        mLnlPayment = findViewById(R.id.text_view_edit_payment);
        mLnlPayment.setOnClickListener(this);
        mLnlOrder = findViewById(R.id.linear_layout_order);
        mLnlOrder.setOnClickListener(this);

        mRecycleViewCart = findViewById(R.id.recycle_view_cart);
        mRecycleViewCart.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(CartActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecycleViewCart.setLayoutManager(layoutManager);

    }

    private void initalData(){
        mFoodList = new ArrayList<>();
        mFoodList.add(new OrderHistoryDetail(R.mipmap.ic_1, "Cà phê sữa", "thêm 10% sữa", 35000));
        mFoodList.add(new OrderHistoryDetail(R.mipmap.ic_4, "Cà phê đá", "thêm 10% đường", 35000));
        mFoodList.add(new OrderHistoryDetail(R.mipmap.ic_3, "Cà phê đen", "thêm đá", 35000));

        mCartAdapter = new CartAdapter(mFoodList, CartActivity.this);
        mRecycleViewCart.setAdapter(mCartAdapter);
        mCartAdapter.setmOnClickToFoodItem(new CartAdapter.OnClickToFoodItem() {
            @Override
            public void setOnClickToItem(int position) {
                EditOrderDetailActivity.intentToEditOrderDetailActivity(CartActivity.this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_coupon:
                PromotionActivity.intentToPromotionActivity(CartActivity.this);
                break;
            case R.id.edit_text_add_promotion_code:
                PromotionActivity.intentToPromotionActivity(CartActivity.this);
                break;
            case R.id.linear_layout_note:
                NoteActivity.intentToNoteActivity(CartActivity.this);
                break;
            case R.id.edit_text_get_note:
                NoteActivity.intentToNoteActivity(CartActivity.this);
                break;
            case R.id.text_view_edit_payment:
                PaymentActivity.intentToPaymentActivity(CartActivity.this);
                break;
            case R.id.linear_layout_order:
                OrderSuccessActivity.intentToOrderSuccessActivity(CartActivity.this);
                finish();
                break;
        }
    }
}
