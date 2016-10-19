package by.epam.tc.bean.requests;

import by.epam.tc.bean.Request;

public class DeleteProductRequest extends Request {
    private String productName;
    private String categoryName;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {

        return categoryName;
    }

    public String getProductName() {
        return productName;
    }
}
