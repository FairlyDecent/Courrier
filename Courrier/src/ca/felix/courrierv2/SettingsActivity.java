package ca.felix.courrierv2;

import android.os.Bundle;
import android.view.Menu;


public class SettingsActivity extends BlankActivity {

	protected int initView() {
		return R.layout.activity_settings;
	}

	protected void init(Bundle bundle) {
	}

	protected int initOptionsMenuLayout() {
		return R.menu.settings;
	}

	protected boolean optionsItemSelected(int itemId) {
		return false;
	}

	protected void initOptionsMenu(Menu menu) {
	}
}
