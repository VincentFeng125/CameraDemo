/**
 * FragmentSafeWaring.java
 * vincent.feng.demo.fragment.child
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��2��2�� 		FengZhe
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
 * @Date 2015��2��2�� ����3:03:49
 */
public class FragmentMaintainRemind extends BaseFragment implements OnListItemClickListener {

	private List<RemindItemEntity> mDatas;

	// ��ȫ����List Item ͼ����ʾ��
	// ��δ����ʵ��
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
					// ȫ��ѡ��
					mSwitchAdapter.selectAll();
				} else {
					// ȫ��ȡ��
					mSwitchAdapter.cancelAll();
				}
			}
		});
	}

	@Override
	protected void logic() {

		mDatas = new ArrayList<RemindItemEntity>();

		// ��ȡ���ݿ� Ԥ��
		for (int i = 0; i < 6; i++) {
			RemindItemEntity entity = new RemindItemEntity();
			entity.setImageResource(R.drawable.pic_shutter);
			entity.setTitleName("��������");
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
