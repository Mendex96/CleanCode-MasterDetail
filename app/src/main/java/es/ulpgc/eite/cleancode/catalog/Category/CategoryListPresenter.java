package es.ulpgc.eite.cleancode.catalog.Category;

import java.lang.ref.WeakReference;
import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;


public class CategoryListPresenter implements CategoryListContract.Presenter {

    public static String TAG = CategoryListPresenter.class.getSimpleName();

    private WeakReference<CategoryListContract.View> view;
    private CategoryListState state;
    private CategoryListContract.Model model;
    //private ProductListContract.Router router;
    private CatalogMediator mediator;


    public CategoryListPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryListState();
    }

//  public ProductListPresenter(ProductListState state) {
//    this.state = state;
//  }

    @Override
    public void injectView(WeakReference<CategoryListContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryListContract.Model model) {
        this.model = model;
    }

    @Override
    public void onResume() {
    }
    @Override
    public void onStart() {
    }
    @Override
    public void onRestart() {
    }
    @Override
    public void onBackPressed() {
    }
    @Override
    public void onPause() {
    }
    @Override
    public void onDestroy() {
    }

//  @Override
//  public void injectRouter(ProductListContract.Router router) {
//    this.router = router;
//  }

    private void passDataToProductDetailScreen(CategoryItem item) {
        mediator.setCategory(item);
    }

    @Override
    public void fetchCategoryListData() {
        // Log.e(TAG, "fetchProductListData()");

        // call the model
        state.category = model.fetchCategoryListData();
        view.get().displayCategoryListData(state);

    }


    @Override
    public void selectCategoryListData(CategoryItem item) {
        //router.passDataToProductDetailScreen(item);
        passDataToProductDetailScreen(item);
        //router.navigateToProductDetailScreen();
        view.get().navigateToProductListScreen();
    }
}