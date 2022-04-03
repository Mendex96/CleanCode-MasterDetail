package es.ulpgc.eite.cleancode.catalog.Category;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class CategoryListModel implements CategoryListContract.Model {

    public static String TAG = CategoryListModel.class.getSimpleName();
    private final List<CategoryItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    @Override
    public String getStoredData() {
        return null;
    }

    public CategoryListModel() {
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    private void addProduct(CategoryItem item) {
        itemList.add(item);
    }
    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    private CategoryItem createProduct(int position) {
        String content = "Product " + position;

        return new CategoryItem(
                position, content, fetchCategoryDetails(position)
        );

    }

    private String fetchCategoryDetails(int position) {
        String content = "Details about Product:  " + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

        for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }
    @Override
    public List<CategoryItem> fetchCategoryListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}