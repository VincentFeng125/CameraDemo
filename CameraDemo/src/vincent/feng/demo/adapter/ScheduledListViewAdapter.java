/**
 * ScheduledListViewAdapter.java
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

import vincent.feng.demo.R;
import vincent.feng.demo.entity.ScheduledEntity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ClassName:ScheduledListViewAdapter Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年1月30日 下午4:42:27
 */
public class ScheduledListViewAdapter extends BaseAdapter {

	class Holder {
		ImageView imageView;
		TextView tvTitle, tvDate, tvContent;
		Button btnLevel;
	}

	private List<ScheduledEntity> mDatas;

	private Context mContext;

	public ScheduledListViewAdapter(Context context, List<ScheduledEntity> data) {
		mContext = context;
		mDatas = data;
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
		Holder mHolder;
		if (convertView == null) {
			mHolder = new Holder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_for_scheduled, null);
			mHolder.imageView = (ImageView) convertView.findViewById(R.id.list_item_for_scheduled_check_self_time_pointer_img);
			mHolder.tvTitle = (TextView) convertView.findViewById(R.id.list_item_for_scheduled_check_self_title_tv);
			mHolder.tvDate = (TextView) convertView.findViewById(R.id.list_item_for_scheduled_check_self_date_tv);
			mHolder.tvContent = (TextView) convertView.findViewById(R.id.list_item_for_scheduled_check_self_content_tv);
			mHolder.btnLevel = (Button) convertView.findViewById(R.id.list_item_for_scheduled_check_self_level_btn);
			convertView.setTag(mHolder);
		} else {
			mHolder = (Holder) convertView.getTag();
		}
		mHolder.btnLevel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "onclick=" + position, Toast.LENGTH_SHORT).show();
			}
		});
		mHolder.tvTitle.setText(mDatas.get(position).getTitle());
		mHolder.tvDate.setText(mDatas.get(position).getDate());
		mHolder.tvContent.setText(mDatas.get(position).getContent());

		return convertView;
	}

}
