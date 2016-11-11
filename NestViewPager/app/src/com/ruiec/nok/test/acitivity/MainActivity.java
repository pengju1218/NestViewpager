package com.ruiec.nok.test.acitivity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.csdn.IconTabPageIndicator.icon.IconTabPageIndicator;
import com.ruiec.nok.test.Base.BaseActivity;
import com.ruiec.nok.test.R;
import com.ruiec.nok.test.adapter.MainpagerAdatper;

import java.net.UnknownHostException;

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private IconTabPageIndicator mIndicator;
    private MainpagerAdatper adapter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mIndicator = (IconTabPageIndicator) findViewById(R.id.indicator);
        adapter = new MainpagerAdatper(getSupportFragmentManager(), this);
        mViewPager.setAdapter(adapter);
        mIndicator.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

    }


}
