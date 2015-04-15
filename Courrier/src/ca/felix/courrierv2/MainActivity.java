package ca.felix.courrierv2;

import android.app.Dialog;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import ca.felix.courrierv2.utils.StaticConfig;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends BlankActivity implements OnMapReadyCallback, ConnectionCallbacks {

	public static GoogleApiClient apiClient;

	public static Location lastLocation;

	private GoogleMap map;

	protected int initView() {
		// TODO: Loading screen cause long fucking loading for the maps
		// Also cache the maps so they don't need to be re-initialized every
		// time (cause long fucking loading time)
		return R.layout.activity_main;
	}

	protected void init(Bundle bundle) {
		if (apiClient == null) {
			apiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addApi(LocationServices.API).build();
			apiClient.connect();
		}
		
		((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment)).getMapAsync(this);
	}

	public void onResume() {
		Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this), this, 1000);
		if (errorDialog != null)
			errorDialog.show();
		super.onResume();
	}

	protected int initOptionsMenuLayout() {
		return R.menu.main;
	}

	protected boolean optionsItemSelected(int itemId) {
		return false;
	}

	protected void initOptionsMenu(Menu menu) {
		if (menu.findItem(R.id.action_available) != null) {
			MenuItem item = menu.findItem(R.id.action_available);

			if (!item.isCheckable())
				item.setCheckable(true);

			item.setChecked(StaticConfig.available_state);
			if (item.isChecked())
				item.setIcon(R.drawable.ic_action_place_dark);
			else
				item.setIcon(R.drawable.ic_action_place);
		}

		if (menu.findItem(R.id.action_search) != null) {
			SearchView view = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
			view.setQueryHint("Search Location...");
		}
	}

	public void onMapReady(GoogleMap map) {
		map.setPadding(0, (int) getResources().getDimension(R.dimen.abc_action_bar_default_height_material), 0, 0);
		map.setMyLocationEnabled(true);

		if (lastLocation != null)
			map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()), 13.0f, 0.0f, 0.0f)));

		this.map = map;
	}

	public void onConnected(Bundle hint) {
		lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
		map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()), 13.0f, 0.0f, 0.0f)));
	}

	public void onConnectionSuspended(int arg0) {
	}
}
