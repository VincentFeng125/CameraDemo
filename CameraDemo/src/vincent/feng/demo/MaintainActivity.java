package vincent.feng.demo;

import java.util.ArrayList;
import java.util.List;

import vincent.feng.demo.fragment.main.FragmentScheduled;
import vincent.feng.demo.fragment.main.FragmentScheduling;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MaintainActivity extends FragmentActivity {

	private ViewPager mViewPager;

	private List<Fragment> mListFrags;

	private View mScheduledLine, mSchedulingLine;

	private LinearLayout mLayoutScheduled, mLayoutScheduling;

	private Button mEditButton;

	private int mCurrentPager = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_maintain);

		mListFrags = new ArrayList<Fragment>();

		mListFrags.add(new FragmentScheduled());
		mListFrags.add(new FragmentScheduling());

	}

	@Override
	protected void onPause() {
		super.onPause();

		mCurrentPager = mViewPager.getCurrentItem();

	}

	@Override
	protected void onResume() {
		super.onResume();

		mViewPager = (ViewPager) findViewById(R.id.viewPager);

		mLayoutScheduled = (LinearLayout) findViewById(R.id.item_scheduled);
		mLayoutScheduling = (LinearLayout) findViewById(R.id.item_scheduling);

		mLayoutScheduled.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setDisplayStatus(0);
				mViewPager.setCurrentItem(0);
			}
		});

		mLayoutScheduling.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setDisplayStatus(1);
				mViewPager.setCurrentItem(1);
			}
		});

		mScheduledLine = findViewById(R.id.img_scheduled);
		mSchedulingLine = findViewById(R.id.img_scheduling);

		mEditButton = (Button) findViewById(R.id.btn_schedule_edit);

		mEditButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "±à¼­°´Å¥click", Toast.LENGTH_SHORT).show();
			}
		});

		mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return mListFrags.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mListFrags.get(arg0);
			}
		});

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				setDisplayStatus(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

		mViewPager.setCurrentItem(mCurrentPager);
	}

	protected void setDisplayStatus(int arg0) {
		resetStatus();
		switch (arg0) {
		case 0:
			mScheduledLine.setBackgroundColor(Color.GRAY);
			mEditButton.setVisibility(View.VISIBLE);
			break;
		case 1:
			mSchedulingLine.setBackgroundColor(Color.GRAY);
			mEditButton.setVisibility(View.GONE);
			break;

		default:
			break;
		}

	}

	protected void resetStatus() {
		mScheduledLine.setBackgroundResource(0);
		mSchedulingLine.setBackgroundResource(0);
	}

}
