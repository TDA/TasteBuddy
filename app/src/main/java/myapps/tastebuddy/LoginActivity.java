package myapps.tastebuddy;



import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.interceptors.ParseLogInterceptor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	Button login;
	EditText uname,pswd;

	Bundle posts;
	ParseObject s;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		System.out.println("Login Activity");
		Parse.initialize(new Parse.Configuration.Builder(getBaseContext())
				.applicationId("SAI_TEST")
				.clientKey("")
				.server("http://10.0.2.2:1337/parse/")
				.build()
		);
		ParseObject survey = new ParseObject("Survey");
		survey.put("name", "spc");
		survey.put("mail", "s@s");
		survey.put("mobile", "35453");
		survey.saveInBackground();
		System.out.println(survey);
	}
	
	public void login(View view){
		
		final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btnscale);
	    
	    
		uname=(EditText)findViewById(R.id.username);
		pswd=(EditText)findViewById(R.id.password);
		login=(Button)findViewById(R.id.loginbutton);
		
		login.startAnimation(myAnim);
		
		String username=uname.getText().toString();
		String password=pswd.getText().toString();
		
		if(username.equals("m")&&password.equals("m")){
			
			
			Toast.makeText(getApplicationContext(), "Manager Login", Toast.LENGTH_SHORT).show();
			ParseQuery<ParseObject> query = ParseQuery.getQuery("GameScore");
			
		    query.findInBackground(new FindCallback<ParseObject>(){

		        @Override
		        public void done(List<ParseObject> postList, ParseException e) {
		            if (e == null) {
		                
						// If there are results, update the list of posts
		                // and notify the adapter
		            	for(ParseObject post:postList){
		            		Survey test=(Survey)post;
		                //Survey test=new Survey(post.getRating(),post.getValReco(),post.getQuality(),post.getCleanliness(),post.getSpeed(),post.getFriendliness(),post.getName(),post.getEmail(),post.getMobile());		                
		                Toast.makeText(getApplicationContext(), test.getName(), Toast.LENGTH_SHORT).show();
		                System.out.println(test.getName());
		                }
		            }
		                //((ArrayAdapter<Note>) getListAdapter()).notifyDataSetChanged();
		            else {
		                Log.d(getClass().getSimpleName(), "Error: " + e.getMessage());
		            }
		            }
		    });
		    
		}
		else{
			if(username.equals("e")&&password.equals("e")){
				setContentView(R.layout.surveypage1);
			}
			else{
				Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	public void launchSurveyPage2(View view){
		
		final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.btnscale);
		
		Button b=(Button)findViewById(R.id.startsurvey);
		b.startAnimation(myAnim);
		Intent intent = new Intent(getApplicationContext(), SurveyPageActivity.class);
        startActivityForResult(intent,100);
	}
}
