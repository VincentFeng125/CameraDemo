/**
 * SafeCheckDetailedActivity.java
 * vincent.feng.demo
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��2��6�� 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo;

import vincent.feng.demo.base.BaseActivity;
import vincent.feng.demo.base.BaseDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

/**
 * ClassName:SafeCheckDetailedActivity Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015��2��6�� ����11:21:50
 */
public class SafeCheckDetailedActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener, android.widget.RadioGroup.OnCheckedChangeListener {

	/**
	 * ���ذ�ť
	 */
	private Button mBtnReturn;

	/**
	 * �ظ����� ��ɰ�ť
	 */
	private Button mRepeatFinish;

	/**
	 * �Լ����LOGO
	 */
	private ImageView mTitleImage;

	/**
	 * �Լ����
	 */
	private TextView mTvTitle;

	/**
	 * �Լ쿪��
	 */
	private Switch mSwitchRemind;

	/**
	 * ָ���������ѿ���
	 */
	private Switch mSwitchSpecifiedDateRemind;

	/**
	 * �Զ����͵��ֻ��ͻ���
	 */
	private Switch mSwitchSendMsg;

	/**
	 * ����ʱ���ʾ��
	 */
	private TextView mRemindDate;

	/**
	 * �����ظ�������ڰ�ť
	 */
	private Button mBtnRepeatSettings;

	/**
	 * ���ȼ��趨RadioGroup
	 */
	private RadioGroup mRadioGroupForPriority;

	/**
	 * ����¼����
	 */
	private EditText mEdNote;

	/**
	 * ��ʾָ��ʱ���趨List
	 */
	private ListView mListViewForChooseRemindDate;

	private RadioGroup mRadioGroupForRepeatSettings;

	/**
	 * ������������ҳ��
	 */
	private View mView;

	private Intent mIntent;

	@Override
	protected int layoutResource() {
		return R.layout.activity_safe_check_settings;
	}

	@Override
	protected void init() {

		mView = findViewById(R.id.layout_remind_detailed);

		// ��������
		((TextView) findViewById(R.id.list_item_for_scheduling_settings)).setVisibility(View.INVISIBLE);

		mBtnReturn = (Button) findViewById(R.id.btn_return);
		mRepeatFinish = (Button) findViewById(R.id.btn_repeat_remind_finish);
		mBtnRepeatSettings = (Button) findViewById(R.id.btn_setting_repeat);

		mTitleImage = (ImageView) findViewById(R.id.list_item_for_scheduling_img);

		mTvTitle = (TextView) findViewById(R.id.list_item_for_scheduling_title);
		mRemindDate = (TextView) findViewById(R.id.tv_remind_date_show);

		mSwitchRemind = (Switch) findViewById(R.id.list_item_for_scheduling_switch);
		mSwitchSpecifiedDateRemind = (Switch) findViewById(R.id.switch_specified_date_remind);
		mSwitchSendMsg = (Switch) findViewById(R.id.switch_send_msg);

		mListViewForChooseRemindDate = (ListView) findViewById(R.id.listview_of_set_date_remind);
		mEdNote = (EditText) findViewById(R.id.edit_note);
		mRadioGroupForPriority = (RadioGroup) findViewById(R.id.radio_group_priority);

		mRadioGroupForRepeatSettings = (RadioGroup) findViewById(R.id.radio_group_remind_repeat_settings);

	}

	@Override
	protected void setListener() {
		mBtnReturn.setOnClickListener(this);
		mBtnRepeatSettings.setOnClickListener(this);
		mRepeatFinish.setOnClickListener(this);
		mSwitchRemind.setOnCheckedChangeListener(this);
		mSwitchSpecifiedDateRemind.setOnCheckedChangeListener(this);
		mSwitchSendMsg.setOnCheckedChangeListener(this);
		mRadioGroupForPriority.setOnCheckedChangeListener(this);
		mRadioGroupForRepeatSettings.setOnCheckedChangeListener(this);
	}

	@Override
	protected void logic() {
		mIntent = getIntent();
		String _title = mIntent.getExtras().getCharSequence("title").toString();
		int _imgResource = mIntent.getExtras().getInt("img");

		mTitleImage.setBackgroundResource(_imgResource);
		mTvTitle.setText(_title);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		// ָ���������ѿ���
		case R.id.switch_specified_date_remind:
			if (isChecked) {
				mView.setVisibility(View.VISIBLE);
			} else {
				mView.setVisibility(View.GONE);
			}
			break;
		// �Լ쿪��
		case R.id.list_item_for_scheduling_switch:

			break;
		// �Զ����͵��ֻ��ͻ��˿���
		case R.id.switch_send_msg:

			break;
		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// ����
		case R.id.btn_return:
			finish();
			break;
		// �ظ��趨
		case R.id.btn_setting_repeat:
			mRadioGroupForRepeatSettings.setVisibility(View.VISIBLE);
			break;
		// �ظ��趨���
		case R.id.btn_repeat_remind_finish:
			mRadioGroupForRepeatSettings.setVisibility(View.GONE);
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {

		// ���ȼ� ��Ӧ
		case R.id.radio_urgency:

			break;
		case R.id.radio_important:

			break;
		case R.id.radio_minor:

			break;

		// �ظ����� ��Ӧ
		case R.id.radio_every_day:

			break;
		case R.id.radio_every_week:

			break;
		case R.id.radio_every_month:

			break;
		case R.id.radio_every_custom:
			BaseDialog dialog = new BaseDialog(this);
			dialog.show();
			// ��ʾDialog
			break;

		default:
			break;
		}
	}

}
