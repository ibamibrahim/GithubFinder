package id.ibam.githubfinder.detail;

import id.ibam.githubfinder.BasePresenter;
import id.ibam.githubfinder.MvpView;

/**
 * Created by Ibam on 11/15/2017.
 */

public class DetailPresenter extends BasePresenter implements DetailContract.Presenter {

    DetailContract.View mView;

    @Override
    public void onAttach(MvpView mvpView) {
        super.onAttach(mvpView);
        this.mView = (DetailContract.View) mvpView;
    }

    @Override
    public void loadRepos(String name) {

    }

    @Override
    public void userDetail(String name) {

    }
}
