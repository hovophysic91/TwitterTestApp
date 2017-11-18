package johnnysc.github.twittertestapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import johnnysc.github.twittertestapp.R;

/**
 * RecyclerView Adapter for Tweets
 *
 * @author Asatryan on 18.11.17.
 */

public final class TweetAdapter extends RecyclerView.Adapter<TweetViewHolder> {

    private List<Tweet> mTweets;

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet, parent, false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {
        Tweet currentTweet = mTweets.get(position);
        holder.setTweetText(currentTweet.text);
    }

    @Override
    public int getItemCount() {
        return mTweets == null ? 0 : mTweets.size();
    }

    /**
     * Set tweets and notifyDataSetChanged
     *
     * @param tweets list of tweets
     */
    public void setTweets(List<Tweet> tweets) {
        mTweets = tweets;
        notifyDataSetChanged();
    }
}