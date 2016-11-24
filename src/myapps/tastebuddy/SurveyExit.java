package myapps.tastebuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class SurveyExit extends Activity{

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.surveypage3);
		
	}
	
	public void exitSurvey(View view){
		final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btnscale);
		
		Button b=(Button)findViewById(R.id.finishsurvey);
		b.startAnimation(myAnim);
		
		Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent,100);
		//finish();
	}
	
}
