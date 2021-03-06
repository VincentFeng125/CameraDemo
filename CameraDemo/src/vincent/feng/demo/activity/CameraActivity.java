package vincent.feng.demo.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vincent.feng.demo.R;
import vincent.feng.demo.adapter.GridAdapter;
import vincent.feng.demo.constdef.DemoConstDef;
import vincent.feng.demo.custom.DragImageView;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class CameraActivity extends Activity {

	private String mImgPath = Environment.getExternalStorageDirectory().getPath() + "/testImg.jpg";

	private Button mBtnTransferCamera, mBtnFinishedOrder;

	private List<Bitmap> mBitmapList;

	// private LinearLayout mBaseLayout;

	private GridView mGridView;

	private List<Map<String , Object>> mGridViewDatas;

	/**
	 * 用于保存照片
	 */
	private File fileToPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);

		Log.i(DemoConstDef.TAG, "onCreate()");

		fileToPhoto = new File(mImgPath);
		if (!fileToPhoto.exists()) {
			File _dirPath = fileToPhoto.getParentFile();
			_dirPath.mkdirs();
		}

		mBitmapList = new ArrayList<Bitmap>();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.i(DemoConstDef.TAG, "onConfigurationChanged()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(DemoConstDef.TAG, "onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.i(DemoConstDef.TAG, "onResume()");

		mGridViewDatas = new ArrayList<Map<String , Object>>();

		mBtnTransferCamera = (Button) findViewById(R.id.btn_transfer_system_camera);

		mBtnFinishedOrder = (Button) findViewById(R.id.btn_finished_order);

		mGridView = (GridView) findViewById(R.id.photoGridview);

		mBtnTransferCamera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				openCamera();
			}
		});

		mBtnFinishedOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// ScrollView scrollView = new ScrollView(getBaseContext());

				// int bitmapsCount = bitmapList.size();
				//
				// for (int i = 0; bitmapsCount > 0 && i < bitmapsCount; i++) {
				//
				// ImageView imageView = new ImageView(getBaseContext());
				//
				// imageView.setImageBitmap(bitmapList.get(i));
				//
				// imageView.setLayoutParams(new
				// LayoutParams(LayoutParams.WRAP_CONTENT,
				// LayoutParams.WRAP_CONTENT));
				//
				// baseLayout.addView(imageView, new
				// LayoutParams(LayoutParams.MATCH_PARENT,
				// LayoutParams.MATCH_PARENT));
				// }

				Log.i(DemoConstDef.TAG, "bitmap list size:" + mBitmapList.size());

			}
		});

		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getBaseContext(), "position:" + position, Toast.LENGTH_SHORT).show();
				Dialog _dialog = new Dialog(CameraActivity.this, android.R.style.Theme_Black_NoTitleBar);
				_dialog.setContentView(R.layout.photo_review_dialog);
				DragImageView _imgView = (DragImageView) _dialog.findViewById(R.id.gridView_image);
				_imgView.setImageBitmap((Bitmap) mGridViewDatas.get(position).get("photo"));
				_dialog.show();
			}
		});

		refreshImageBuffer();
	}

	/**
	 * @method openCamera
	 * 
	 * @param
	 * @return void
	 * @throws
	 * @date 2015年1月16日 下午3:12:16
	 */
	protected void openCamera() {
		startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 0);
	}

	private void refreshImageBuffer() {
		mGridViewDatas.clear();
		for (int i = 0; i < mBitmapList.size(); i++) {
			HashMap<String , Object> map = new HashMap<String , Object>();
			map.put("photo", mBitmapList.get(i));
			mGridViewDatas.add(map);
		}
		mGridView.setAdapter(new GridAdapter(this, mGridViewDatas, R.layout.gridview_item, new String[] { "photo" }, new int[] { R.id.gridView_image }));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// try {
		// imgShowPhoto.setImageBitmap(MediaStore.Images.Media.getBitmap(
		// getContentResolver(), Uri.fromFile(new File(imgPath))));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		if (resultCode == RESULT_OK) {

			// get result data
			Bitmap bmp = (Bitmap) data.getExtras().get("data");

			Log.d(DemoConstDef.TAG, "bmp width:" + bmp.getWidth() + ", height:" + bmp.getHeight());

			// add bmp to list
			mBitmapList.add(bmp);
			refreshImageBuffer();

			// // create ImageView
			// ImageView imageView = new ImageView(getBaseContext());
			// imageView.setImageBitmap(bmp);
			// imageView.setLayoutParams(new
			// LayoutParams(LayoutParams.WRAP_CONTENT,
			// LayoutParams.WRAP_CONTENT));
			//
			// // add ImageView to parent view
			// mBaseLayout.addView(imageView, new
			// LayoutParams(LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT));

		}
		super.onActivityResult(requestCode, resultCode, data);

	}

}
