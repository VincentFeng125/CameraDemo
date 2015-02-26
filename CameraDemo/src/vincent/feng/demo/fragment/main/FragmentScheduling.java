/**
 * FragmentScheduled.java
 * vincent.feng.demo.fragment
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年2月2日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.fragment.main;

import vincent.feng.demo.R;
import vincent.feng.demo.base.BaseFragment;
import vincent.feng.demo.fragment.child.FragmentCheckRemind;
import vincent.feng.demo.fragment.child.FragmentMaintainRemind;
import vincent.feng.demo.fragment.child.FragmentSafeWaring;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * ClassName:FragmentScheduled Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月2日 上午11:23:09
 */
public class FragmentScheduling extends BaseFragment implements OnCheckedChangeListener {

	private RadioGroup mRadioGroup;

	private Fragment mSafeWaringFragment, mCheckRemindFragment, mMaintainRemindFragment;

	private FragmentManager mFragmentManager;

	private FragmentTransaction transaction;

	private int mCurrentPos = 0;

	@Override
	protected void initialDatas() {

		// 创建Fragment对象
		mSafeWaringFragment = new FragmentSafeWaring();
		mCheckRemindFragment = new FragmentCheckRemind();
		mMaintainRemindFragment = new FragmentMaintainRemind();

		// 添加Fragment至FrameLayout中
		mFragmentManager = getFragmentManager();
		transaction = mFragmentManager.beginTransaction();
		transaction.add(R.id.layout_content, mSafeWaringFragment);
		transaction.add(R.id.layout_content, mCheckRemindFragment);
		transaction.add(R.id.layout_content, mMaintainRemindFragment);
		transaction.commit();
	}

	@Override
	protected int layoutResource() {
		return R.layout.activity_scheduling;
	}

	@Override
	protected void initialControl() {
		mRadioGroup = (RadioGroup) mView.findViewById(R.id.maintain_tab);
	}

	@Override
	protected void setListener() {
		mRadioGroup.setOnCheckedChangeListener(this);
	}

	@Override
	protected void logic() {
		switch (mCurrentPos) {
		case 0:
			((RadioButton) mView.findViewById(R.id.tab_safe_waring)).setChecked(true);
			break;
		case 1:
			((RadioButton) mView.findViewById(R.id.tab_safe_check_noti)).setChecked(true);
			break;
		case 2:
			((RadioButton) mView.findViewById(R.id.tab_maintain_noti)).setChecked(true);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		transaction = mFragmentManager.beginTransaction();

		// 隐藏所有Fragment页面
		hideFragment(transaction);

		switch (checkedId) {

		// 安全警报
		case R.id.tab_safe_waring:
			mCurrentPos = 0;
			transaction.show(mSafeWaringFragment);
			break;

		// 安全自检提醒
		case R.id.tab_safe_check_noti:
			mCurrentPos = 1;
			transaction.show(mCheckRemindFragment);
			break;

		// 保养提醒
		case R.id.tab_maintain_noti:
			mCurrentPos = 2;
			transaction.show(mMaintainRemindFragment);
			break;

		default:
			break;
		}

		transaction.commit();

	}

	protected void hideFragment(FragmentTransaction transaction) {
		transaction.hide(mSafeWaringFragment);
		transaction.hide(mCheckRemindFragment);
		transaction.hide(mMaintainRemindFragment);
	}

}
