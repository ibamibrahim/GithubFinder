package id.ibam.githubfinder.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ibam.githubfinder.R;

/**
 * Created by Ibam on 11/15/2017.
 */

public class RepoListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_repo, container, false);
    }
}
