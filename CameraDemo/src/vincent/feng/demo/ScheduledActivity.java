package vincent.feng.demo;

import java.util.ArrayList;
import java.util.List;

import vincent.feng.demo.adapter.ScheduledListViewAdapter;
import vincent.feng.demo.base.BaseActivity;
import vincent.feng.demo.entity.ScheduledEntity;
import android.widget.ListView;

public class ScheduledActivity extends BaseActivity {

	private ListView mListView;

	private List<ScheduledEntity> datas;

	private void testDatas() {
		datas = new ArrayList<ScheduledEntity>();
		for (int i = 0; i < 30; i++) {
			datas.add(new ScheduledEntity("�����Լ�", "���� ���� 6:00", "����ͳ��Ʊ�ײ���ˣ�����ǵ�һ��Ҫ���ޡ���Ҫ�����ˣ�"));
		}
	}

	@Override
	protected void init() {
		mListView = (ListView) findViewById(R.id.listView_scheduled);
	}

	@Override
	protected void setListener() {
	}

	@Override
	protected int layoutResource() {
		return R.layout.activity_scheduled;
	}

	@Override
	protected void logic() {
		testDatas();
		mListView.setAdapter(new ScheduledListViewAdapter(this, datas));
	}

}
