package es.ulpgc.eite.cleancode.catalog.Category;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public interface CategoryListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayCategoryListData(CategoryListViewModel viewModel);
        void navigateToProductListScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void onResume();

        void onStart();

        void onRestart();

        void onBackPressed();

        void onPause();

        void onDestroy();
        void fetchCategoryListData();
        void selectCategoryListData(CategoryItem item);
    }

    interface Model {
        String getStoredData();
        List<CategoryItem> fetchCategoryListData();
        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}