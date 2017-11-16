package id.ibam.githubfinder.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.ibam.githubfinder.detail.overview.OverviewFragment;
import id.ibam.githubfinder.detail.repolist.RepoListFragment;

/**
 * Created by Ibam on 11/15/2017.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Bundle bundle;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, String name) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.bundle = new Bundle();
        bundle.putString("name", name);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OverviewFragment tab1 = OverviewFragment.newInstance(bundle);
                return tab1;
            case 1:
                RepoListFragment tab2 = RepoListFragment.newInstance(bundle);
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
