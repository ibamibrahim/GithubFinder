package id.ibam.githubfinder.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

<<<<<<< HEAD
import id.ibam.githubfinder.detail.fragment.OverviewFragment;
import id.ibam.githubfinder.detail.fragment.RepoListFragment;
=======
import id.ibam.githubfinder.detail.overview.OverviewFragment;
import id.ibam.githubfinder.detail.repolist.RepoListFragment;
>>>>>>> 0521c036116e570fe3ff2089b6302e79a614022c

/**
 * Created by Ibam on 11/15/2017.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                OverviewFragment tab1 = new OverviewFragment();
                return tab1;
            case 1:
                RepoListFragment tab2 = new RepoListFragment ();
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
