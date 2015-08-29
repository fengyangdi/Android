package com.ggm.threelevelmenu;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimationUtil {

	public static void setAnimationOut(RelativeLayout view, long duration) {
		RotateAnimation ra = new RotateAnimation(0, 180,
				Animation.RELATIVE_TO_SELF,0.5f,
				Animation.RELATIVE_TO_SELF,1f);
		ra.setDuration(duration);
		ra.setFillAfter(true);
		view.startAnimation(ra);
	}

	public static void setAnimationIn(RelativeLayout view, long duration) {
		RotateAnimation ra = new RotateAnimation(180, 360,
				Animation.RELATIVE_TO_SELF,0.5f,
				Animation.RELATIVE_TO_SELF,1f);
		ra.setDuration(duration);
		ra.setFillAfter(true);
		view.startAnimation(ra);
	}

}
