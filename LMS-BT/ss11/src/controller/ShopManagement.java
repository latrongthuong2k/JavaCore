package controller;

public class ShopManagement {
    private final CategoriesManager categoriesManager = new CategoriesManager();

    public CategoriesManager getCategoriesManager() {
        return categoriesManager;
    }
}
