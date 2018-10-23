package com.example.cuong.noqueuedemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.utils.ConstantDataManager;

public class MemberTypeFragment extends Fragment {
    private int mMemberType;
    private TextView mTxtPoint;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intialView();
        initialData();
    }

    private void intialView(){
        mTxtPoint = getView().findViewById(R.id.text_view_point);

    }

    private void initialData(){
        Bundle bundle = getArguments();
        mMemberType = bundle.getInt(ConstantDataManager.BUNDLE_MEMBERCARD_TYPE);
        switch(mMemberType){
            case 1:
                mTxtPoint.setText("Còn 68 điểm nữa để thăng hạng");
                break;
            case 2:
                mTxtPoint.setText("Còn 168 điểm nữa để thăng hạng");
                break;
            case 3:
                mTxtPoint.setText("Còn 468 điểm nữa để thăng hạng");
                break;
        }

    }

}
