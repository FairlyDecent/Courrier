package ca.felix.courrierv2;

import ca.felix.courrierv2.utils.LocationUtils;
import ca.felix.courrierv2.utils.StaticConfig;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BlankActivity extends ActionBarActivity {
	
	protected Intent previousIntent;
	
	protected abstract int initView();
	
	protected abstract void init(Bundle bundle);
	
	protected abstract int initOptionsMenuLayout();
	
	protected abstract void initOptionsMenu(Menu menu);
	
	protected abstract boolean optionsItemSelected(int itemId);
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initView());
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		init(savedInstanceState);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(initOptionsMenuLayout(), menu);
		initOptionsMenu(menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		if (optionsItemSelected(id)) return true;
		
		switch (id) {
		case R.id.action_settings :
			startActivity(new Intent(this, SettingsActivity.class));
			return true;
		case R.id.action_search :
			if (MenuItemCompat.getActionView(item) instanceof SearchView) {
				SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
				searchView.setOnQueryTextListener(new OnQueryTextListener() {
					public boolean onQueryTextChange(String newText) {
						return false;
					}
					public boolean onQueryTextSubmit(String query) {
						if (LocationUtils.searchLocation(query)) return true;
						else return false;
					}
				});
			}
			return true;
		case R.id.action_gps :
			if (item.isCheckable()) {
				item.setChecked(!StaticConfig.gps_state);
				StaticConfig.gps_state = item.isChecked();
				if (item.isChecked()) item.setIcon(R.drawable.ic_action_location_found);
				else item.setIcon(R.drawable.ic_action_location_off);
			} else item.setCheckable(true);
			return LocationUtils.toggleGPS();
		default :
			return super.onOptionsItemSelected(item);
		}
	}
}
