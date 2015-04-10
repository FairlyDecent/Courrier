package ca.felix.courrier;

public class SettingsActivity extends BlankActivity {

	protected int initView() {
		return R.layout.activity_settings;
	}

	protected int initOptionsMenu() {
		return R.menu.settings;
	}

	protected void init() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	protected boolean optionsItemSelected(int itemId) {
		return false;
	}
}