package johnnysc.github.twittertestapp.presenter;

import johnnysc.github.twittertestapp.adapter.TweetAdapter;
import johnnysc.github.twittertestapp.model.MainModel;
import johnnysc.github.twittertestapp.view.MainView;

/**
 * Implementation of {@link MainPresenter}
 *
 * @author Asatryan on 18.11.17.
 */

public final class MainPresenterImpl implements MainPresenter {

    private final MainView mMainView;
    private final MainModel mMainModel;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
        mMainModel = new MainModel(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onQueryTextSubmit(String query) {
        mMainModel.onQueryTextSubmit(query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onQueryTextChange(String text) {
        mMainModel.onQueryTextChange(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateData(TweetAdapter adapter) {
        mMainView.updateData(adapter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showError() {
        mMainView.showError();
    }
}