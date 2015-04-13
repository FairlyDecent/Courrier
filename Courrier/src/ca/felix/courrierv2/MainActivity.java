package ca.felix.courrierv2;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import ca.felix.courrierv2.utils.StaticConfig;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;



public class MainActivity extends BlankActivity implements OnMapReadyCallback {

	protected int initView() {
		// TODO: Loading screen cause long fucking loading for the maps
		// Also cache the maps so they don't need to be re-initialized every time (cause long fucking loading time)
		return R.layout.activity_main;
	}

	protected void init(Bundle bundle) {
		((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment)).getMapAsync(this);
	}

	protected int initOptionsMenuLayout() {
		return R.menu.main;
	}

	protected boolean optionsItemSelected(int itemId) {
		return false;
	}

	protected void initOptionsMenu(Menu menu) {
		if (menu.findItem(R.id.action_gps) != null) {
			MenuItem item = menu.findItem(R.id.action_gps);
			
			if (!item.isCheckable()) item.setCheckable(true);
			
			item.setChecked(StaticConfig.gps_state);
			if (item.isChecked()) item.setIcon(R.drawable.ic_action_location_found);
			else item.setIcon(R.drawable.ic_action_location_off);
		}
		
		if (menu.findItem(R.id.action_search) != null) {
			SearchView view = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
			view.setQueryHint("Search Location...");
		}
	}

	public void onMapReady(GoogleMap map) {
	}
}
