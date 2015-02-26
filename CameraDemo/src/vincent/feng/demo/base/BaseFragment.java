/**
 * BaseFragment.java
 * vincent.feng.demo.base
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年2月2日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ClassName:BaseFragment Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月2日 下午4:10:47
 */
public abstract class BaseFragment extends Fragment {

	protected View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		mView = inflater.inflate(layoutResource(), null);
		initialDatas();
		initialControl();
		setListener();
		return mView;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onResume() {
		super.onResume();
		logic();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
		}
		// initialDatas();

	}

	@Override
	public void onAttach(Activity activity) {

		Log.w("onAttach()", "onAttach");
		super.onAttach(activity);

	}

	@Override
	public void onDetach() {

		Log.w("onDetach()", "onDetach");
		super.onDetach();

	}

	protected void initialDatas() {
	}

	abstract protected int layoutResource();

	abstract protected void initialControl();

	abstract protected void setListener();

	abstract protected void logic();

}
