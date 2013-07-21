package hs.mirim;

import android.content.Context;

import com.orm.SugarRecord;

public class Alarm extends SugarRecord<Alarm>{
	private int hour;
	private int minute;
	public Alarm(Context context){
		super(context);

	}
	
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setContent(String h,String m) {
		this.hour = Integer.parseInt(h);
		this.minute = Integer.parseInt(m);
	}
	
}
