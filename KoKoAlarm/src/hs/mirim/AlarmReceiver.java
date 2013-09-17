package hs.mirim;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent arg1) {
		
		diableLockScreen(context);
		AlarmPowerManager.acquire(context);
		
		Intent newIntent=new Intent(context, MainActivity.class);
		newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
				Intent.FLAG_ACTIVITY_CLEAR_TOP |
				Intent.FLAG_ACTIVITY_SINGLE_TOP);
		context.startActivity(newIntent);
	}

	private void diableLockScreen(Context context) {
		KeyguardManager manager = (KeyguardManager)context.getSystemService(Activity.KEYGUARD_SERVICE);  
		KeyguardLock lock = manager.newKeyguardLock(Activity.KEYGUARD_SERVICE);  
		lock.disableKeyguard();  
	}
}