package es.ulpgc.eite.cleancode.catalog.products;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;


public class ProductListPresenter implements ProductListContract.Presenter {

  public static String TAG = ProductListPresenter.class.getSimpleName();

  private WeakReference<ProductListContract.View> view;
  private ProductListState state;
  private ProductListContract.Model model;
  //private ProductListContract.Router router;
  private CatalogMediator mediator;


  public ProductListPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getProductListState();
  }

//  public ProductListPresenter(ProductListState state) {
//    this.state = state;
//  }


  @Override
  public void injectView(WeakReference<ProductListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductListContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(ProductListContract.Router router) {
//    this.router = router;
//  }

  private void passDataToProductDetailScreen(ProductItem item) {
    mediator.setProduct(item);
  }


  @Override
  public void fetchProductListData() {
    // Log.e(TAG, "fetchProductListData()");
    CategoryItem product = getDataFromProductListScreen();
    //ProductItem product = router.getDataFromProductListScreen();
    if (product != null) {
     //state.products = product;
     state.number = product.id;
     view.get().modifyTitle(state.number);
     model.modifyCategory(state.number);
      model.modifyInfo(state.number);
    }
    // call the model
    state.products = model.fetchProductListData();
    view.get().displayProductListData(state);

  }

  @Override
  public void onStart() {
  }

  @Override
  public void onRestart() {
    view.get().modifyTitle(state.number);
    model.modifyCategory(state.number);
    model.modifyInfo(state.number);
    state.products = model.fetchProductListData();
    view.get().displayProductListData(state);

  }

  @Override
  public void onResume() {
    view.get().modifyTitle(state.number);
    model.modifyCategory(state.number);
    model.modifyInfo(state.number);
    state.products = model.fetchProductListData();
    view.get().displayProductListData(state);
  }

  private CategoryItem getDataFromProductListScreen() {
    CategoryItem product = mediator.getCategory();
    return product;
  }

  @Override
  public void selectProductListData(ProductItem item) {
    //router.passDataToProductDetailScreen(item);
    passDataToProductDetailScreen(item);
    //router.navigateToProductDetailScreen();
    view.get().navigateToProductDetailScreen();
  }


}
