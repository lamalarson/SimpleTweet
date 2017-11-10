package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Guest 3 on 11/9/2017.
 */

public class Tweet {
    // list of the attribute
    public String body;
    public Long Uid; // the database id for tweet
    public User user;
    public String CreatedAt;

    // deserialize the json
    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException{
Tweet tweet = new Tweet();

        // extract the value from JSON
        tweet.body =  jsonObject.getString("text");
        tweet.Uid = jsonObject.getLong("id");
        tweet.CreatedAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));

        return tweet;
    }
}
