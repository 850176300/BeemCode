package com.beem.project.beem.ui;

import com.beem.project.beem.R;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoadingPage extends Activity {
	
//	private Drawable image;
	private ImageView loadingLogo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.loading_layer);
    	loadingLogo = (ImageView)this.findViewById(R.id.loading_as_logo);
//    	Animation viewAnimation = AnimationUtils.loadAnimation(this, R.anim.loading_animation);
//    	loadingLogo.setAnimation(viewAnimation);
//    	loadingLogo.animate().scaleX(1.2f);
    	AnimatorSet animatorSet = new AnimatorSet();
    	ObjectAnimator repeateAnimator1 = ObjectAnimator.ofFloat(loadingLogo, "translationY",400.0f, 100.0f);
    	repeateAnimator1.setRepeatCount(ValueAnimator.INFINITE);
    	repeateAnimator1.setRepeatMode(ValueAnimator.REVERSE);

//    	repeateAnimator1
//    	ObjectAnimator repeateAnimator2 = ObjectAnimator.ofFloat(loadingLogo, "translationY",330.0f, 20.0f);
//    	repeateAnimator2.setRepeatCount(ValueAnimator.INFINITE);
//    	repeateAnimator2.setRepeatMode(ValueAnimator.REVERSE);
    	
//    	animatorSet.play(repeateAnimator1).before(repeateAnimator2);
//    	animatorSet.playSequentially(repeateAnimator1);
    	animatorSet.play(repeateAnimator1);//.with(repeateAnimator2);
    	animatorSet.setDuration(1000);
    	animatorSet.start();
    }
}
