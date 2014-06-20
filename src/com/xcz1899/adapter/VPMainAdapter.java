/**
 * �����棬��Fragment����ViewPager��������
 */
package com.xcz1899.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class VPMainAdapter extends FragmentPagerAdapter {
	ArrayList<Fragment> fragmentList=new ArrayList<Fragment>();//���Fragment
	public VPMainAdapter(FragmentManager fm) {
		super(fm);		
	}
	public VPMainAdapter(FragmentManager fragmentManager,ArrayList<Fragment> arrayList) {
		super(fragmentManager);
		this.fragmentList=arrayList;
	}
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragmentList.size();
	}
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
