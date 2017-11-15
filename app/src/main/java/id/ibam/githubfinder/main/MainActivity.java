package id.ibam.githubfinder.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new MainActivityPresenter();
        mPresenter.onAttach(this);
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
        Toast.makeText(this, list.toString(), Toast.LENGTH_SHORT).show();
    }
}


