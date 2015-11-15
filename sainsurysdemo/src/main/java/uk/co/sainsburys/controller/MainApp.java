package uk.co.sainsburys.controller;

import uk.co.sainsburys.util.ApplicationContextUtils;


public class MainApp
{

    public static void main(String[] args)
    {
        ProductListController productListController = (ProductListController) ApplicationContextUtils.getApplicationContext().getBean(ProductListController.class);
        String result = productListController.getJsonString();
        System.out.println(result);

    }

}
