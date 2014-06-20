/**
 * APP的主界面
 */
package com.xcz1899.activity;

import java.util.ArrayList;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xcz1899.adapter.VPMainAdapter;
import com.xcz1899.fragment.FragmentFresh;
import com.xcz1899.fragment.FragmentIndex;
import com.xcz1899.guide_index.R;
import com.xcz1899.guide_index.R.id;
import com.xcz1899.guide_index.R.layout;
import com.xcz1899.view.MyViewPager;

public class Index extends FragmentActivity implements OnClickListener {
	ImageView mIVIndex, mIVFresh;// 底部导航的图标
	ArrayList<ImageView> mALImage = new ArrayList<ImageView>();// 存放图标到ArrayList中，便于遍历操作
	ArrayList<LinearLayout> mALLayout = new ArrayList<LinearLayout>();
	LinearLayout mLLIndex, mLLFresh;// 底部导航模块

	MyViewPager mVPMain;// 上半部的viewpager
	Fragment mFgtIndex, mFgtFresh;// 对应的两个子页面的Fragment
	ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();// 存放Fragment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sp = Index.this.getSharedPreferences("ff",
				MODE_PRIVATE);// 获得一个SharedPreferences 对象
		Editor editor = sp.edit();
		editor.putString("version", "old");
		editor.commit();

		setContentView(R.layout.index);

		initView();
		set();

	}

	/**
	 * 初始化view
	 */
	private void initView() {
		mVPMain = (MyViewPager) findViewById(R.id.index_viewpager); // 主页面的ViewPager对象

		mFgtIndex = new FragmentIndex();// 第一页的fragment
		mFgtFresh = new FragmentFresh();// 第二页的fragment

		mLLIndex = (LinearLayout) findViewById(R.id.index_index);// 底部导航的区域（包括导航图标和导航文字）
		mLLFresh = (LinearLayout) findViewById(R.id.index_fresh);// 底部导航的区域（包括导航图标和导航文字）

		mIVIndex = (ImageView) findViewById(R.id.index_index_image);// ImageView的设置，页面第一的导航图标
		mIVFresh = (ImageView) findViewById(R.id.index_fresh_image);// ImageView的设置，页面第一的导航图标

	}

	/**
	 * 加载设置
	 */
	private void set() {
		
		fragmentList.add(mFgtIndex);// 把FragmentIndex加入到fragmentList这个ArrayList中，便于遍历
		fragmentList.add(mFgtFresh);
		
		mVPMain.setOffscreenPageLimit(5);// 缓存屏幕最多5个，可以加快速度
		mVPMain.setAdapter(new VPMainAdapter(getSupportFragmentManager(),
				fragmentList));// 设置ViewPager的适配器
		mALImage.add(mIVIndex);// 把ImageView加入到mALImage这个ArrayList中，便于遍历
		mALImage.add(mIVFresh);

		mALLayout.add(mLLIndex);// 把LinearLayout加入到mALLayout这个ArrayList中，便于遍历
		mALLayout.add(mLLFresh);
		for (LinearLayout iv : mALLayout) {// 设置所有的区域均为非选中状态（默认为选中）
			iv.setBackgroundColor(android.graphics.Color.parseColor("#EEEED1"));
		}
		mLLIndex.setBackgroundColor(android.graphics.Color
				.parseColor("#FFFFFF"));// 设置首页的图标为选中状态

		mLLIndex.setOnClickListener(this);// 给导航区域设置监听器
		mLLFresh.setOnClickListener(this);
	}

	/**
	 * 改变导航图标的状态
	 * 
	 * @param imageView
	 */
	public void setImageView(LinearLayout view) {
		for (LinearLayout iv : mALLayout) {
			/* iv.setEnabled(false); */
			iv.setBackgroundColor(android.graphics.Color.parseColor("#EEEED1"));
		}
		/* imageView.setEnabled(true); */

		view.setBackgroundColor(android.graphics.Color.parseColor("#FFFFFF"));
	}

	/**
	 * 监听器
	 */
	@Override
	public void onClick(View v) {// 如果按钮按下，改变导航图标
		if (v.getId() == R.id.index_index) {
			setImageView(mLLIndex);
			mVPMain.setCurrentItem(0);// 设置viewpager显示第一个fragment
		}
		if (v.getId() == R.id.index_fresh) {
			setImageView(mLLFresh);
			mVPMain.setCurrentItem(1);// 设置Viewpager的当前Fragment
		}

	}

}
