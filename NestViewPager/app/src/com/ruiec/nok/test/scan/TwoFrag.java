package com.ruiec.nok.test.scan;

import android.view.LayoutInflater;
import android.view.View;

import com.ruiec.nok.test.Base.BaseFragment;
import com.ruiec.nok.test.R;

public class TwoFrag extends BaseFragment {



	@Override
	public View initRootView(LayoutInflater inflater) {
		View view =inflater.inflate(R.layout.scan_two_frag,null);
		return view;
	}

	@Override
	protected void findView(View view) {

	}
	@Override
	protected void lazyLoad() {

	}
}
