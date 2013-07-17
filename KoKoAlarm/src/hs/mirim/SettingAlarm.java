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
			int hour=picker.getCurrentHour();//����ڰ� ������ ��;��
			int minute=picker.getCurrentMinute();//�ÿ��ڰ� ������ ��
			SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");//�̰� ��¿�
			String str=format.format(new Date());//����ð�
			new Date().getDay();//���糯¥
			new Date().getHours();//����ð�
			new Date().getMinutes();//�����
			Toast.makeText(this, hour+"��"+minute+"��"+str, 3000).show();
			// Unix Time : 
			
			Intent intent1=new Intent();
			intent1.putExtra("time", "20:27");
			intent1.putExtra("week", "��,��");
			setResult(RESULT_OK, intent1);

		}

		else if(v.getId()==R.id.btnCancel){
			setResult(RESULT_CANCELED);
		}
		finish();
	}

}
