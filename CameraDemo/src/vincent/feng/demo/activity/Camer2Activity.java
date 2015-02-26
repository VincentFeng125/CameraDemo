package vincent.feng.demo.activity;

import java.io.IOException;

import vincent.feng.demo.R;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class Camer2Activity extends Activity implements SurfaceHolder.Callback, OnClickListener {

	private SurfaceView mSurfaceView;

	private Button mBtnShutter;

	private SurfaceHolder mSurfaceHolder;

	private android.hardware.Camera mCamera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_camer2);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onResume() {
		super.onResume();

		mSurfaceView = (SurfaceView) findViewById(R.id.surface);

		mSurfaceHolder = mSurfaceView.getHolder();

		mSurfaceHolder.addCallback(this);

		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

		mBtnShutter = (Button) findViewById(R.id.btn_shutter);

		mBtnShutter.setOnClickListener(this);

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mCamera = Camera.open();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// Camera.Parameters parameters = mCamera.getParameters();
		// parameters.setPreviewSize(width, height);
		// mCamera.setParameters(parameters);
		try {
			mCamera.setPreviewDisplay(holder);
		} catch (IOException e) {
			mCamera.release();
		}
		mCamera.startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		mCamera.release();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_shutter:

			break;

		default:
			break;
		}
	}
}
