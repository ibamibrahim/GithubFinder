package id.ibam.githubfinder.detail.repolist;

import java.util.List;

import id.ibam.githubfinder.BasePresenter;
import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.services.RemoteServices;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 11/15/2017.
 */

public class RepoListPresenter extends BasePresenter implements RepoListContract.Presenter {

    RepoListContract.View mView;

    @Override
    public void onAttach(MvpView mvpView) {
        super.onAttach(mvpView);
        mView = (RepoListContract.View) mvpView;
    }

    @Override
    public void getData(String name) {
        RemoteServices remoteServices = new RemoteServices();
        remoteServices.getRepos(name).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<List<UserReposResponse>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<List<UserReposResponse>> listResponse) {
                        mView.showData(listResponse.body());
                    }
                });
    }
}
