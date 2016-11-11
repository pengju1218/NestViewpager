package com.ruiec.nok.test.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.ruiec.nok.test.Base.BaseFragment;
import com.ruiec.nok.test.R;

/**
 * 直播
 * Created by Administrator on 2016/7/4.
 */
public class SeedFrag extends BaseFragment {


    @Override
    protected void lazyLoad() {

    }

    @Override
    public View initRootView(LayoutInflater inflater) {

        View view = inflater.inflate(R.layout.info_frag, null);
        return view;
    }

    @Override
    protected void findView(View view) {

    }


}
