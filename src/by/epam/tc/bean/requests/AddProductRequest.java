package by.epam.tc.bean.requests;

import by.epam.tc.bean.Request;

public class AddProductRequest extends Request {
    private String productName;
    private String categoryName;
    private String number;
    private String cost;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCost() {
        return cost;
    }

    public String getProductName() {
        return productName;
    }
}
