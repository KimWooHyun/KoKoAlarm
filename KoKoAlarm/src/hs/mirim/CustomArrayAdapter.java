package hs.mirim;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CustomArrayAdapter extends ArrayAdapter<String>{
	public CustomArrayAdapter(Context listSampleActivity,
			int listRow, List<String> items) {
		super(listSampleActivity, listRow, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
		if(view==null){
			LayoutInflater inflater=((Activity)getContext()).getLayoutInflater();
			view=inflater.inflate(R.layout.settingalarm2, null);
		}
		
		return view;
	}
}
