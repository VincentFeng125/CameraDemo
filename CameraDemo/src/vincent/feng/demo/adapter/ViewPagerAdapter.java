/**
 * ViewPagerAdapter.java
 * vincent.feng.demo.adapter
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年1月30日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ClassName:ViewPagerAdapter Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年1月30日 下午3:47:28
 */
public class ViewPagerAdapter extends PagerAdapter {

	private List<View> mViewLists;

	public ViewPagerAdapter(List<View> lists) {

		mViewLists = lists;
	}

	@Override
	public int getCount() {
		return mViewLists.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View view, int position, Object object) // 销毁Item
	{
		((ViewPager) view).removeView(mViewLists.get(position));
	}

	@Override
	public Object instantiateItem(View view, int position) // 实例化Item
	{
		((ViewPager) view).addView(mViewLists.get(position), 0);
		return mViewLists.get(position);
	}

}
