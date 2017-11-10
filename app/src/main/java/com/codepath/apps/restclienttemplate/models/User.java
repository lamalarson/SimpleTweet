package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Guest 3 on 11/9/2017.
 */

public class User {
    // list of the attribute
    public String name;
    public Long uid; // the database id for user
    public String screenName;
    public String profileImageUrl;

    // deserialize the json
    public static User fromJSON(JSONObject json) throws JSONException {
        User user = new User();

        // extract the value from JSON
        user.name =  json.getString("name");
        user.uid = json.getLong("id");
        user.screenName = json.getString("screen_name");
        user.profileImageUrl = json.getString("profile_image_url");

        return user;
    }
}
