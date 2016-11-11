package com.ruiec.nok.test.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.csdn.IconTabPageIndicator.xml.viewpagerindicator.IconPagerAdapter;
import com.ruiec.nok.test.Base.BaseFragment;
import com.ruiec.nok.test.R;
import com.ruiec.nok.test.fragment.ScanFrag;
import com.ruiec.nok.test.fragment.SeedFrag;
import com.ruiec.nok.test.fragment.PersonFrag;


import java.util.ArrayList;
import java.util.List;

public class MainpagerAdatper extends FragmentPagerAdapter implements IconPagerAdapter {
    public List<BaseFragment> fragments = new ArrayList<BaseFragment>();
    private Context context;

    public MainpagerAdatper(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        initTab();
    }

    public void initTab() {
        ScanFrag productFrag = new ScanFrag();
        SeedFrag accountFrag = new SeedFrag();
        PersonFrag combinationFrag = new PersonFrag();


       // productFrag.setTitle(context.getResources().getString(R.string.tab1));
        productFrag.setIconId(R.drawable.tab_home_selector);
        // productFrag.setIconId(R.drawable.home);
        //home.setBgColor(R.color.black);
        fragments.add(productFrag);

    //    accountFrag.setTitle(context.getResources().getString(R.string.tab3));
        accountFrag.setIconId(R.drawable.tab_news_selector);
        //  accountFrag.setIconId(R.drawable.information_msg);
        //news.setBgColor(R.color.black);
        fragments.add(accountFrag);
        //combinationFrag.setTitle(context.getResources().getString(R.string.tab4));
        combinationFrag.setIconId(R.drawable.tab_person_selector);
        //   combinationFrag.setIconId(R.drawable.personalcenter);
        //person.setBgColor(R.color.black);
        fragments.add(combinationFrag);


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

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }


}
