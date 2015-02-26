/**
 * FragmentSafeWaring.java
 * vincent.feng.demo.fragment.child
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年2月2日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.fragment.child;

import java.util.ArrayList;
import java.util.List;

import vincent.feng.demo.R;
import vincent.feng.demo.adapter.SwitchAdapter;
import vincent.feng.demo.base.BaseFragment;
import vincent.feng.demo.base.OnListItemClickListener;
import vincent.feng.demo.entity.RemindItemEntity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

/**
 * ClassName:FragmentSafeWaring Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月2日 下午3:03:49
 */
public class FragmentSafeWaring extends BaseFragment implements OnListItemClickListener {

	private List<RemindItemEntity> mDatas;

	private ImageView mImage;

	private Switch mSwitch;

	private ListView mListView;

	private SwitchAdapter mSwitchAdapter;

	@Override
	protected int layoutResource() {
		return R.layout.tab_safe_waring;
	}

	@Override
	protected void initialControl() {
		mImage = (ImageView) mView.findViewById(R.id.include_list_content_of_safe_waring).findViewById(R.id.img_all_select);
		mSwitch = (Switch) mView.findViewById(R.id.include_list_content_of_safe_waring).findViewById(R.id.switch_open_all);
		mListView = (ListView) mView.findViewById(R.id.include_list_content_of_safe_waring).findViewById(R.id.listview_of);
	}

	@Override
	protected void setListener() {
		mSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					mSwitchAdapter.selectAll();
				} else {
					mSwitchAdapter.cancelAll();
				}
			}
		});
	}

	@Override
	protected void logic() {

		mDatas = new ArrayList<RemindItemEntity>();
		// 读取数据库 预留
		for (int i = 0; i < 5; i++) {
			RemindItemEntity entity = new RemindItemEntity();
			entity.setImageResource(R.drawable.pic_point);
			entity.setTitleName("车门");
			mDatas.add(entity);
		}

		mSwitchAdapter = new SwitchAdapter(getActivity(), mDatas, false, this);
		mListView.setAdapter(mSwitchAdapter);

	}

	@Override
	public void click(View view, int position, boolean isChecked) {
		// 安全警报设置
		Toast.makeText(getActivity(), "开关[" + position + "]checked=" + isChecked, Toast.LENGTH_SHORT).show();
	}

}
