package id.ibam.githubfinder.detail.overview;

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

public class OverviewFragment extends Fragment {
    private static final String TAG = "OverviewFragment";
    String name;

    public static OverviewFragment newInstance(Bundle arguments) {
        OverviewFragment OverviewFragment = new OverviewFragment();
        if (arguments != null) {
            OverviewFragment.setArguments(arguments);
            Log.i(TAG, "newInstance: OK");
        } else {
            Log.i(TAG, "newInstance: null argument");
        }
        return OverviewFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_overview, container, false);
    }

    @Override
    public void onResume() {
        name = getArguments().getString("name");
        Log.i(TAG, "onCreateView: " + name);
        super.onResume();
    }
}
