/**
 * BaseDialog.java
 * vincent.feng.demo.base
 *
 * Function： 自定义对话框 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年2月9日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.base;

import vincent.feng.demo.R;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * ClassName:BaseDialog
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月9日 下午3:02:01
 */
@SuppressLint("InflateParams")
public class BaseDialog extends Dialog implements android.view.View.OnClickListener, OnCheckedChangeListener {

	/**
	 * 周期/频率设定入口
	 */
	private RelativeLayout mSettingCycle, mSettingFrequency;

	private Button mCloseDialog;

	private TextView mTvShowForCycle, mTvShowForFrequency;

	private RadioGroup mRadioGroupForCycle, mRadioGroupForFrequency;

	private TextView mTvForHint;

	private View mView;

	private String mTmpFrequency, mTmpCycle;

	private void init() {
		mCloseDialog = (Button) findViewById(R.id.btn_dialog_close);
		mSettingCycle = (RelativeLayout) findViewById(R.id.layout_setting_cycle);
		mSettingFrequency = (RelativeLayout) findViewById(R.id.layout_setting_frequency);
		mTvShowForCycle = (TextView) findViewById(R.id.tv_show_for_cycle);
		mTvShowForFrequency = (TextView) findViewById(R.id.tv_show_for_frequency);
		mTvForHint = (TextView) findViewById(R.id.tv_dialog_hint);

		mRadioGroupForFrequency = (RadioGroup) findViewById(R.id.radio_group_for_frequency);
		mRadioGroupForCycle = (RadioGroup) findViewById(R.id.radio_group_for_cycle);
	}

	public BaseDialog(Context context, int theme) {
		super(context, theme);
	}

	protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public BaseDialog(Context context) {
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_custom, null);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(mView);
		super.onCreate(savedInstanceState);

		init();
		setListener();
	}

	private void setListener() {
		mCloseDialog.setOnClickListener(this);
		mSettingCycle.setOnClickListener(this);
		mSettingFrequency.setOnClickListener(this);
		mRadioGroupForCycle.setOnCheckedChangeListener(this);
		mRadioGroupForFrequency.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_dialog_close:
			dismiss();
			break;
		case R.id.layout_setting_cycle:
			mRadioGroupForCycle.setVisibility(View.VISIBLE);
			break;
		case R.id.layout_setting_frequency:
			mRadioGroupForFrequency.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.radio_everyday:
			mTmpFrequency = "每天";
			break;
		case R.id.radio_everyweek:
			mTmpFrequency = "每周";
			break;
		case R.id.radio_everymonth:
			mTmpFrequency = "每月";
			break;
		case R.id.radio_1_day:
			mTmpCycle = "1天";
			break;
		case R.id.radio_2_day:
			mTmpCycle = "2天";
			break;
		case R.id.radio_3_day:
			mTmpCycle = "3天";
			break;
		default:
			break;
		}
		mTvShowForCycle.setText(mTmpCycle);
		mTvShowForFrequency.setText(mTmpFrequency);
		mTvForHint.setText("事件将" + mTmpFrequency + mTmpCycle + "重复一次");
	}

}
