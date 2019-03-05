package es.ulpgc.eite.cleancode.catalog.product;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;


public class ProductDetailRouter implements ProductDetailContract.Router {

  public static String TAG = ProductDetailRouter.class.getSimpleName();

  private CatalogMediator mediator;

  public ProductDetailRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ProductItem getDataFromProductListScreen() {
    ProductItem product = mediator.getProduct();
    return product;
  }
}
