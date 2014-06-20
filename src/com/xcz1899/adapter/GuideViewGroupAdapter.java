/**
 * 引导界面的ViewPager的适配器
 */
package com.xcz1899.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class GuideViewGroupAdapter extends PagerAdapter {
	private ArrayList<ViewGroup> viewsList;

	public GuideViewGroupAdapter(ArrayList<ViewGroup> views) {
		this.viewsList = views;
	}

	@Override
	public int getCount() {
		return viewsList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView(viewsList.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager) container).addView(viewsList.get(position), 0);
		return viewsList.get(position);
	}
 

}
