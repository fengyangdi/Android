package com.ggm.threelevelmenu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private RelativeLayout rl_first_level;
	private RelativeLayout rl_second_level;
	private RelativeLayout rl_third_level;
	private ImageView iv_icon_home;
	private ImageView iv_icon_menu;

	private boolean isFirstLevelShow = true;
	private boolean isSecondLevelShow = true;
	private boolean isThirdLevelShow = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rl_first_level = (RelativeLayout) findViewById(R.id.rl_first_level);
		rl_second_level = (RelativeLayout) findViewById(R.id.rl_second_level);
		rl_third_level = (RelativeLayout) findViewById(R.id.rl_third_level);

		iv_icon_home = (ImageView) findViewById(R.id.iv_icon_home);
		iv_icon_menu = (ImageView) findViewById(R.id.iv_icon_menu);

		/*AnimationUtil.setAnimationOut(rl_first_level, 10);
		AnimationUtil.setAnimationOut(rl_second_level, 10);
		AnimationUtil.setAnimationOut(rl_third_level, 10);
		isFirstLevelShow = false;
		isSecondLevelShow = false;
		isThirdLevelShow = false;*/

		iv_icon_home.setOnClickListener(this);
		iv_icon_menu.setOnClickListener(this);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			if (isFirstLevelShow) {
				AnimationUtil.setAnimationOut(rl_first_level, 200);
			} else {
				AnimationUtil.setAnimationIn(rl_first_level, 200);
			}
			if (isSecondLevelShow) {
				AnimationUtil.setAnimationOut(rl_second_level, 500);
				isSecondLevelShow = !isSecondLevelShow;
			} 
			if (isThirdLevelShow) {
				AnimationUtil.setAnimationOut(rl_third_level, 500);
				isThirdLevelShow = !isThirdLevelShow;
			} 
			isFirstLevelShow = !isFirstLevelShow;
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_icon_home:
			if (isSecondLevelShow) {
				AnimationUtil.setAnimationOut(rl_second_level, 500);
			} else {
				AnimationUtil.setAnimationIn(rl_second_level, 500);
			}
			if (isThirdLevelShow) {
				AnimationUtil.setAnimationOut(rl_third_level, 500);
				isThirdLevelShow = !isThirdLevelShow;
			} 
			isSecondLevelShow = !isSecondLevelShow;
			break;
		case R.id.iv_icon_menu:
			if (isThirdLevelShow) {
				AnimationUtil.setAnimationOut(rl_third_level, 500);
			} else {
				AnimationUtil.setAnimationIn(rl_third_level, 500);
			}
			isThirdLevelShow = !isThirdLevelShow;
			break;
		default:
			break;
		}

	}
}
