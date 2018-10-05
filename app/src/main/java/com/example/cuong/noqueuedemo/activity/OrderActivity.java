package com.example.cuong.noqueuedemo.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.fragment.FoodFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class OrderActivity extends AppCompatActivity {
    private FragmentPagerItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initialData();
    }

    private void initialData() {

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(getApplicationContext());
        creator.add("Cơm", FoodFragment.class);
        creator.add("Canh", FoodFragment.class);
        creator.add("Xào", FoodFragment.class);
        creator.add("Kho", FoodFragment.class);
        creator.add("Món phụ", FoodFragment.class);

        mAdapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                creator.create());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(5);
        SmartTabLayout viewPagerTab = findViewById(R.id.view_pager_tab);
        viewPagerTab.setViewPager(viewPager);
    }


}
