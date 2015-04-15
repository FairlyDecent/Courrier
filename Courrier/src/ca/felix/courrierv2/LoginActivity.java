package ca.felix.courrierv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class LoginActivity extends BlankActivity {

	protected int initView() {
		return R.layout.activity_login;
	}

	protected void init(Bundle bundle) {
	}

	protected int initOptionsMenuLayout() {
		return R.menu.login;
	}

	protected void initOptionsMenu(Menu menu) {
	}

	protected boolean optionsItemSelected(int itemId) {
		return false;
	}
	
	public void login(View view) {
		startActivity(new Intent(this, MainActivity.class));
	}
}
