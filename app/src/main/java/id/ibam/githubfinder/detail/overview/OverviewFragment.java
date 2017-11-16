package id.ibam.githubfinder.detail.overview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.R;
import id.ibam.githubfinder.services.model.UserDetailResponse;

/**
 * Created by Ibam on 11/15/2017.
 */

public class OverviewFragment extends Fragment implements MvpView, OverviewContract.View {
    private static final String TAG = "OverviewFragment";
    String name;
    OverviewPresenter mPresenter;

    @BindView(R.id.full_name)
    TextView fullName;

    @BindView(R.id.login_name)
    TextView loginName;

    @BindView(R.id.about)
    TextView about;

    @BindView(R.id.following_count)
    TextView following;

    @BindView(R.id.follower_count)
    TextView follower;

    @BindView(R.id.location)
    TextView location;

    @BindView(R.id.link)
    TextView link;

    @BindView(R.id.date_joined)
    TextView dateJoined;


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
        View view = inflater.inflate(R.layout.tab_overview, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        name = getArguments().getString("name");
        Log.i(TAG, "onCreateView: " + name);
        initPresenter();
        mPresenter.getUserOverview(name);
        super.onResume();
    }

    private void initPresenter() {
        mPresenter = new OverviewPresenter();
        mPresenter.onAttach(this);
    }

    @Override
    public void showUserOverview(UserDetailResponse data) {
        fullName.setText(data.getName());
        loginName.setText(data.getLogin());
        about.setText(data.getBio());
        follower.setText("FOLLOWERS (" + data.getFollowers() + ")");
        following.setText("FOLLOWINGS (" + data.getFollowing() + ")");
        location.setText(data.getLocation());
        link.setText(data.getBlog());
        dateJoined.setText(data.getCreatedAt().substring(0, 10));
    }
}
