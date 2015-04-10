package ca.felix.courrier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BlankActivity extends ActionBarActivity {

	protected Intent previousIntent;
	
	protected abstract int initView();
	protected abstract void init();
	
	protected abstract boolean optionsItemSelected(int itemId);
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initView());
		
		previousIntent = getIntent();
		init();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		if (optionsItemSelected(id)) return true;
		if (id == R.id.action_settings) return true;
		
		return super.onOptionsItemSelected(item);
	}
}
