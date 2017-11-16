package id.ibam.githubfinder.detail.repolist;

import java.util.List;

import id.ibam.githubfinder.services.model.repo.UserReposData;
import id.ibam.githubfinder.services.model.repo.UserReposResponse;

/**
 * Created by Ibam on 11/15/2017.
 */

public interface RepoListContract {
    interface View {
        void showData(List<UserReposData> data);
    }

    interface Presenter {
        void getData(String name);
    }
}
