package hs.mirim;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

public class SettingAlarm extends Activity implements OnClickListener{
	private AlarmManager am;
	private PendingIntent pIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingalarm);

		Button btnOk=(Button)findViewById(R.id.btnOk);
		Button btnCancel=(Button)findViewById(R.id.btnCancel);

		btnOk.setOnClickListener(this);
		btnCancel.setOnClickListener(this);

		am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		Intent intent=new Intent(this, AlarmReceiver.class);
		pIntent=PendingIntent.getBroadcast(this, 0, intent, 0);
	}

	public void onClick(View v) {
		if(v.getId()==R.id.btnOk){
			TimePicker picker=(TimePicker) findViewById(R.id.timePicker);
			int hour=picker.getCurrentHour();//사용자가 선택한 ㅅ;긴
			int minute=picker.getCurrentMinute();//시용자가 선택한 분
			SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//이건 출력용
			String str=format.format(new Date());//현재시간
			new Date().getDay();//현재날짜
			new Date().getHours();//현재시간
			new Date().getMinutes();//현재분
			Toast.makeText(this, hour+"시"+minute+"분"+str, 3000).show();
			// Unix Time : 
			
			Intent intent1=new Intent();
			intent1.putExtra("time", "20:27");
			intent1.putExtra("week", "월,수");
			setResult(RESULT_OK, intent1);

		}

		else if(v.getId()==R.id.btnCancel){
			setResult(RESULT_CANCELED);
		}
		finish();
	}

}
