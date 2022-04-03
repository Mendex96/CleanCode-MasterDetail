package es.ulpgc.eite.cleancode.catalog.app;

import es.ulpgc.eite.cleancode.catalog.Category.CategoryListContract;
import es.ulpgc.eite.cleancode.catalog.Category.CategoryListState;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator {

  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();
  private CategoryListState categoryListState= new CategoryListState();

  private ProductItem product;
  private CategoryItem category;

  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }

  public CategoryListState getCategoryListState() {
    return categoryListState;
  }
  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }

  public void setCategory(CategoryItem item) {
    category = item;
  }
  public void setProduct(ProductItem item) {
    product = item;
  }

}
