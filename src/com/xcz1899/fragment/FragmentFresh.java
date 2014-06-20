/**
 * 最新更新的Fragment
 */
package com.xcz1899.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xcz1899.guide_index.R;

public class FragmentFresh extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 动态加载View
		View view = inflater.inflate(R.layout.fragment, container, false);
		return view;
	}

}
