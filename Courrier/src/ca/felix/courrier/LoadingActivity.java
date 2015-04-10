package ca.felix.courrier;

import android.content.Intent;

public class LoadingActivity extends EmptyActivity {

	protected int initView() {
		return R.layout.activity_loading;
	}
	
	protected void init() {
		if (dispose()) startActivity(new Intent(this, MainMenuActivity.class));
	}
	
	protected String getTag() { return "LoadingActivity"; }
	
	protected boolean dispose() {
		return true;
	}
}
