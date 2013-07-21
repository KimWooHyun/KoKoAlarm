package hs.mirim;

import java.util.List;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class CustomArrayAdapter extends ArrayAdapter<Alarm>{
	final static String TAG = "꼬꼬:CustomArryayAdapter";
	
	Alarm alarm;
	public CustomArrayAdapter(Context listSampleActivity,
			int listRow, List<Alarm> items) {
		super(listSampleActivity, listRow, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
		if(view==null){
			LayoutInflater inflater=((Activity)getContext()).getLayoutInflater();
			view=inflater.inflate(R.layout.settingalarm2, null);
		}
	
		alarm=getItem(position);
		Log.e(TAG, "알람 id는" + alarm.getId() );
	
		Button btnDelete = (Button)view.findViewById(R.id.btnDelete);
		btnDelete.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {
			if(alarm != null){
			Log.e(TAG, "지우려고 하는 알람 id는" + alarm.getId() );
				
			alarm.delete();
			((AddAlarm) getContext()).deleteItem(alarm);
			}else{
				Log.e(TAG, "지울 알람 객체가 없습니다.");
			}
		}
	});

	return view;
	}
}
