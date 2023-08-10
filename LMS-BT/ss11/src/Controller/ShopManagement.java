package Controller;

import BTTH.ra.Category;

import java.util.List;

public class ShopManagement {
    private final CategoriesManager categoriesManager = new CategoriesManager();

    public CategoriesManager getCategoriesManager() {
        return categoriesManager;
    }
}
