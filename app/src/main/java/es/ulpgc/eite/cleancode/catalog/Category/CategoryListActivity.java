package es.ulpgc.eite.cleancode.catalog.Category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailActivity;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;
import es.ulpgc.eite.cleancode.catalog.products.ProductListAdapter;
import es.ulpgc.eite.cleancode.catalog.products.ProductListScreen;
import es.ulpgc.eite.cleancode.catalog.products.ProductListViewModel;

public class CategoryListActivity
        extends AppCompatActivity implements CategoryListContract.View {

    public static String TAG = CategoryListActivity.class.getSimpleName();

    CategoryListContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_category_list));
        }

        listView = findViewById(R.id.product_list);


        // do the setup
        CategoryListScreen.configure(this);

        // do some work
        presenter.fetchCategoryListData();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void displayCategoryListData(CategoryListViewModel viewModel) {
        Log.e(TAG, "displayProductListData()");

        // deal with the data
        listView.setAdapter(new CategoryListAdapter(
                        this, viewModel.category, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategoryItem item = (CategoryItem) view.getTag();
                        presenter.selectCategoryListData(item);
                    }
                })
        );

    }



    @Override
    public void navigateToProductListScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(CategoryListContract.Presenter presenter) {
        this.presenter = presenter;
    }


}