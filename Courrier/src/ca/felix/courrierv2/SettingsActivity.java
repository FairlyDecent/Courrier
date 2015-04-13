package ca.felix.courrierv2;


public class SettingsActivity extends BlankActivity {

	protected int initView() {
		return R.layout.activity_settings;
	}

	protected void init() {
	}

	protected int initOptionsMenu() {
		return R.menu.settings;
	}

	protected boolean optionsItemSelected(int itemId) {
		return false;
	}
}
