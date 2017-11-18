package johnnysc.github.twittertestapp.model;

import johnnysc.github.twittertestapp.adapter.TweetAdapter;
import johnnysc.github.twittertestapp.presenter.MainPresenter;

/**
 * Class that maintains all the logic
 *
 * @author Asatryan on 18.11.17.
 */

public final class MainModel {

    private final MainPresenter mMainPresenter;
    private final TweetAdapter mTweetAdapter;

    public MainModel(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
        mTweetAdapter = new TweetAdapter();
    }

    public void onQueryTextSubmit(String query) {
        // TODO: 18.11.17 handle this method when add Rx
        mMainPresenter.updateData(mTweetAdapter);
    }


    public void onQueryTextChange(String text) {
        // TODO: 18.11.17 handle this method when add Rx
        mMainPresenter.updateData(mTweetAdapter);
    }

}