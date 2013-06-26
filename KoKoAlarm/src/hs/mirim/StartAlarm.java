package hs.mirim;

import android.app.Activity;
import android.app.AlarmManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;

public class StartAlarm extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startalarm);
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
        		WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
        		WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | 
        		WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        
	}
}
