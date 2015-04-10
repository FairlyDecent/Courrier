package ca.felix.courrier;

import ca.felix.courrier.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BlankActivity extends ActionBarActivity {

	protected Intent previousIntent;

	protected abstract int initView();

	protected abstract void init();

	protected abstract int initOptionsMenu();

	protected abstract boolean optionsItemSelected(int itemId);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initView());

		previousIntent = getIntent();
		init();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(initOptionsMenu(), menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (optionsItemSelected(id))
			return true;

		switch (id) {
		case R.id.action_settings:
			startActivity(new Intent(this, SettingsActivity.class));
			return true;
		case R.id.action_help:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
