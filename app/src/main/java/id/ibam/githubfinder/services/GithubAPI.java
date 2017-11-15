package id.ibam.githubfinder.services;

import java.util.List;

import id.ibam.githubfinder.services.model.UserDetailResponse;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;
import id.ibam.githubfinder.services.model.userlist.UsersListResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Ibam on 11/15/2017.
 */

public interface GithubAPI {

    @GET("users/{name}")
    Observable<Response<List<UsersListResponse>>> getUsers(@Path("name") String name);

    @GET("/search/users?q={name}")
    Observable<Response<UserDetailResponse>> getDetail(@Path("name") String name);

    @GET("users/{name}/repos")
    Observable<Response<UserReposResponse>> getRepos(@Path("name") String name);


}
