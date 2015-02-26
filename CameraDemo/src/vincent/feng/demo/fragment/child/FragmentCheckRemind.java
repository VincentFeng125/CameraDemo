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
import vincent.feng.demo.SafeCheckDetailedActivity;
import vincent.feng.demo.adapter.SwitchAdapter;
import vincent.feng.demo.base.BaseFragment;
import vincent.feng.demo.base.OnListItemClickListener;
import vincent.feng.demo.entity.RemindItemEntity;
import android.content.Intent;
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
public class FragmentCheckRemind extends BaseFragment implements OnListItemClickListener {

	private List<RemindItemEntity> mDatas;

	private ImageView mImage;

	private Switch mSwitch;

	private ListView mListView;

	private SwitchAdapter mSwichAdapter;

	@Override
	protected int layoutResource() {
		return R.layout.tab_safe_check;
	}

	@Override
	protected void initialControl() {
		mImage = (ImageView) mView.findViewById(R.id.include_list_content_of_safe_check).findViewById(R.id.img_all_select);
		mSwitch = (Switch) mView.findViewById(R.id.include_list_content_of_safe_check).findViewById(R.id.switch_open_all);
		mListView = (ListView) mView.findViewById(R.id.include_list_content_of_safe_check).findViewById(R.id.listview_of);
	}

	@Override
	protected void setListener() {
		mSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					mSwichAdapter.selectAll();
				} else {
					mSwichAdapter.cancelAll();
				}
			}
		});
	}

	@Override
	protected void logic() {

		mDatas = new ArrayList<RemindItemEntity>();
		// 读取数据库 预留
		for (int i = 0; i < 6; i++) {
			RemindItemEntity entity = new RemindItemEntity();
			entity.setImageResource(R.drawable.ico);
			entity.setTitleName("排气系统");
			mDatas.add(entity);
		}
		mSwichAdapter = new SwitchAdapter(getActivity(), mDatas, true, this);
		mListView.setAdapter(mSwichAdapter);

	}

	@Override
	public void click(View view, int position, boolean isChecked) {

		switch (view.getId()) {

		// 详情设定
		case R.id.list_item_for_scheduling_settings:
			Intent _intent = new Intent(getActivity(), SafeCheckDetailedActivity.class);
			_intent.putExtra("title", mDatas.get(position).getTitleName());
			_intent.putExtra("img", mDatas.get(position).getImageResource());
			startActivity(_intent);
			break;

		// 开关
		case R.id.list_item_for_scheduling_switch:
			Toast.makeText(getActivity(), "开关[" + position + "]checked=" + isChecked, Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}
