package id.ibam.githubfinder.services;

import java.util.ArrayList;
import java.util.List;

import id.ibam.githubfinder.services.model.userlist.Item;
import id.ibam.githubfinder.services.model.userlist.UsersListResponse;

/**
 * Created by Ibam on 11/15/2017.
 */

public class Helper {

    public static List<String> getUsersName(UsersListResponse response) {
        List<Item> userList = response.getItems();
        List<String> usernames = new ArrayList<>();
        for (Item user : userList) {
            usernames.add(user.getLogin());
        }
        return usernames;
    }
}
