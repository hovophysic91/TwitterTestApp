package johnnysc.github.twittertestapp.view;

import johnnysc.github.twittertestapp.adapter.TweetAdapter;

/**
 * Interface for main view
 *
 * @author Asatryan on 18.11.17.
 */

public interface MainView {

    /**
     * Update data at the screen
     *
     * @param adapter recycler view adapter {@link TweetAdapter}
     */
    void updateData(TweetAdapter adapter);
}