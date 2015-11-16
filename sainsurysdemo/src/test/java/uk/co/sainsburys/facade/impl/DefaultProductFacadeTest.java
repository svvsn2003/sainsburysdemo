package uk.co.sainsburys.facade.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.sainsburys.dto.ProductData;
import uk.co.sainsburys.service.ProductService;
import uk.co.sainsburys.util.BaseTest;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductFacadeTest extends BaseTest
{
    private DefaultProductFacade defaultProductFacade;
    
    @Mock
    private ProductService productService;
    
  
    @Before
    public void setup() {
        super.setup();
        defaultProductFacade = new DefaultProductFacade();
        defaultProductFacade.setProductService(productService);
    }
    
    @After
    public void tearDown() {
        super.tearDown();
        productService = null;
    }
    
    @Test
    public void testGetProductsWithNullProducts() {
        //Given
        List<String> productUrls = new ArrayList<>();
        Mockito.when(productService.getProductUrlList()).thenReturn(productUrls);
        //When
        List<ProductData> products = defaultProductFacade.getProducts();
        //Then
        Assert.assertTrue(CollectionUtils.isEmpty(products));
    }
    
    @Test
    public void testGetProductsWithNotNull() {
        //Given
        String prodUrl = "http://sainsburys.com/p/001";
        List<String> productUrls = new ArrayList<String>();
        productUrls.add(prodUrl);
        ProductData product = Mockito.mock(ProductData.class);
        Mockito.when(productService.getProductUrlList()).thenReturn(productUrls);
        Mockito.when(productService.getProductData(prodUrl)).thenReturn(product);
        //When
        List<ProductData> products = defaultProductFacade.getProducts();
        //Then
        Assert.assertNotNull(products);
        Assert.assertTrue(products.size() == 1);
    }
}
