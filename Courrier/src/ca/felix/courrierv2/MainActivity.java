package ca.felix.courrierv2;



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
		return false;
	}
}
