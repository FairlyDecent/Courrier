package ca.felix.courrier;

public class MainMenuActivity extends EmptyActivity {
	
	protected int initView() {
		return R.layout.activity_main_menu;
	}
	
	protected void init() {
	}
	
	protected String getTag() { return "MainMenuActivity"; }
	
	protected boolean dispose() {
		return true;
	}
}
