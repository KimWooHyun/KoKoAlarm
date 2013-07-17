package hs.mirim;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AddAlarm extends Activity implements OnClickListener{
	private List<Alarm> alarms;
	private CustomArrayAdapter c;
	Alarm newAlarm;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addalarm);

		alarms=Alarm.listAll(Alarm.class);        
		ListView listView=(ListView)findViewById(R.id.listView1);

		c=new CustomArrayAdapter(this, android.R.layout.simple_list_item_1, alarms);
		listView.setAdapter(c);
		listView.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(AddAlarm.this, "aaaa", 3000).show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long arg3) {
				Toast.makeText(AddAlarm.this, "abbbaaa", 3000).show();
			}
		});

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
			String timeStr = data.getExtras().getString("time");
			Alarm am = new Alarm(this);
			am.setContent(timeStr);

			newAlarm=new Alarm(this);
			newAlarm.save();

			alarms.add(am);
			c.notifyDataSetChanged();

			Toast.makeText(this, "TOAST : " + timeStr, Toast.LENGTH_SHORT).show();
		}
	}

	public void deleteItem(Alarm am) {
		alarms.remove(am);
		c.notifyDataSetChanged();

	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(Menu.NONE, 1, Menu.NONE, "ªË¡¶");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if(item.getItemId()==1)
			newAlarm.delete();
		return false;
	}

}