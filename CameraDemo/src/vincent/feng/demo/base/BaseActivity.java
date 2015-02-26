/**
 * BaseActivity.java
 * vincent.feng.demo.base
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年2月2日 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Changxing Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.base;

import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.view.Window;

/**
 * ClassName:BaseActivity Function: TODO ADD FUNCTION
 *
 * @author FengZhe
 * @version
 * @Date 2015年2月2日 下午3:51:52
 */
public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUI(UiTheme(), layoutResource());
	}

	private void setUI(int theme, int layoutID) {
		if (theme == 0) {
			throw new NotFoundException("未找到主题资源！");
		}
		if (layoutID == 0) {
			throw new NotFoundException("未找到布局资源！");
		}
		requestWindowFeature(theme);
		setContentView(layoutID);
	}

	protected int UiTheme() {
		return Window.FEATURE_NO_TITLE;
	}

	@Override
	protected void onResume() {
		super.onResume();

		init();
		setListener();
		logic();
	}

	abstract protected int layoutResource();

	/**
	 * 
	 * @method init 初始化Layout中控件
	 * @param
	 * @return void
	 * @throws
	 * @date 2015年2月2日 下午4:04:29
	 */
	abstract protected void init();

	/**
	 * 
	 * @method setListener 为控件设置监听事件
	 * @param
	 * @return void
	 * @throws
	 * @date 2015年2月2日 下午4:04:33
	 */
	abstract protected void setListener();

	/**
	 * 
	 * @method logic 其他逻辑
	 * @param
	 * @return void
	 * @throws
	 * @date 2015年2月2日 下午5:04:13
	 */
	abstract protected void logic();
}
