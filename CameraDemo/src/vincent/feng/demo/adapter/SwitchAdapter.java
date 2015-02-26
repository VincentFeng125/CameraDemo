/**
 * SwitchAdapter.java
 * vincent.feng.demo.adapter
 *
 * Function�� ��ȫ�������Լ����ѡ��������� ListView Item������ 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��2��3�� 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.adapter;

import java.util.List;

import vincent.feng.demo.R;
import vincent.feng.demo.base.OnListItemClickListener;
import vincent.feng.demo.entity.RemindItemEntity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * ClassName:SwitchAdapter Function: ��ȫ�������Լ����ѡ��������� ListView Item������
 *
 * @author FengZhe
 * @version
 * @Date 2015��2��3�� ����4:35:31
 */
public class SwitchAdapter extends BaseAdapter {

	private List<RemindItemEntity> mDatas;
	private Context mContext;
	private Boolean mIsShowDetailed;

	private OnListItemClickListener mClickListener;

	/**
	 * 
	 * Creates a new instance of SwitchAdapter.
	 *
	 * @param context
	 * @param datas
	 * @param isShowDetailed
	 *            �Ƿ���ʾ[��������]�ֶ� true=��ʾ
	 */
	public SwitchAdapter(Context context, List<RemindItemEntity> datas, boolean isShowDetailed, OnListItemClickListener clickListener) {
		mContext = context;
		mDatas = datas;
		mIsShowDetailed = isShowDetailed;
		mClickListener = clickListener;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		Holder holder;

		if (convertView == null) {

			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_for_scheduling_setting, null);
			holder = new Holder();
			holder.image = (ImageView) convertView.findViewById(R.id.list_item_for_scheduling_img);
			holder.title = (TextView) convertView.findViewById(R.id.list_item_for_scheduling_title);
			holder.detailed = (TextView) convertView.findViewById(R.id.list_item_for_scheduling_settings);
			holder.settingSwitch = (Switch) convertView.findViewById(R.id.list_item_for_scheduling_switch);

			holder.detailed.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mClickListener.click(v, position, false);
				}
			});

			holder.settingSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					mClickListener.click(buttonView, position, isChecked);
				}
			});

			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}

		if (!mIsShowDetailed) {
			// ����[��������]��ť
			holder.detailed.setVisibility(View.INVISIBLE);
		}

		holder.image.setBackgroundResource(mDatas.get(position).getImageResource());
		holder.title.setText(mDatas.get(position).getTitleName());
		if (mDatas.get(position).isSettingStatus()) {
			holder.settingSwitch.setChecked(true);
		} else {
			holder.settingSwitch.setChecked(false);
		}

		return convertView;
	}

	private class Holder {
		private ImageView image;
		private TextView title;
		private TextView detailed;
		private Switch settingSwitch;
	}

	public void selectAll() {

		for (int i = 0; i < mDatas.size(); i++) {
			mDatas.get(i).setSettingStatus(true);
		}

		notifyDataSetChanged();

	}

	public void cancelAll() {

		for (int i = 0; i < mDatas.size(); i++) {
			mDatas.get(i).setSettingStatus(false);
		}

		notifyDataSetChanged();
	}

}
