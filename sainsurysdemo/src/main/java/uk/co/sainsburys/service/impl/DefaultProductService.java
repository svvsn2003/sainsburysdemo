package uk.co.sainsburys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.co.sainsburys.dto.ProductData;
import uk.co.sainsburys.service.ProductService;
import uk.co.sainsburys.util.BrowserUtils;
import uk.co.sainsburys.util.Constants;

public class DefaultProductService implements ProductService
{

    private static final Logger LOG = Logger.getLogger(DefaultProductService.class);

    private BrowserUtils browserUtils;

    @Override
    public List<String> getProductUrlList()
    {
        List<String> productUrls = new ArrayList<String>();

        WebDriver productListPage = getBrowserUtils().getWebPage(Constants.PRODUCT_LIST_PAGE_URL);

        List<WebElement> productList = productListPage.findElements(By.xpath(".//*[@id='productLister']/ul/li"));
        if (CollectionUtils.isNotEmpty(productList))
        {
            for (WebElement product : productList)
            {
                WebElement anchorTag = product.findElement(By.xpath(".//*[@class='productInfo']/h3/a"));
                productUrls.add(anchorTag.getAttribute("href"));
            }
        }
        closeBrowser(productListPage);
        LOG.info("No of products found = " + productUrls.size());
        return productUrls;
    }

    @Override
    public ProductData getProductData(String productUrl)
    {
        LOG.info("Getting product data for product url=" + productUrl);
        ProductData productData = createProductData();
        WebDriver productPage = getBrowserUtils().getWebPage(productUrl);
        WebElement productNameElement = getBrowserUtils().getWebElement(productPage, By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[1]/h1"));
        if (productNameElement != null)
        {
            productData.setTitle(productNameElement.getText());
        }
        WebElement sizeElement = getBrowserUtils().getWebElement(productPage, By.xpath(".//*[@id='information']/productcontent/htmlcontent/div[3]/p"));
        if (sizeElement != null)
            productData.setSize(sizeElement.getText());

        WebElement priceElement = getBrowserUtils().getWebElement(productPage, By.className("pricePerUnit"));
        if (priceElement != null)
            productData.setPrice(priceElement.getText());

        WebElement descriptionElement = getBrowserUtils().getWebElement(productPage, By.xpath(".//*[@id='information']/productcontent/htmlcontent/div[1]/p[1]"));
        if (descriptionElement != null)
            productData.setDescription(descriptionElement.getText());
       
        closeBrowser(productPage);
        return productData;
    }

    protected void closeBrowser(WebDriver browser)
    {
        getBrowserUtils().closeBrowser(browser);
    }

    public BrowserUtils getBrowserUtils()
    {
        return browserUtils;
    }

    protected ProductData createProductData()
    {
        return new ProductData();
    }

    public void setBrowserUtils(BrowserUtils browserUtils)
    {
        this.browserUtils = browserUtils;
    }

}
