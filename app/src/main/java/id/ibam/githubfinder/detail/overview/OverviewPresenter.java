package id.ibam.githubfinder.detail.overview;

import id.ibam.githubfinder.BasePresenter;
import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.services.RemoteServices;
import id.ibam.githubfinder.services.model.UserDetailResponse;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 11/15/2017.
 */

public class OverviewPresenter extends BasePresenter implements OverviewContract.Presenter {

    OverviewContract.View mView;

    @Override
    public void onAttach(MvpView mvpView) {
        super.onAttach(mvpView);
        this.mView = (OverviewContract.View) mvpView;
    }

    @Override
    public void getUserOverview(String name) {
        final RemoteServices remoteServices = new RemoteServices();
        remoteServices.getDetail(name).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<UserDetailResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<UserDetailResponse> response) {
                        mView.showUserOverview(response.body());
                    }
                });
    }
}
