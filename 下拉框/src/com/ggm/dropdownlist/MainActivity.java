package com.ggm.dropdownlist;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity<MyAdapter> extends ActionBarActivity {

	private EditText et_ddl_info;
	private ImageView iv_showList;
	private PopupWindow pw;
	
	List<String> list;
	
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_ddl_info = (EditText) findViewById(R.id.et_ddl_info);
		iv_showList = (ImageView) findViewById(R.id.iv_showlist);
		
		list = new ArrayList<String>();
		
		for (int i = 0; i < 15; i++) {
			list.add("10000000"+i);
		}
		initListView();
	}

	private void initListView() {
		listView = new ListView(this);
		listView.setBackgroundResource(R.drawable.listview_background);
		listView.setDivider(null); //设置分割线
		listView.setVerticalScrollBarEnabled(false);
		MyAdapter ma = new MyAdapter();
		listView.setAdapter(ma);
	}

	public void showList(View view) {
		pw = new PopupWindow(this);
		pw.setWidth(et_ddl_info.getWidth());
		pw.setHeight(300);
		pw.setContentView(listView);
		pw.setOutsideTouchable(true); //允许在PopupWindow外触摸
		pw.showAsDropDown(et_ddl_info, 0, 0);
	}
	
	private class MyAdapter extends BaseAdapter{

		private ViewHolder holder;

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View view = null;
			if (convertView == null) {
				view = View.inflate(getApplicationContext(), R.layout.dropdowmlist_item, null);
				holder = new ViewHolder();
				holder.tv_info = (TextView) view.findViewById(R.id.tv_info);
				holder.iv_delete = (ImageView) view.findViewById(R.id.iv_delete);
				view.setTag(holder);
			}
			else {
				view = convertView;
				holder = (ViewHolder) view.getTag();
			}
			holder.tv_info.setText(list.get(position));
			holder.iv_delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					list.remove(position);
					MyAdapter.this.notifyDataSetChanged();
				}
			});
			view.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					et_ddl_info.setText(list.get(position));
					pw.dismiss();
				}
			});
			return view;
		}
		
	}
	
	private class ViewHolder{
		TextView tv_info;
		ImageView iv_delete;
	}
	
}
