package id.ibam.githubfinder.main;

import android.util.Log;

import java.util.List;

import id.ibam.githubfinder.BasePresenter;
import id.ibam.githubfinder.MvpView;
import id.ibam.githubfinder.services.Helper;
import id.ibam.githubfinder.services.RemoteServices;
import id.ibam.githubfinder.services.model.userlist.UsersListResponse;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 11/15/2017.
 */

public class MainActivityPresenter extends BasePresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainActivityPresenter";
    MainActivityContract.View mView;

    @Override
    public void onAttach(MvpView mvpView) {
        super.onAttach(mvpView);
        this.mView = (MainActivityContract.View) mvpView;
    }

    @Override
    public void getUserLists(String name) {
        RemoteServices remoteServices = new RemoteServices();
        Log.i(TAG, "getUserLists: ok");
        remoteServices.getUser(name).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<UsersListResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Response<UsersListResponse> listResponse) {
                        List<String> usernames = Helper.getUsersName(listResponse.body());
                        mView.showUserList(usernames);
                    }
                });
    }
}
