package id.ibam.githubfinder.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.List;

import id.ibam.githubfinder.BaseActivity;
import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.R;

/**
 * Created by Ibam on 11/15/2017.
 */

public class MainActivity extends BaseActivity implements MvpView, MainActivityContract.View {

    private static final String TAG = "MainActivity";
    MainActivityPresenter mPresenter;
    RecyclerView recyclerView;
    UserListAdapter adapter;
    TextView status;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = (TextView) findViewById(R.id.status);
        initPresenter();
        initRV();
    }

    private void initPresenter() {
        mPresenter = new MainActivityPresenter();
        mPresenter.onAttach(this);
    }

    private void initRV() {
        recyclerView = (RecyclerView) findViewById(R.id.userlist_rv);
        adapter = new UserListAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_menu);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                showProgressDialog("Loading...");
                mPresenter.getUserLists(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showUserList(List<String> list) {
        hideDialog();
        if (list.size() != 0) {
            status.setVisibility(View.GONE);
        } else {
            status.setVisibility(View.VISIBLE);
            status.setText("No user found");
        }
        adapter.setDataSet(list);
        adapter.notifyDataSetChanged();
    }
}


