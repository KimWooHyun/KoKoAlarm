package hs.mirim;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AddAlarm extends Activity implements OnClickListener{
	private List<String> alarms;
	private CustomArrayAdapter c;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addalarm);
        
        alarms=new ArrayList<String>();
        
        ListView listView=(ListView)findViewById(R.id.listView);
        
        c=new CustomArrayAdapter(this, android.R.layout.simple_list_item_1, alarms);
        listView.setAdapter(c);
        
        listView.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View arg1, int position,
        			long arg3) {
        		Log.d("test",alarms.get(position));
        	}
		});
        
        Button btnAdd=(Button)findViewById(R.id.btnAdd);
        
        btnAdd.setOnClickListener(this);
    }
	
	public void onClick(View v) {
		Intent intent=new Intent(AddAlarm.this, SettingAlarm.class);
		startActivityForResult(intent, 123);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode==RESULT_OK){
			String timeStr = data.getExtras().getString("time");
			alarms.add(timeStr);
			c.notifyDataSetChanged();
			
			Toast.makeText(this, "TOAST : " + timeStr, Toast.LENGTH_SHORT).show();
		}
	 }
}
