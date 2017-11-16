package id.ibam.githubfinder.detail;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import id.ibam.githubfinder.BaseActivity;
import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.R;

public class DetailActivity extends BaseActivity implements MvpView, DetailContract.View {

    private static final String TAG = "DetailActivity";
    DetailPresenter mPresenter;
    String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name = getIntent().getStringExtra("name");
        Log.i(TAG, "onCreate: " + name);
        initTabAndViewPager();
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new DetailPresenter();
        mPresenter.onAttach(this);
    }

    @Override
    public void loadComplete() {

    }

    private void initTabAndViewPager() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Overview"));
        tabLayout.addTab(tabLayout.newTab().setText("Repositories"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), name);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
