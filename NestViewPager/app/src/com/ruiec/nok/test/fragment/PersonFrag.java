package com.ruiec.nok.test.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.ruiec.nok.test.Base.BaseFragment;
import com.ruiec.nok.test.R;


/**
 * 个人中心　
 * Created by Administrator on 2016/7/4.
 */
public class PersonFrag extends BaseFragment{

    @Override
    protected void lazyLoad() {

    }

    @Override
    public View initRootView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.person_frag,null);
        return view;
    }

    @Override
    protected void findView(View view) {

    }


}
