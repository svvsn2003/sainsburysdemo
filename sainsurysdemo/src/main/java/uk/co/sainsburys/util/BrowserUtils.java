package uk.co.sainsburys.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils
{

    private static final Logger LOG = Logger.getLogger(BrowserUtils.class);

    protected WebDriver getBrowser()
    {
        return new FirefoxDriver();
    }

    protected void waitForPageLoad(WebDriver browser)
    {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {

            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor) driver).executeScript(Constants.JS_SCRIPT_READY).equals(Constants.COMPLETE);
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(browser, 30);
        try
        {
            wait.until(expectation);
        }
        catch (Throwable error)
        {
            LOG.error(error.getMessage(), error);
        }
    }

    public WebDriver getWebPage(String url)
    {
        WebDriver browser = getBrowser();
        browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        browser.get(url);
        waitForPageLoad(browser);
        return browser;
    }

    public void closeBrowser(WebDriver browser)
    {
        browser.quit();
    }

    public WebElement getWebElement(WebDriver browser, By by)
    {
        WebElement webElement = null;
        try
        {
            webElement = browser.findElement(by);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
        }
        return webElement;
    }

}
