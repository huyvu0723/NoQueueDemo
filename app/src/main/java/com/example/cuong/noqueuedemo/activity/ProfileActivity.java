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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.facebook.accountkit.AccountKit;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mLnlMemberCard, mLnlPersonalInfo, mLnlMyCoupon, mLnlOrderHistory,
            mLnlAboutUs, mLnlContact, mLnlBack, mLnlPolicy;
    private TextView mTxtLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intialView();
    }

    public static void intentToProfileActivity(Activity activity) {
        Intent intent = new Intent(activity, ProfileActivity.class);
        activity.startActivity(intent);
    }

    private void intialView() {
        mLnlPersonalInfo = findViewById(R.id.linear_layout_personal_info);
        mLnlPersonalInfo.setOnClickListener(this);
        mLnlMyCoupon = findViewById(R.id.linear_layout_my_coupon);
        mLnlMyCoupon.setOnClickListener(this);
        mLnlOrderHistory = findViewById(R.id.linear_layout_order_history);
        mLnlOrderHistory.setOnClickListener(this);
        mLnlAboutUs = findViewById(R.id.linear_layout_about_us);
        mLnlAboutUs.setOnClickListener(this);
        mLnlContact = findViewById(R.id.linear_layout_contact);
        mLnlContact.setOnClickListener(this);
        mLnlBack = findViewById(R.id.linear_layout_icon_back);
        mLnlBack.setOnClickListener(this);
        mTxtLogout = findViewById(R.id.text_view_layout_logout);
        mTxtLogout.setOnClickListener(this);
        mLnlPolicy = findViewById(R.id.linear_layout_policy);
        mLnlPolicy.setOnClickListener(this);
        mLnlMemberCard = findViewById(R.id.linear_layout_member_card);
        mLnlMemberCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear_layout_member_card:
                MemberCardActivity.intentToMemberCardActivity(ProfileActivity.this);
                break;
            case R.id.linear_layout_personal_info:
                CustomerInfoActivity.intentToCustomerInfoActivity(ProfileActivity.this);
                break;
            case R.id.linear_layout_my_coupon:
                CouponActivity.intentToCouponActivity(ProfileActivity.this);
                break;
            case R.id.linear_layout_order_history:
                OrderHistoryActivity.intentToOrderHistoryActivity(ProfileActivity.this);
                break;
            case R.id.linear_layout_about_us:
                AboutUsActivity.intentToAboutUsActivity(ProfileActivity.this);
                break;
            case R.id.linear_layout_policy:
                PolicyActivity.intentToPolicyActivity(ProfileActivity.this);
                break;
            case R.id.linear_layout_contact:
                ContactActivity.intentToContactActivity(ProfileActivity.this);
                break;
            case R.id.text_view_layout_logout:
                showLogoutDialog();
                break;
            case R.id.linear_layout_icon_back:
                finish();
                break;
        }
    }

    private void showLogoutDialog() {
        final Dialog dialog = new Dialog(ProfileActivity.this);
        dialog.setContentView(R.layout.dialog_logout_confirm);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button logoutOK = dialog.findViewById(R.id.button_ok_logout);
        Button logoutCancel = dialog.findViewById(R.id.button_cancel_logout);
        logoutOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountKit.logOut();
                LoginActivity.intentToLoginActivity(ProfileActivity.this);
                finish();
            }
        });
        logoutCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
