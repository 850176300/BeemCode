package com.beem.project.beem.ui;


import com.beem.project.beem.R;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.util.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class LoginAccount extends Activity{
	private RelativeLayout loginLayout;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.login_liuwei);
    	loginLayout = (RelativeLayout)this.findViewById(R.id.loginInputView);
//    	loginLayout.animate().alpha(0);
    }
    
    @Override
    protected void onStart(){
    	super.onStart();
//    	ObjectAnimator alphAnimator = ObjectAnimator.ofFloat(loginLayout, "alpha", 0.0f, 1.0f);
//    	alphAnimator.setRepeatCount(1);
//    	ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(loginLayout, "translationYBy", -100.0f);
//    	translateAnimator.setRepeatCount(1);
//    	AnimatorSet animatorSet = new AnimatorSet();
//    	animatorSet.setDuration(1500);
//    	animatorSet.play(alphAnimator).with(translateAnimator);
    	Animation animation = AnimationUtils.loadAnimation(this, R.anim.login_in);
    	loginLayout.setAnimation(animation);
    }
//    public int[] screenSize(){
//    	DisplayMetrics metric = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        int width = metric.widthPixels;     // 屏幕宽度（像素）
//        int height = metric.heightPixels;   // 屏幕高度（像素）
//        return new int[]{width, height};
//    }
	
}
