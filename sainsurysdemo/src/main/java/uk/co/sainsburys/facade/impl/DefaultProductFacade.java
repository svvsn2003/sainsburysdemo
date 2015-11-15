package uk.co.sainsburys.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import uk.co.sainsburys.dto.ProductData;
import uk.co.sainsburys.facade.ProductFacade;
import uk.co.sainsburys.service.ProductService;

public class DefaultProductFacade implements ProductFacade
{

    private static final Logger LOG = Logger.getLogger(DefaultProductFacade.class);

    private ProductService productService;

    public List<ProductData> getProducts()
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Inside get products...");
        }
        List<ProductData> productDataList = new ArrayList<ProductData>();

        List<String> productUrls = getProductUrls();
        for (String productUrl : productUrls)
        {
            productDataList.add(getProductData(productUrl));
        }

        return productDataList;
    }

    protected List<String> getProductUrls()
    {
        return getProductService().getProductUrlList();
    }

    protected ProductData getProductData(String productUrl)
    {
        return getProductService().getProductData(productUrl);
    }

    public ProductService getProductService()
    {
        return productService;
    }

    public void setProductService(ProductService productService)
    {
        this.productService = productService;
    }
}
