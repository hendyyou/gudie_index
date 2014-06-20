/**
 * APP��������
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
	ImageView mIVIndex, mIVFresh;// �ײ�������ͼ��
	ArrayList<ImageView> mALImage = new ArrayList<ImageView>();// ���ͼ�굽ArrayList�У����ڱ�������
	ArrayList<LinearLayout> mALLayout = new ArrayList<LinearLayout>();
	LinearLayout mLLIndex, mLLFresh;// �ײ�����ģ��

	MyViewPager mVPMain;// �ϰ벿��viewpager
	Fragment mFgtIndex, mFgtFresh;// ��Ӧ��������ҳ���Fragment
	ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();// ���Fragment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sp = Index.this.getSharedPreferences("ff",
				MODE_PRIVATE);// ���һ��SharedPreferences ����
		Editor editor = sp.edit();
		editor.putString("version", "old");
		editor.commit();

		setContentView(R.layout.index);

		initView();
		set();

	}

	/**
	 * ��ʼ��view
	 */
	private void initView() {
		mVPMain = (MyViewPager) findViewById(R.id.index_viewpager); // ��ҳ���ViewPager����

		mFgtIndex = new FragmentIndex();// ��һҳ��fragment
		mFgtFresh = new FragmentFresh();// �ڶ�ҳ��fragment

		mLLIndex = (LinearLayout) findViewById(R.id.index_index);// �ײ����������򣨰�������ͼ��͵������֣�
		mLLFresh = (LinearLayout) findViewById(R.id.index_fresh);// �ײ����������򣨰�������ͼ��͵������֣�

		mIVIndex = (ImageView) findViewById(R.id.index_index_image);// ImageView�����ã�ҳ���һ�ĵ���ͼ��
		mIVFresh = (ImageView) findViewById(R.id.index_fresh_image);// ImageView�����ã�ҳ���һ�ĵ���ͼ��

	}

	/**
	 * ��������
	 */
	private void set() {
		
		fragmentList.add(mFgtIndex);// ��FragmentIndex���뵽fragmentList���ArrayList�У����ڱ���
		fragmentList.add(mFgtFresh);
		
		mVPMain.setOffscreenPageLimit(5);// ������Ļ���5�������Լӿ��ٶ�
		mVPMain.setAdapter(new VPMainAdapter(getSupportFragmentManager(),
				fragmentList));// ����ViewPager��������
		mALImage.add(mIVIndex);// ��ImageView���뵽mALImage���ArrayList�У����ڱ���
		mALImage.add(mIVFresh);

		mALLayout.add(mLLIndex);// ��LinearLayout���뵽mALLayout���ArrayList�У����ڱ���
		mALLayout.add(mLLFresh);
		for (LinearLayout iv : mALLayout) {// �������е������Ϊ��ѡ��״̬��Ĭ��Ϊѡ�У�
			iv.setBackgroundColor(android.graphics.Color.parseColor("#EEEED1"));
		}
		mLLIndex.setBackgroundColor(android.graphics.Color
				.parseColor("#FFFFFF"));// ������ҳ��ͼ��Ϊѡ��״̬

		mLLIndex.setOnClickListener(this);// �������������ü�����
		mLLFresh.setOnClickListener(this);
	}

	/**
	 * �ı䵼��ͼ���״̬
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
	 * ������
	 */
	@Override
	public void onClick(View v) {// �����ť���£��ı䵼��ͼ��
		if (v.getId() == R.id.index_index) {
			setImageView(mLLIndex);
			mVPMain.setCurrentItem(0);// ����viewpager��ʾ��һ��fragment
		}
		if (v.getId() == R.id.index_fresh) {
			setImageView(mLLFresh);
			mVPMain.setCurrentItem(1);// ����Viewpager�ĵ�ǰFragment
		}

	}

}
