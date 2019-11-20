package com.secondfury.attractgroup.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.secondfury.attractgroup.data.DataBundle;
import com.secondfury.attractgroup.presenters.MainPresenter;
import com.secondfury.attractgroup.R;

import java.util.List;

public class FullDescriptionActivity extends BaseActivity {
    public static final String PAGE_TO_SHOW = "PAGE_TO_SHOW";
    private List<DataBundle> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description);

        int pageToShowIndex = getIntent().getIntExtra(PAGE_TO_SHOW, 0);
        ViewPager pager = findViewById(R.id.pager);
        data = MainPresenter.getInstance().getData();
        pager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(pageToShowIndex);
    }

    public class TabsPagerAdapter extends FragmentPagerAdapter {


        public TabsPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);


        }

        @Override
        public Fragment getItem(int position) {
            FullDescriptionFragment fullDescriptionFragment = FullDescriptionFragment.newInstance();
            fullDescriptionFragment.setData(data.get(position));
            return fullDescriptionFragment;
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return data.size();
        }
    }
}
