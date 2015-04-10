package ca.felix.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ca.felix.courrier.R;

public class SlidingTabsBasicFragment extends Fragment {

	private SlidingTabLayout mSlidingTabLayout;
	private ViewPager mViewPager;

	public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle) {
		return inflater.inflate(R.layout.fragment_sample, group, false);
	}

	public void onViewCreated(View view, Bundle savedInstanceState) {
		mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
		mViewPager.setAdapter(new SamplePagerAdapter());

		mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setViewPager(mViewPager);
	}

	class SamplePagerAdapter extends PagerAdapter {

		public int getCount() {
			return 10;
		}

		public boolean isViewFromObject(View view, Object o) {
			return o == view;
		}

		public CharSequence getPageTitle(int position) {
			return "Item " + (position + 1);
		}

		public Object instantiateItem(ViewGroup container, int position) {
			View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item, container, false);
			container.addView(view);

			TextView title = (TextView) view.findViewById(R.id.item_title);
			title.setText(String.valueOf(position + 1));

			return view;
		}

		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}
}
