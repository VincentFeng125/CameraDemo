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

/**
 * ClassName:FragmentSafeWaring Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月2日 下午3:03:49
 */
public class FragmentMaintainRemind extends BaseFragment implements OnListItemClickListener {

	private List<RemindItemEntity> mDatas;

	// 安全警报List Item 图像显示用
	// 暂未做出实现
	private ImageView mImage;

	private Switch mSwitch;

	private ListView mListView;

	private SwitchAdapter mSwitchAdapter;

	@Override
	protected int layoutResource() {
		return R.layout.tab_maintain_remind;
	}

	@Override
	protected void initialControl() {
		mImage = (ImageView) mView.findViewById(R.id.include_list_content_of_maintain_remind).findViewById(R.id.img_all_select);
		mSwitch = (Switch) mView.findViewById(R.id.include_list_content_of_maintain_remind).findViewById(R.id.switch_open_all);
		mListView = (ListView) mView.findViewById(R.id.include_list_content_of_maintain_remind).findViewById(R.id.listview_of);
	}

	@Override
	protected void setListener() {
		mSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					// 全部选中
					mSwitchAdapter.selectAll();
				} else {
					// 全部取消
					mSwitchAdapter.cancelAll();
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
			entity.setImageResource(R.drawable.pic_shutter);
			entity.setTitleName("变速油箱");
			mDatas.add(entity);
		}

		mSwitchAdapter = new SwitchAdapter(getActivity(), mDatas, true, this);
		mListView.setAdapter(mSwitchAdapter);

	}

	@Override
	public void click(View view, int position, boolean isChecked) {
		Intent _intent = new Intent(getActivity(), SafeCheckDetailedActivity.class);
		_intent.putExtra("title", mDatas.get(position).getTitleName());
		startActivity(_intent);
	}
}
