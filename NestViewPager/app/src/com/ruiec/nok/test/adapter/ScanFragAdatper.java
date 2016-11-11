package com.ruiec.nok.test.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.csdn.IconTabPageIndicator.xml.viewpagerindicator.IconPagerAdapter;
import com.ruiec.nok.test.Base.BaseFragment;
import com.ruiec.nok.test.R;
import com.ruiec.nok.test.scan.FourFrag;
import com.ruiec.nok.test.scan.OneFrag;
import com.ruiec.nok.test.scan.ThreeFrag;
import com.ruiec.nok.test.scan.TwoFrag;

import java.util.ArrayList;
import java.util.List;

public class ScanFragAdatper extends FragmentPagerAdapter implements IconPagerAdapter {
    public List<BaseFragment> fragments = new ArrayList<BaseFragment>();

    String[] titles = {"关注", "热门", "最新", "同城"};


    public ScanFragAdatper(FragmentManager fm) {
        super(fm);
        initTab();
    }

    public void initTab() {

        OneFrag oneFrag = new OneFrag();
        TwoFrag twoFrag = new TwoFrag();
        ThreeFrag threeFrag = new ThreeFrag();
        FourFrag fourFrag = new FourFrag();
        fragments.add(oneFrag);
        fragments.add(twoFrag);
        fragments.add(threeFrag);
        fragments.add(fourFrag);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


    @Override
    public BaseFragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return fragments.get(arg0);
    }

    @Override
    public int getIconResId(int index) {
        return fragments.get(index).getIconId();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragments.size();
    }


}
