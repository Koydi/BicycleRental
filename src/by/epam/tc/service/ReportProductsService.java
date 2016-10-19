package by.epam.tc.service;

import by.epam.tc.bean.entity.ReportCategoryResult;
import by.epam.tc.service.exception.ServiceException;

import java.util.List;


public interface ReportProductsService {
    List<ReportCategoryResult> report() throws ServiceException;
}
