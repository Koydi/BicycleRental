package by.epam.tc.bean.entity;

public class ReportCategoryResult {
    private int numberProducts;
    private int minCost;
    private int maxCost;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String ctegoryName) {
        this.categoryName = ctegoryName;
    }

    public void setMaxCost(int maxCost) {
        this.maxCost = maxCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    public void setNumberProducts(int numberProducts) {
        this.numberProducts = numberProducts;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public int getMinCost() {
        return minCost;
    }

    public int getNumberProducts() {
        return numberProducts;
    }
}
