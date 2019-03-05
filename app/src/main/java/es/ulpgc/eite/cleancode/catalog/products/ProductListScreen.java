package es.ulpgc.eite.cleancode.catalog.products;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class ProductListScreen {

  public static void configure(ProductListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    ProductListState state = mediator.getProductListState();

    ProductListContract.Router router = new ProductListRouter(mediator);
    ProductListContract.Presenter presenter = new ProductListPresenter(state);
    ProductListModel model = new ProductListModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
