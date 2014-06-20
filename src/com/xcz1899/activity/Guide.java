/**
 * 应用程序引导界面
 */
package com.xcz1899.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xcz1899.adapter.GuideViewGroupAdapter;
import com.xcz1899.guide_index.R;
import com.xcz1899.listener.ViewPagerListener;



public class Guide extends Activity {
	private ArrayList<ViewGroup> mALViewGroup;// 存放tab
	private LinearLayout mLLView1, mLLView2;// 需要滑动的tab
	private RelativeLayout mRLView3;// 最后一个tab
	private ViewPager mVPView;
	private Button mBtnLogin;// 进入APP主界面的按钮

	private ArrayList<ImageView> mALDotList;//存放底部导航点
	private LinearLayout mLLDotView;//底部导航区域

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sp = Guide.this.getSharedPreferences("ff",MODE_PRIVATE);// 使用SharedPreferences来保存版本
		if (sp.getString("version", "new").equals("old")) {
			Intent intent = new Intent(Guide.this, Index.class);// 点击后，进入主界面
			startActivity(intent);
			finish();// 关闭掉当前的Activity，不能再返回到这里
		} else {
			setContentView(R.layout.guide);
			initView();
			setViewPager();
		}

	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		mVPView = (ViewPager) findViewById(R.id.vp_guide);
		mLLDotView = (LinearLayout) findViewById(R.id.ll_dot_group);
		mALDotList = new ArrayList<ImageView>();
		mALViewGroup = new ArrayList<ViewGroup>();// 将要分页显示的View装入ArrayList中
	}

	/**
	 * 设置页面上部的Viewpager
	 */
	private void setViewPager() {

		LayoutInflater lf = getLayoutInflater().from(this);// 动态加载布局文件
		mLLView1 = (LinearLayout) lf.inflate(R.layout.guide_tab1, null);
		mLLView2 = (LinearLayout) lf.inflate(R.layout.guide_tab2, null);
		mRLView3 = (RelativeLayout) lf.inflate(R.layout.guide_tab3, null);
		
		mALViewGroup.add(mLLView1);
		mALViewGroup.add(mLLView2);
		mALViewGroup.add(mRLView3);

		mBtnLogin = (Button) mRLView3.getChildAt(1);
		mBtnLogin.setOnClickListener(new OnClickListener() {// 设置button按钮的监听器
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(Guide.this, Index.class);// 点击后，进入主界面
						startActivity(intent);
						finish();// 关闭掉当前的Activity，不能再返回到这里
					}
				});
		setDot(0);
		mVPView.setAdapter(new GuideViewGroupAdapter(mALViewGroup));// 把ViewGroup加入List中，再用适配器添加到ViewPager中
		mVPView.setOnPageChangeListener(new ViewPagerListener(this));// 添加监听器
	}

	/**
	 * 设置页面底部的导航圆点
	 */
	public void setDot(int j) {
	
		for (int i = 0; i < mALViewGroup.size(); i++) {
			mALDotList.add((ImageView) mLLDotView.getChildAt(i));// 把三个导航点加入到列表,每个导航点对应各自的viewpager页面
			mALDotList.get(i).setEnabled(false);// 设置导航点为非选中状态
		}
		mALDotList.get(j).setEnabled(true);	// 设置第一个导航点为选中状态
	}


}
