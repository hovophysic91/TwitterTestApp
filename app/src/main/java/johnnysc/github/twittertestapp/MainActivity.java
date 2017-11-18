package johnnysc.github.twittertestapp;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;
import johnnysc.github.twittertestapp.adapter.TweetAdapter;
import johnnysc.github.twittertestapp.presenter.MainPresenter;
import johnnysc.github.twittertestapp.presenter.MainPresenterImpl;
import johnnysc.github.twittertestapp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, SearchView.OnQueryTextListener {

    private Toolbar mToolbar;
    private SearchView mSearchView;
    private RecyclerView mRecyclerView;

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig("R50NtCvEvmH8LDEnemLaev8vm", "9bnypUqoH4SO0M4Vwavl7JSOOG2hRrjv5eCeronW4LZxV06NS5");
        Fabric.with(this, new TwitterCore(authConfig));
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        mMainPresenter = new MainPresenterImpl(this);
        initUi();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateData(TweetAdapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        mMainPresenter.onQueryTextSubmit(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mMainPresenter.onQueryTextChange(newText);
        return true;
    }

    private void initUi() {
        initToolbar();
        initSearchView();
        initRecyclerView();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void initSearchView() {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView = findViewById(R.id.search_view);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mSearchView.setOnQueryTextListener(this);
    }
}