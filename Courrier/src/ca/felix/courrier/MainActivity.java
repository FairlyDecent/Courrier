package ca.felix.courrier;


public class MainActivity extends BlankActivity {
	
	protected int initView() {
		return R.layout.activity_main;
	}

	protected void init() {
	}
	
	protected int initOptionsMenu() {
		return R.menu.main;
	}

	protected boolean optionsItemSelected(int itemId) {
		// EXAMPLE:
		// if (itemId == R.id.action_settings) return true;
		return false;
	}
}
