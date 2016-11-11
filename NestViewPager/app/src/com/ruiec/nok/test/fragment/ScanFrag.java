package com.ruiec.nok.test.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ruiec.nok.test.Base.BaseFragment;
import com.ruiec.nok.test.R;
import com.ruiec.nok.test.adapter.ScanFragAdatper;
import org.lmw.demo.slidingtab.widget.PagerSlidingTabStrip;
/**
 * 浏览观看直播　
 * Created by Administrator on 2016/7/4.
 */
public class ScanFrag extends BaseFragment {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private ScanFragAdatper scanFragAdatper;


    @Override
    protected void lazyLoad() {

    }

    @Override
    public View initRootView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.home_frag, null);

        return view;
    }

    @Override
    protected void findView(View view) {
        this.pager = (ViewPager) view.findViewById(R.id.pager);
        this.tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        scanFragAdatper=new ScanFragAdatper(getActivity().getSupportFragmentManager());
        pager.setAdapter(scanFragAdatper);
        tabs.setViewPager(pager);
    }



}

