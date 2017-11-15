package id.ibam.githubfinder.main;

import java.util.List;

/**
 * Created by Ibam on 11/15/2017.
 */

public class MainActivityContract {

    interface View{
        void showUserList(List<String> list);
    }

    interface Presenter{
        void getUserLists(String name);
    }
}
