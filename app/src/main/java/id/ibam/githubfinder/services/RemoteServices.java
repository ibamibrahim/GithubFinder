package id.ibam.githubfinder.services;

import java.util.List;

import id.ibam.githubfinder.services.model.UserDetailResponse;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;
import id.ibam.githubfinder.services.model.userlist.UsersListResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Ibam on 11/15/2017.
 */

public class RemoteServices {

    final String BASE_URL = "https://api.github.com/";
    GithubAPI retrofit;

    public Observable<Response<UsersListResponse>> getUser(String name) {
        initRetrofit();
        return retrofit.getUsers(name);
    }

    public Observable<Response<UserDetailResponse>> getDetail(String name) {
        initRetrofit();
        return retrofit.getDetail(name);
    }

    public Observable<Response<List<UserReposResponse>>> getRepos(String name) {
        initRetrofit();
        return retrofit.getRepos(name);
    }


    private void initRetrofit() {
        this.retrofit = getRetrofit(BASE_URL);
    }

    private GithubAPI getRetrofit(String BASE_URL) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(GithubAPI.class);
    }
}
