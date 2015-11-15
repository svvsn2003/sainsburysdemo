package uk.co.sainsburys.facade;

import java.util.List;

import uk.co.sainsburys.dto.ProductData;


public interface ProductFacade
{
    public List<ProductData> getProducts();
}
