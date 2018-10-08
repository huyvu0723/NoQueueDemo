package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout mLnLBack;
    private Button mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        initialView();
    }


    private void initialView(){
        mLnLBack = findViewById(R.id.linear_layout_icon_back);
        mLnLBack.setOnClickListener(this);
        mBtnSave = findViewById(R.id.button_save_note);
        mBtnSave.setOnClickListener(this);
    }

    public static void intentToNoteActivity(Activity activity){
        Intent intent = new Intent(activity, NoteActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_layout_icon_back:
                finish();
                break;
            case R.id.button_save_note:
                finish();
                break;
        }
    }
}
