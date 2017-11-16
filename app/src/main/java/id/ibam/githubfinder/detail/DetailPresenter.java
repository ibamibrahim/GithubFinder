package id.ibam.githubfinder.detail;

import id.ibam.githubfinder.BasePresenter;
import id.ibam.githubfinder.MvpView;

/**
 * Created by Ibam on 11/15/2017.
 */

public class DetailPresenter extends BasePresenter implements DetailContract.Presenter {
    private static final String TAG = "DetailPresenter";

    DetailContract.View mView;

    @Override
    public void onAttach(MvpView mvpView) {
        super.onAttach(mvpView);
        this.mView = (DetailContract.View) mvpView;
    }
}
