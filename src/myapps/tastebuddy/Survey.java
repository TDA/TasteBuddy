package myapps.tastebuddy;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Survey")
public class Survey extends ParseObject {

	private int rating,valReco,quality,cleanliness,speed,friendliness;
	private String name,email,mobile;
	
	public Survey(){
		
	}
	
	public Survey(int rating,int valReco,int quality,int cleanliness,int speed,int friendliness,String name,String email,String mobile){
		this.rating=rating;
		this.valReco=valReco;
		this.quality=quality;
		this.cleanliness=cleanliness;
		this.speed=speed;
		this.friendliness=friendliness;
		this.name=name;
		this.email=email;
		this.mobile=mobile;
	}
	
	public int getRating(){
		return getInt("rating");
	}
	
	public void setRating(int rating){
		//this.rating=rating;
		put("rating",rating);
	}
	
	public int getValReco(){
		//return this.valReco;
		return getInt("valReco");
	}
	
	public void setValReco(int reco){
		//this.valReco=reco;
		put("valReco",valReco);
	}
	public int getQuality(){
		//return this.quality;
		return getInt("quality");
	}
	
	public void setQuality(int quality){
		//this.quality=quality;
		put("quality",quality);
	}
	public int getCleanliness(){
		//return this.cleanliness;
		return getInt("cleanliness");
	}
	
	public void setCleanliness(int clean){
		//this.cleanliness=clean;
		put("cleanliness",cleanliness);
	}
	public int getSpeed(){
		//return this.speed;
		return getInt("speed");
	}
	
	public void setSpeed(int speed){
		//this.speed=speed;
		put("speed",speed);
	}
	public int getFriendliness(){
		//return this.friendliness;
		return getInt("friendliness");
	}
	
	public void setFriendliness(int friend){
		//this.friendliness=friend;
		put("friendliness",friendliness);
	}
	public String getName(){
		//return this.name;
		return getString("name");
	}
	
	public void setName(String name){
		//this.name=name;
		put("name",name);
	}
	public String getEmail(){
		//return this.email;
		return getString("email");
	}
	
	public void setEmail(String email){
		//this.email=email;
		put("email",email);
	}
	public String getMobile(){
		//return this.mobile;
		return getString("mobile");
	}
	
	public void setMobile(String mobile){
		//this.mobile=mobile;
		put("mobile",mobile);
	}

}
