package es.ulpgc.eite.cleancode.catalog.product;

import java.lang.ref.WeakReference;

interface ProductDetailContract {

  interface View {
    void injectPresenter(Presenter presenter);
    void modifyTitle(int number);


    void displayProductDetailData(ProductDetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);
    void onStart();
    void onRestart();
    void onResume();

    void fetchProductDetailData();
  }

  interface Model {

  }

//  interface Router {
//
//    ProductItem getDataFromProductListScreen();
//  }
}