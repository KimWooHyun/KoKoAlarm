package hs.mirim;

import android.content.Context;

import com.orm.SugarRecord;

public class Alarm extends SugarRecord<Alarm>{
	private String time;
	
	public Alarm(Context context){
		super(context);

	}
	
	public String getContent() {
		return time;
	}
	public void setContent(String content) {
		this.time = content;
	}
	
}
