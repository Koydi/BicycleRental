package by.epam.tc.bean;

import by.epam.tc.bean.entity.ReportCategoryResult;

import java.util.List;

public class Response {
    private String errorMessage;
    private boolean errorStatus;
    private String message;
    private List<ReportCategoryResult> reportCategoryResult = null;

    public void setReportCategoryResult(List<ReportCategoryResult> reportCategoryResult) {
        this.reportCategoryResult = reportCategoryResult;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {

        return errorMessage;
    }

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        if (reportCategoryResult != null) {
            for (ReportCategoryResult result : reportCategoryResult) {
                stringBuilder.append("\nCategory name : ");
                stringBuilder.append(result.getCategoryName());
                stringBuilder.append(" 4| Number : ");
                stringBuilder.append(result.getNumberProducts());
                stringBuilder.append(" | Max cost : ");
                stringBuilder.append(result.getMaxCost());
                stringBuilder.append(" | Min cost : ");
                stringBuilder.append(result.getMinCost());
            }
            message = stringBuilder.toString();
        }
        return message;
    }
}
