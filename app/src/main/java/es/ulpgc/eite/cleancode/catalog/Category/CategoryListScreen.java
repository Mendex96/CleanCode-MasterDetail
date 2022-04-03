package es.ulpgc.eite.cleancode.catalog.Category;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class CategoryListScreen {

    public static void configure(CategoryListContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        CatalogMediator mediator = CatalogMediator.getInstance();

        CategoryListContract.Presenter presenter = new CategoryListPresenter(mediator);
        CategoryListContract.Model model = new CategoryListModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}