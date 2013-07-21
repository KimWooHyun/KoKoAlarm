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
	final static String TAG = "����:CustomArryayAdapter";
	
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
		Log.e(TAG, "�˶� id��" + alarm.getId() );
	
		Button btnDelete = (Button)view.findViewById(R.id.btnDelete);
		btnDelete.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {
			if(alarm != null){
			Log.e(TAG, "������� �ϴ� �˶� id��" + alarm.getId() );
				
			alarm.delete();
			((AddAlarm) getContext()).deleteItem(alarm);
			}else{
				Log.e(TAG, "���� �˶� ��ü�� �����ϴ�.");
			}
		}
	});

	return view;
	}
}
