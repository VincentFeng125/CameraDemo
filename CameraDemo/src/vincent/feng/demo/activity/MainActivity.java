package vincent.feng.demo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vincent.feng.demo.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static final String CATEGORY_NAME = "vincent.feng.demo.category.item";

	private ListView listview;

	private List<HashMap<String , String>> projectItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		projectItems = new ArrayList<HashMap<String , String>>();

		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(CATEGORY_NAME);
		PackageManager pm = getPackageManager();

		List<ResolveInfo> queryResult = pm.queryIntentActivities(intent, 0);

		for (int count = 0; count < queryResult.size(); count++) {

			HashMap<String , String> map = new HashMap<String , String>();

			ResolveInfo ri = queryResult.get(count);

			Log.e("TAG name=", ri.activityInfo.name);
			Log.e("TAG packageName=", ri.activityInfo.packageName);

			map.put("name", ri.activityInfo.name);
			map.put("packagename", ri.loadLabel(pm).toString());
			projectItems.add(map);
		}

	}

	class ProjectListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return projectItems.size();
		}

		@Override
		public Object getItem(int position) {
			return projectItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View view = LayoutInflater.from(getBaseContext()).inflate(android.R.layout.simple_list_item_1, null);
			TextView tv = (TextView) view.findViewById(android.R.id.text1);
			tv.setText(projectItems.get(position).get("packagename"));

			return view;
		}

	}

	@Override
	protected void onResume() {
		super.onResume();

		listview = (ListView) findViewById(R.id.project_listview);
		listview.setAdapter(new ProjectListAdapter());

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent();
				intent.setClassName(MainActivity.this, projectItems.get(position).get("name"));
				startActivity(intent);
			}
		});
	}

}
