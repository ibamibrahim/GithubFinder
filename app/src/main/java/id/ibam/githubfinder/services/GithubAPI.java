package id.ibam.githubfinder.services;

import id.ibam.githubfinder.services.model.UserDetailResponse;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;
import id.ibam.githubfinder.services.model.userlist.UsersListResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Ibam on 11/15/2017.
 */

public interface GithubAPI {

    @GET("/search/users")
    Observable<Response<UsersListResponse>> getUsers(@Query("q") String name);

    @GET("users/{name}")
    Observable<Response<UserDetailResponse>> getDetail(@Path("name") String name);

    @GET("users/{name}/repos")
    Observable<Response<UserReposResponse>> getRepos(@Path("name") String name);


}
