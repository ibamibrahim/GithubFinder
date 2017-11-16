package id.ibam.githubfinder.detail.repolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.R;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;

/**
 * Created by Ibam on 11/15/2017.
 */

public class RepoListFragment extends Fragment implements MvpView, RepoListContract.View {
    private static final String TAG = "RepoListFragment";
    String name;
    RecyclerView recyclerView;
    RepoListAdapter adapter;
    RepoListPresenter mPresenter;

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
        View view = inflater.inflate(R.layout.tab_repo, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.repo_rv);
        return view;
    }

    @Override
    public void onResume() {
        name = getArguments().getString("name");
        Log.i(TAG, "onCreateView: " + name);
        initPresenter();
        initRV();
        mPresenter.getData(name);
        super.onResume();
    }

    private void initPresenter() {
        mPresenter = new RepoListPresenter();
        mPresenter.onAttach(this);
    }

    private void initRV() {
        adapter = new RepoListAdapter(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showData(List<UserReposResponse> data) {
        Log.i(TAG, "showData: " + data.size());
        adapter.setDataSet(data);
        adapter.notifyDataSetChanged();
    }
}
