/**
 * GridAdapter.java
 * vincent.feng.demo.adapter
 *
 * Function�� �Զ���Adapterֱ�ӽ�Bitmap������Ϊ����Դ 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   1.0  2015��1��29�� 		FengZhe
 *
 * Copyright (c) 2015, Shanghai Vincent Information Technology Co., Ltd. All Rights Reserved.
 */

package vincent.feng.demo.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;

/**
 * ClassName:GridAdapter
 *
 * @author FengZhe
 * @version 1.0
 * @Date 2015��1��29�� ����11:01:26
 */
public class GridAdapter extends SimpleAdapter implements ViewBinder {

	public GridAdapter(Context context, List<? extends Map<String , ?>> data, int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
		setViewBinder(this);
	}

	@Override
	public boolean setViewValue(View view, Object data, String textRepresentation) {

		if (view instanceof ImageView) {
			if (data instanceof Bitmap) {
				((ImageView) view).setImageBitmap((Bitmap) data);
				return true;
			}
		}
		return false;

	}

}
