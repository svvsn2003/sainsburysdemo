package uk.co.sainsburys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import uk.co.sainsburys.dto.ProductData;
import uk.co.sainsburys.facade.ProductFacade;
import uk.co.sainsburys.util.ApplicationContextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
@ComponentScan(value = "ProductListController")
public class ProductListController {

    private static final Logger LOG = Logger.getLogger(ProductListController.class);

    private ProductFacade productFacade;

    private static Gson gson;

    static {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static void main(String[] args) {
        ProductListController productListController = (ProductListController) ApplicationContextUtils.getApplicationContext().getBean(ProductListController.class);
        String result = productListController.getJsonString();
        LOG.info(result);
    }

    protected List<ProductData> getProducts() {
        return getProductFacade().getProducts();
    }

    public String getJsonString() {
        return gson.toJson(getProducts());
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

}
