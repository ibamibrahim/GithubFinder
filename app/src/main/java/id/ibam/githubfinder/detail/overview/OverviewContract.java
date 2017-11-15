package id.ibam.githubfinder.detail.overview;

import id.ibam.githubfinder.services.model.UserDetailResponse;

/**
 * Created by Ibam on 11/15/2017.
 */

public interface OverviewContract {
    interface View {
        void showUserOverview(UserDetailResponse data);
    }

    interface Presenter {
        void getUserOverview(UserDetailResponse data);
    }
}
