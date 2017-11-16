package id.ibam.githubfinder.detail.repolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ibam.githubfinder.R;

/**
 * Created by Ibam on 11/15/2017.
 */

public class RepoListFragment extends Fragment {
    private static final String TAG = "RepoListFragment";
    String name;

    public static RepoListFragment newInstance(Bundle arguments) {
        RepoListFragment fragment = new RepoListFragment();
        if (arguments != null) {
            fragment.setArguments(arguments);
            Log.i(TAG, "newInstance: OK");
        } else {
            Log.i(TAG, "newInstance: null argument");
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_repo, container, false);
    }

    @Override
    public void onResume() {
        name = getArguments().getString("name");
        Log.i(TAG, "onCreateView: " + name);
        super.onResume();
    }
}
