package uk.co.sainsburys.service;

import java.util.List;

import uk.co.sainsburys.dto.ProductData;

public interface ProductService
{

    public List<String> getProductUrlList();

    public ProductData getProductData(String productUrl);

}
