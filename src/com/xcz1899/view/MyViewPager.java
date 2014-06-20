/**
 * 自定义的ViewPager控件，取消了ViewPager的滑动属性
 */
package com.xcz1899.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {

	public MyViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyViewPager(Context context, AttributeSet attrs) {
		//有这个构造函数时，才可以在XML文件中使用该自定义View
		super(context, attrs);
	}
	//重写onTouchEvent，去掉Viewpager的滑动属性
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}

