package com.beem.project.beem.ui;


import com.beem.project.beem.R;
import com.greenhalolabs.emailautocompletetextview.*;
//import com.greenhalolabs.emailautocompletetextview.EmailAutoCompleteTextView;

import android.R.integer;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.util.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class LoginAccount extends Activity implements View.OnClickListener{
	private RelativeLayout loginLayout;
	private Button loginBtn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.login_liuwei);
    	loginLayout = (RelativeLayout)this.findViewById(R.id.loginInputView);
    	loginBtn = (Button)this.findViewById(R.id.login);
    	ViewGroup loginGroup = (ViewGroup)this.findViewById(R.id.input);
    	EmailAutoCompleteTextView emailAutoCompleteTextView = (EmailAutoCompleteTextView)this.getLayoutInflater().inflate(R.layout.dropdownemail_liuwei, null);
    	emailAutoCompleteTextView.setHint("账号");
    	emailAutoCompleteTextView.setClearButtonEnabled(true); // defaults to true
    	emailAutoCompleteTextView.setClearButtonResId(R.drawable.clearable_button);
    	emailAutoCompleteTextView.setBackgroundColor(getResources().getColor(R.color.login_account));
    	emailAutoCompleteTextView.setHintTextColor(getResources().getColor(R.color.login_hint));
    	emailAutoCompleteTextView.setDropDownBackgroundResource(R.drawable.login_panel_account);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(     
                LinearLayout.LayoutParams.FILL_PARENT,     
                LinearLayout.LayoutParams.WRAP_CONTENT     
        );  
        p.height = 90;
    	emailAutoCompleteTextView.setLayoutParams(p);
    	emailAutoCompleteTextView.setId(R.id.layout_login_account);
    	emailAutoCompleteTextView.setSelectAllOnFocus(false);
    	loginGroup.addView(emailAutoCompleteTextView);
//    	emailAutoCompleteTextView.setDropDownHorizontalOffset(-16);
//    	emailAutoCompleteTextView.setDropDownVerticalOffset(0);
    	emailAutoCompleteTextView.setDropDownHeight(105);
    	

    	
    	
    	View line = new View(this);
        RelativeLayout.LayoutParams linep = new RelativeLayout.LayoutParams(     
                LinearLayout.LayoutParams.FILL_PARENT,     
                LinearLayout.LayoutParams.WRAP_CONTENT     
        );  
        linep.height = 1;
        linep.leftMargin = 1;
        linep.rightMargin = 1;
        linep.addRule(RelativeLayout.BELOW, R.id.layout_login_account);
        line.setLayoutParams(linep);
        line.setBackgroundColor(getResources().getColor(R.color.line_color));
        loginGroup.addView(line);
        line.setId(R.id.layout_login_line);
        
        
        EmailAutoCompleteTextView pwdInput = new EmailAutoCompleteTextView(this);
        pwdInput.setHint("密码");
        pwdInput.setClearButtonEnabled(true);
        pwdInput.setClearButtonResId(R.drawable.clearable_button);
        pwdInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        pwdInput.setAdapter(null);
        
        RelativeLayout.LayoutParams pwdP = new RelativeLayout.LayoutParams(     
                LinearLayout.LayoutParams.FILL_PARENT,     
                LinearLayout.LayoutParams.WRAP_CONTENT     
        );  
        pwdP.height = 90;
//        pwdP.leftMargin = 16;
//        pwdP.rightMargin = 10;
        pwdP.addRule(RelativeLayout.BELOW, R.id.layout_login_line);
        pwdInput.setLayoutParams(pwdP);
        pwdInput.setHintTextColor(getResources().getColor(R.color.login_hint));
        pwdInput.setBackgroundColor(getResources().getColor(R.color.login_password));
        pwdInput.setId(R.id.layout_login_password);
        loginGroup.addView(pwdInput);
        pwdInput.setSelectAllOnFocus(false);
        
        
        
        
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login:
			
			break;

		default:
			break;
		}
	}
	
}
