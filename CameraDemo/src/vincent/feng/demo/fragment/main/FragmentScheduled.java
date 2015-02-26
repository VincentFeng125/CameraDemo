/**
 * FragmentScheduled.java
 * vincent.feng.demo.fragment
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��2��2�� 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.fragment.main;

import java.util.ArrayList;
import java.util.List;

import vincent.feng.demo.R;
import vincent.feng.demo.adapter.ScheduledListViewAdapter;
import vincent.feng.demo.base.BaseFragment;
import vincent.feng.demo.entity.ScheduledEntity;
import android.widget.ListView;

/**
 * ClassName:FragmentScheduled Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015��2��2�� ����11:23:09
 */
public class FragmentScheduled extends BaseFragment {

	private ListView mListView;
	private List<ScheduledEntity> datas;

	@Override
	protected int layoutResource() {
		return R.layout.activity_scheduled;
	}

	@Override
	protected void initialControl() {
		mListView = (ListView) mView.findViewById(R.id.listView_scheduled);
	}

	@Override
	protected void setListener() {
	}

	@Override
	protected void logic() {
		datas = new ArrayList<ScheduledEntity>();
		for (int i = 0; i < 30; i++) {
			datas.add(new ScheduledEntity("�����Լ�", "���� ���� 6:00", "����ͳ��Ʊ�ײ���ˣ�����ǵ�һ��Ҫ���ޡ���Ҫ�����ˣ�"));
		}
		mListView.setAdapter(new ScheduledListViewAdapter(getActivity().getBaseContext(), datas));

	}

}
