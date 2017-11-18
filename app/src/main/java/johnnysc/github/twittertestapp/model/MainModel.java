package johnnysc.github.twittertestapp.model;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.models.Search;

import java.util.concurrent.TimeUnit;

import io.reactivex.subjects.BehaviorSubject;
import johnnysc.github.twittertestapp.adapter.TweetAdapter;
import johnnysc.github.twittertestapp.presenter.MainPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that maintains all the logic
 *
 * @author Asatryan on 18.11.17.
 */

public final class MainModel {

    private final MainPresenter mMainPresenter;
    private final TweetAdapter mTweetAdapter;
    private final BehaviorSubject<String> mBehaviorSubject;
    private final TwitterApiClient mApiClient;

    public MainModel(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
        mTweetAdapter = new TweetAdapter();
        mBehaviorSubject = BehaviorSubject.create();
        mApiClient = new TwitterApiClient();
    }

    public void onQueryTextSubmit(String query) {
        mBehaviorSubject.onComplete();
        getData();
        mMainPresenter.updateData(mTweetAdapter);
    }


    public void onQueryTextChange(String text) {
        mBehaviorSubject.onNext(text);
        getData();
        mMainPresenter.updateData(mTweetAdapter);
    }

    private void getData() {
        mBehaviorSubject
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(query -> {
                    Call<Search> searchCall = mApiClient.getSearchService().tweets(query, null, null, null, null, null, null, null, null, null);
                    searchCall.enqueue(new Callback<Search>() {
                        @Override
                        public void onResponse(Call<Search> call, Response<Search> response) {
                            if (response != null && response.body() != null)
                                mTweetAdapter.setTweets(response.body().tweets);
                        }

                        @Override
                        public void onFailure(Call<Search> call, Throwable t) {
                            mMainPresenter.showError();
                        }
                    });

                });
    }
}