/**
 * ��������ViewPager�ļ���������������ʱ�򣬸ı�ҳ�������С��
 */
package com.xcz1899.listener;

import com.xcz1899.activity.Guide;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ViewPagerListener implements OnPageChangeListener  {
	Guide guide;
	public ViewPagerListener(Guide g){
		this.guide=g;
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		//���õ�ǰ��С��
		guide.setDot(arg0);
		
	}


}
