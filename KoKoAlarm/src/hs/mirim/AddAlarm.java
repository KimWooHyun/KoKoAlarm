package hs.mirim;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AddAlarm extends Activity implements OnClickListener{
	private List<Alarm> alarms;
	private CustomArrayAdapter c;
	
	TextView Text1;
	
	Alarm newAlarm;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addalarm);

		Text1=(TextView)findViewById(R.id.Text1);
		
		alarms=Alarm.listAll(Alarm.class);        
		ListView listView=(ListView)findViewById(R.id.listView1);

		c=new CustomArrayAdapter(this, android.R.layout.simple_list_item_1, alarms);
		listView.setAdapter(c);

		Button btnAdd=(Button)findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);

	}

	public void onClick(View v) {
		Intent intent=new Intent(this, SettingAlarm.class);
		startActivityForResult(intent, 123);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode==RESULT_OK){
			Alarm am = new Alarm(this);
			
			am.setContent(data.getExtras().getString("hour"),(data.getExtras().getString("minute")));
	        am.save();
	        
			alarms.add(am);
			c.notifyDataSetChanged();
			
		}
	}

	public void deleteItem(Alarm am) {
		alarms.remove(am);
		c.notifyDataSetChanged();
	}
}