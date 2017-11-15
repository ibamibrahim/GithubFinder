package id.ibam.githubfinder.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.R;

/**
 * Created by Ibam on 11/15/2017.
 */

public class MainActivity extends AppCompatActivity implements MvpView, MainActivityContract.Presenter {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
