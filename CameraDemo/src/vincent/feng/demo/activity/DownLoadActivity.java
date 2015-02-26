package vincent.feng.demo.activity;

import java.io.File;

import vincent.feng.demo.R;
import vincent.feng.demo.constdef.DemoConstDef;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DownLoadActivity extends Activity {

	// Spinner define
	private Spinner mSpinner;

	// Download contents
	private String[] mUrlContents = new String[] {
			"http://pan.baidu.com/s/1Gr04Y",
			"http://pic002.cnblogs.com/images/2012/384764/2012031413390861.png",
			"http://s.2gei.com/src/aud/wav/ce/ce13b4acbfb1459f82ebc138fb48d61e.wav?download/%E9%9F%B3%E6%95%88-%E9%9F%B3%E6%95%88%E5%BA%93-%E8%B6%B3%E7%90%83_%E4%BA%BA%E7%BE%A4_%E6%AC%A2%E5%91%BC2_%E7%88%B1%E7%BB%99%E7%BD%91_2gei_com.wav&e=1422602160&token=SFUBINIQSdH81jWou5iE8UO8rJsvRRLzvNEWpczI:UJoe0siZYqUxjMi1CQ0C5x7XX5A=" };

	// The current click
	private String mCurrentConent;

	// Download Manager
	private DownloadManager mDownloadManager;

	private long mDownloadID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_down_load);

		// get Download service
		mDownloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSpinner = (Spinner) findViewById(R.id.spinner_download_list);
		mSpinner.setAdapter(new ArrayAdapter<String>(this, R.layout.download_spinner_item, mUrlContents));
		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				mCurrentConent = mUrlContents[position];
				Log.i(DemoConstDef.TAG, "current content is : " + mCurrentConent);
				Log.i(DemoConstDef.TAG, Environment.getExternalStorageDirectory().toString());

				// transform URI
				Uri _uri = Uri.parse(mCurrentConent);
				Request _request = new Request(_uri);
				_request.setDestinationUri(Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/FENGZHE.wav")));
				//
				_request.setTitle("测试下载通知栏");
				_request.setDescription("下载描述");
				_request.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
				mDownloadID = mDownloadManager.enqueue(_request);

				// mDownloadManager.

				IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);

				BroadcastReceiver receiver = new BroadcastReceiver() {

					@Override
					public void onReceive(Context context, Intent intent) {
						long _reference_form_receive = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
						if (mDownloadID == _reference_form_receive) {
							Toast.makeText(DownLoadActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
							unregisterReceiver(this);
						}
					}
				};

				registerReceiver(receiver, filter);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

}
