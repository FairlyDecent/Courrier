package ca.felix.courrier;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import ca.felix.courrier.R;
import ca.felix.view.SlidingTabsBasicFragment;

public class TabActivity extends FragmentActivity {
	
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_settings);
		
		if (bundle == null) {
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			SlidingTabsBasicFragment fragment = new SlidingTabsBasicFragment();
			transaction.replace(R.id.sample_content_fragment, fragment);
			transaction.commit();
		}
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }
}
