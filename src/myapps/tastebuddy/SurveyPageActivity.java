package myapps.tastebuddy;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SurveyPageActivity extends Activity {
	
	ParseObject s;
	//ParseObject testObject=ParseObject.create("Survey");
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.surveypage2);
		ParseObject.registerSubclass(Survey.class);
		//Parse.initialize(this, "sample", "sample123");
		
		Parse.initialize(new Parse.Configuration.Builder(getBaseContext())
	    .applicationId("sample")
	    .server("http://192.168.1.105:1337/parse")
	 
	    
	 
	    .build()
	);

		s=ParseObject.create("Survey");
	}
	
	public void saveSelection(View view){
		RadioButton rad=(RadioButton)findViewById(view.getId());
		
		boolean checked=((RadioButton)view).isChecked();
		int selView=view.getId();
		String sel=getResources().getResourceEntryName(selView); //getting name of the element
		char c=sel.charAt(0);
		int val;
		RadioGroup rbg;
		
		switch(c){
		case 'r':
			if(checked){
			val=Integer.parseInt(sel.substring(1)); //getting selected value
			s.put("rating",val);
			rbg=(RadioGroup)findViewById(R.id.rating);
			for(int i=0;i<val;i++){
				rbg.getChildAt(i).setBackgroundResource(R.drawable.goldenstar);
			}
			break;
			}
		case 'v':
			if(checked){
			val=Integer.parseInt(sel.substring(1)); //getting selected value
			s.put("valReco",val);
			rbg=(RadioGroup)findViewById(R.id.valreco);
			
			for(int i=0;i<10;i++){
				//rbg.getChildAt(i).set
			}
			view.setEnabled(true);
			
			break;
			}
		case 'q':
			if(checked){
			val=Integer.parseInt(sel.substring(1)); //getting selected value
			//s.setQuality(val);
			s.put("quality",val);
			
			rbg=(RadioGroup)findViewById(R.id.quality);
			
			for(int i=0;i<10;i++){
				rbg.getChildAt(i).setEnabled(false);
			}
			view.setEnabled(true);
			
			break;
			}
		case 'c':
			if(checked){
			val=Integer.parseInt(sel.substring(1)); //getting selected value
			s.put("cleanliness",val);
			
			rbg=(RadioGroup)findViewById(R.id.cleanliness);
			
			for(int i=0;i<10;i++){
				rbg.getChildAt(i).setEnabled(false);
			}
			view.setEnabled(true);
			
			break;
			}
		case 's':
			if(checked){
			val=Integer.parseInt(sel.substring(1)); //getting selected value
			s.put("speed",val);
			rbg=(RadioGroup)findViewById(R.id.speed);
			
			for(int i=0;i<10;i++){
				rbg.getChildAt(i).setEnabled(false);
			}
			view.setEnabled(true);
			
			break;
			}
		case 'f':
			if(checked){
			val=Integer.parseInt(sel.substring(1)); //getting selected value
			s.put("friendliness",val);
			rbg=(RadioGroup)findViewById(R.id.friendliness);
			
			for(int i=0;i<10;i++){
				rbg.getChildAt(i).setEnabled(false);
			}
			view.setEnabled(true);
						
			break;
			}
			
		}
	}
	
	public void submitSurvey(View view){
		
		final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btnscale);
		Button b=(Button)findViewById(R.id.submit);
		
		b.startAnimation(myAnim);
		
		EditText name=(EditText)findViewById(R.id.name);
		String nameval=name.getText().toString();
		EditText mail=(EditText)findViewById(R.id.mail);
		String email=mail.getText().toString();
		EditText mobile=(EditText)findViewById(R.id.mobile);
		String mobileval=mobile.getText().toString();
		
		s.put("name",nameval);
		s.put("mail", email);
		s.put("mobile",mobileval);
		
		s.saveInBackground();
		
		Intent intent = new Intent(getApplicationContext(), SurveyExit.class);
        startActivityForResult(intent,100);
		
	}
}
