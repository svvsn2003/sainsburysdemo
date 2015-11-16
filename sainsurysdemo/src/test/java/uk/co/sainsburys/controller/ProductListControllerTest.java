package uk.co.sainsburys.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.sainsburys.dto.ProductData;
import uk.co.sainsburys.facade.ProductFacade;
import uk.co.sainsburys.util.BaseTest;

@RunWith(MockitoJUnitRunner.class)
public class ProductListControllerTest extends BaseTest{


    private ProductListController productListController;

    @Mock
    private ProductFacade productFacade;
    
  
    @Before
    public void setup() {
        super.setup();
        productListController = new ProductListController();
        productListController.setProductFacade(productFacade);
    }
    
    @After
    public void tearDown() {
        super.tearDown();
        productFacade = null;
    }
  
    @Test
    public void testGetProductsWithNull() {
        //Given
        List<ProductData> products = null;
        Mockito.when(productFacade.getProducts()).thenReturn(products);
        //When
        products = productListController.getProducts();
        //Then
        Assert.assertNull(products);
    }
    
    @Test
    public void testGetProductsWithNotNull() {
        //Given
        List<ProductData> products = getSampleProducts();
        
        Mockito.when(productFacade.getProducts()).thenReturn(products);
        //When
        products = productListController.getProducts();
        //Then
        Assert.assertNotNull(products);
        Assert.assertTrue(products.size() == 2);
    }
    
    @Test
    public void testJsonStringWithNullProducts() {
      //Given
        List<ProductData> products = null;
        Mockito.when(productFacade.getProducts()).thenReturn(products);
        //When
        String result = productListController.getJsonString();
        //Then
       Assert.assertTrue(StringUtils.isEmpty(result));
    }
    
    @Test
    public void testJsonStringWithNotNullProducts() {
      //Given
        List<ProductData> products = getSampleProducts();
        Mockito.when(productFacade.getProducts()).thenReturn(products);
        //When
        String result = productListController.getJsonString();
        //Then
       Assert.assertNotNull(result);
    }
    
    private List<ProductData> getSampleProducts(){
        List<ProductData> products = new ArrayList<ProductData>();
        ProductData prod1 = new ProductData();
        prod1.setTitle("A");
        ProductData prod2 = new ProductData();
        prod2.setTitle("B");
        products.add(prod1);
        products.add(prod2);
        return products;
    }
    
}
