package johnnysc.github.twittertestapp.presenter;

import johnnysc.github.twittertestapp.view.MainView;

/**
 * Interface for main presenter
 *
 * @author Asatryan on 18.11.17.
 */

public interface MainPresenter extends MainView {

    /**
     * Handle text submitting
     *
     * @param query search result
     */
    void onQueryTextSubmit(String query);

    /**
     * Handle text changed
     *
     * @param text search text
     */
    void onQueryTextChange(String text);
}