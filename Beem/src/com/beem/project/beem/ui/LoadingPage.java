package com.beem.project.beem.ui;

import com.beem.project.beem.BeemApplication;
import com.beem.project.beem.R;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingPage extends Activity {
	
//	private Drawable image;
	private static final int LOGINUSUAL = 1;
	private static final int LOGINWITHAC = 2;
	
	private ImageView loadingLogo;
	private ProgressBar waitingsBar;
	private TextView loginView;
	
	private String accoutString;
	private AnimatorSet animatorSet;
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){
	      public void handleMessage(Message msg) {   
              switch (msg.what) {   
                   case LoadingPage.LOGINUSUAL:
                   {
                	  animatorSet.cancel();
                	  waitingsBar.clearAnimation();
//                	  loadingLogo.animate().translationY(-100);
                	  Intent intent = new Intent(LoadingPage.this, LoginAccount.class);
                	  startActivityForResult(intent, 0);
                	  
                   }
                        break;   
                   case LoadingPage.LOGINWITHAC:
                   {
                	   Log.i("handle message", "记录了密码");
                	   loginView.setVisibility(View.VISIBLE);
                   }
                   		break;
              }   
              super.handleMessage(msg);   
         }  
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.loading_layer);
    	loadingLogo = (ImageView)this.findViewById(R.id.loading_as_logo);
    	waitingsBar = (ProgressBar)this.findViewById(R.id.progressBar1);
    	loginView = (TextView)this.findViewById(R.id.login_text);
    	
//    	Animation viewAnimation = AnimationUtils.loadAnimation(this, R.anim.loading_animation);
//    	loadingLogo.setAnimation(viewAnimation);
//    	loadingLogo.animate().scaleX(1.2f);
    	animatorSet = new AnimatorSet();
    	ObjectAnimator repeateAnimator1 = ObjectAnimator.ofFloat(loadingLogo, "scaleX",0.8f, 1.0f);
    	repeateAnimator1.setRepeatCount(ValueAnimator.INFINITE);
    	repeateAnimator1.setRepeatMode(ValueAnimator.REVERSE);

//    	repeateAnimator1
    	ObjectAnimator repeateAnimator2 = ObjectAnimator.ofFloat(loadingLogo, "scaleY", 0.8f, 1.0f);
    	repeateAnimator2.setRepeatCount(ValueAnimator.INFINITE);
    	repeateAnimator2.setRepeatMode(ValueAnimator.REVERSE);
    	
//    	animatorSet.play(repeateAnimator1).before(repeateAnimator2);
//    	animatorSet.playSequentially(repeateAnimator1);
    	animatorSet.play(repeateAnimator1).with(repeateAnimator2);
    	animatorSet.setDuration(1000);
    	animatorSet.start();
    	
		  RotateAnimation rotation = new RotateAnimation(
			      0f,
			      360f,
			      Animation.RELATIVE_TO_SELF,
			      0.5f,
			      Animation.RELATIVE_TO_SELF,
			      0.5f);
		  rotation.setDuration(1000);
		  rotation.setInterpolator(new LinearInterpolator());
		  rotation.setRepeatMode(Animation.RESTART);
		  rotation.setRepeatCount(Animation.INFINITE);
		  
		  waitingsBar.startAnimation(rotation);

    }
    
    @Override
    protected void onStart(){
    	super.onStart();
    	Log.i("onstart", "Test");
    	SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    	accoutString = sharedPreferences.getString(BeemApplication.ACCOUNT_USERNAME_KEY, "");
    	new Handler().postDelayed(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				if (accoutString.length()<=0) {
					handler.sendEmptyMessage(LoadingPage.LOGINUSUAL);
				}else {
					handler.sendEmptyMessage(LoadingPage.LOGINWITHAC);
				}
			}
		}, 1500);
    }
    
    @Override
    protected void onPause(){
    	super.onPause();
    	Log.i("onPause", "Test");
    }
    
    @Override 
    protected void onResume(){
    	super.onResume();
    	Log.i("onResume", "Test");
    }
    
    public int[] screenSize(){
    	DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;   // 屏幕高度（像素）
        return new int[]{width, height};
    }
}
