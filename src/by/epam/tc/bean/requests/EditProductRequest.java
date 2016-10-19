package by.epam.tc.bean.requests;

public class EditProductRequest extends AddProductRequest {
    private String changedProductName;
    private String changedProductCategoryName;

    public void setChangedProductCategoryName(String changedProductCategoryName) {
        this.changedProductCategoryName = changedProductCategoryName;
    }

    public void setChangedProductName(String changedProductName) {
        this.changedProductName = changedProductName;
    }

    public String getChangedProductCategoryName() {

        return changedProductCategoryName;
    }

    public String getChangedProductName() {
        return changedProductName;
    }
}
