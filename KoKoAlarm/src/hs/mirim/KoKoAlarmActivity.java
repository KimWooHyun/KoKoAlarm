package hs.mirim;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class KoKoAlarmActivity extends Activity implements OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageButton imgbtnkoko=(ImageButton)findViewById(R.id.imgbtnkoko);
        ImageButton imgbtnway=(ImageButton)findViewById(R.id.imgbtnway);
        
        imgbtnkoko.setOnClickListener(this);
        imgbtnway.setOnClickListener(this);
        
    }//onCreate
    
    public void onClick(View v) {
    	if(v.getId()==R.id.imgbtnkoko){
    		Intent intent1=new Intent(KoKoAlarmActivity.this, AddAlarm.class);
    		startActivity(intent1);
    	}
    	else if(v.getId()==R.id.imgbtnway){
    		Intent intent2=new Intent(KoKoAlarmActivity.this, Way.class);
    		startActivity(intent2);
    	}
    }
}