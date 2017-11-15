package id.ibam.githubfinder.detail;

/**
 * Created by Ibam on 11/15/2017.
 */

public class DetailContract {
    interface View {
        void loadComplete();
    }

    interface Presenter {
        void loadUserDetail();

        void loadUserRepos();
    }

}
