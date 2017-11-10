package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by Guest 3 on 11/9/2017.
 */

public class TweetAdapter extends  RecyclerView.Adapter<TweetAdapter.ViewHolder> {
    private List<Tweet> mtweets;
    Context context;
    // passin the tweet array in the constructor
    public TweetAdapter(List<Tweet> tweets){
        mtweets = tweets;
    }
    // for each row inflate the layout and cache the references into viewholder

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return  viewHolder;
    }

    // bind the value based on the position of the element

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // get the data according to position
        Tweet tweet = mtweets.get(position);

        // populate the view according to this data
        holder.tvUserName.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return mtweets.size();
    }

    // create viewholder class

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProfileImage;
        public TextView tvUserName;
        public TextView tvBody;

        public ViewHolder(View itemView){
            super(itemView);

            // perform findviewbyid lookups
            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);

        }
    }
}
