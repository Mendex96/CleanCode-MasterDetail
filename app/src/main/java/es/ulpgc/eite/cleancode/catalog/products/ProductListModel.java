package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  private final List<ProductItem> itemList = new ArrayList<>();
  private final int COUNT = 20;

  public ProductListModel() {
    // Add some sample items
    for (int index = 1; index <= COUNT; index++) {
      addProduct(createProduct(index));
    }
  }

  @Override
  public List<ProductItem> fetchProductListData() {
    Log.e(TAG, "fetchProductListData()");
    return itemList;
  }

  private void addProduct(ProductItem item) {
    itemList.add(item);
  }

  @Override
  public void modifyCategory(int category) {
    for (int index = 0; index < COUNT; index++) {
      itemList.get(index).content = "Product "+ category + "." + (index+1);
    }

  }

  private ProductItem createProduct(int position) {
    String content = "Product " + "." +position;

    return new ProductItem(
        position, content, fetchProductDetails("0.0",position)
    );
  }

  @Override
  public void modifyInfo(int category) {
    for (int index = 0; index < COUNT; index++) {
      itemList.get(index).details=fetchProductDetails((category+"."+(index+1)),(index+1));
    }

  }

  private String fetchProductDetails(String info,int position) {
    String content = "Details about Product:  " + info;
    StringBuilder builder = new StringBuilder();
    builder.append(content);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details information here.");
    }

    return builder.toString();
  }

}
