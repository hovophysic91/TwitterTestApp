package johnnysc.github.twittertestapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import johnnysc.github.twittertestapp.R;

/**
 * View holder for a tweet
 *
 * @author Asatryan on 18.11.17.
 */

final class TweetViewHolder extends RecyclerView.ViewHolder {

    private TextView mTweetTextView;

    TweetViewHolder(View itemView) {
        super(itemView);
        mTweetTextView = itemView.findViewById(R.id.tweet_text_view);
    }

    /**
     * Set text to tweet
     *
     * @param text text of a tweet
     */
    void setTweetText(String text) {
        mTweetTextView.setText(text);
    }
}