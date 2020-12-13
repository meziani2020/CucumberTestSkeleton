package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HomePage {
    WebDriver driver;
    String homPageURL="https://www.techlistic.com/p/demo-selenium-practice.html";

    public HomePage(WebDriver drv){
         this.driver=drv;
    }


    public void openHomePageInBrouser(){
        driver.get(homPageURL);
    }
    public boolean isDisplayed(){
        return driver.getCurrentUrl().equals(homPageURL);

    }

    public WebElement  getTablElemet2(){
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement  mytabl= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tsc_table_s13")) );
        //WebElement mytabl= driver.findElement(By.className("tsc_table_s13"));
        return mytabl;
    }

    public WebElement  getTablElemet(){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement  mytabl= (WebElement) wait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.className("tsc_table_s13"));
            }
        });


        return mytabl;
    }


}
