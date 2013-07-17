package hs.mirim;

import android.app.Activity;
import android.app.AlarmManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class StartAlarm extends Activity{
	ViewGroup.MarginLayoutParams margin;
	int count = 1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startalarm);
        
        Button btnAlarm = (Button) findViewById(R.id.btnAlarm);
		ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(
				btnAlarm.getLayoutParams());
		margin.setMargins(50, 5, 5, 5);
		btnAlarm.setLayoutParams(new LinearLayout.LayoutParams(margin));

		btnAlarm.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (count == 10) {
					Toast.makeText(StartAlarm.this, "일어나세요 용사여", 3000).show();
				} else {
					Log.d("LOG", "Main.onClick");
					Button button = (Button) v;
					ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(
							button.getLayoutParams());
					StartAlarm.this.margin = margin;
					// margin.setMargins(250, 5, 5, 5);
					RandomState();
					button.setLayoutParams(new LinearLayout.LayoutParams(margin));
					button.invalidate();
					count++;
				}
			}
		});
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
        		WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
        		WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | 
        		WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        
	}
	
	public void RandomState() {
		int left = (int) (Math.random() * 500);
		int top = (int) (Math.random() * 1000);
		this.margin.setMargins(left, top, 0, 0);
	}
}
