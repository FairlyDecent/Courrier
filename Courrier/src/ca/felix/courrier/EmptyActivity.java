package ca.felix.courrier;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public abstract class EmptyActivity extends Activity {
	
	/** Resources manager for all non-code assets */
	protected static Resources res;
	
	/** Intent passed by the previous activity */
	protected Intent previousIntent;
	
	/** Sets the content view */
	protected abstract int initView();
	/** Initialize the activity specifics */
	protected abstract void init();
	/** Dispose of the current activity */
	protected abstract boolean dispose();
	
	/** Returns the tag of the activity */
	protected abstract String getTag();
	
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(initView());
		
		previousIntent = getIntent();
		res = getResources();
		
		init();
	}
	
	public void nextScreen(View view) {
		if (view == null) return;
		else if (view.getId() == -1) return;
		
		Intent intent;
		
		switch (view.getId()) {
		case R.id.switch_loading :
			Log.i(getTag(), "Switched activity to loading screen.");
			intent = new Intent(this, LoadingActivity.class);
			break;
		default :
			Log.i(getTag(), "Couldn't switch to the next activity.");
			return;
		}
		
		if (dispose()) startActivity(intent);
	}
	
}
