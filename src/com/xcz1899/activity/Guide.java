/**
 * Ӧ�ó�����������
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
	private ArrayList<ViewGroup> mALViewGroup;// ���tab
	private LinearLayout mLLView1, mLLView2;// ��Ҫ������tab
	private RelativeLayout mRLView3;// ���һ��tab
	private ViewPager mVPView;
	private Button mBtnLogin;// ����APP������İ�ť

	private ArrayList<ImageView> mALDotList;//��ŵײ�������
	private LinearLayout mLLDotView;//�ײ���������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sp = Guide.this.getSharedPreferences("ff",MODE_PRIVATE);// ʹ��SharedPreferences������汾
		if (sp.getString("version", "new").equals("old")) {
			Intent intent = new Intent(Guide.this, Index.class);// ����󣬽���������
			startActivity(intent);
			finish();// �رյ���ǰ��Activity�������ٷ��ص�����
		} else {
			setContentView(R.layout.guide);
			initView();
			setViewPager();
		}

	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initView() {
		mVPView = (ViewPager) findViewById(R.id.vp_guide);
		mLLDotView = (LinearLayout) findViewById(R.id.ll_dot_group);
		mALDotList = new ArrayList<ImageView>();
		mALViewGroup = new ArrayList<ViewGroup>();// ��Ҫ��ҳ��ʾ��Viewװ��ArrayList��
	}

	/**
	 * ����ҳ���ϲ���Viewpager
	 */
	private void setViewPager() {

		LayoutInflater lf = getLayoutInflater().from(this);// ��̬���ز����ļ�
		mLLView1 = (LinearLayout) lf.inflate(R.layout.guide_tab1, null);
		mLLView2 = (LinearLayout) lf.inflate(R.layout.guide_tab2, null);
		mRLView3 = (RelativeLayout) lf.inflate(R.layout.guide_tab3, null);
		
		mALViewGroup.add(mLLView1);
		mALViewGroup.add(mLLView2);
		mALViewGroup.add(mRLView3);

		mBtnLogin = (Button) mRLView3.getChildAt(1);
		mBtnLogin.setOnClickListener(new OnClickListener() {// ����button��ť�ļ�����
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(Guide.this, Index.class);// ����󣬽���������
						startActivity(intent);
						finish();// �رյ���ǰ��Activity�������ٷ��ص�����
					}
				});
		setDot(0);
		mVPView.setAdapter(new GuideViewGroupAdapter(mALViewGroup));// ��ViewGroup����List�У�������������ӵ�ViewPager��
		mVPView.setOnPageChangeListener(new ViewPagerListener(this));// ��Ӽ�����
	}

	/**
	 * ����ҳ��ײ��ĵ���Բ��
	 */
	public void setDot(int j) {
	
		for (int i = 0; i < mALViewGroup.size(); i++) {
			mALDotList.add((ImageView) mLLDotView.getChildAt(i));// ��������������뵽�б�,ÿ���������Ӧ���Ե�viewpagerҳ��
			mALDotList.get(i).setEnabled(false);// ���õ�����Ϊ��ѡ��״̬
		}
		mALDotList.get(j).setEnabled(true);	// ���õ�һ��������Ϊѡ��״̬
	}


}
