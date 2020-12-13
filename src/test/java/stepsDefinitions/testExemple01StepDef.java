package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utitilies.HtmlTools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testExemple01StepDef {

    WebDriver driver;
    HomePage hpage;
    HtmlTools myHtmlTools=new HtmlTools();


    List<String> structureValues=new ArrayList<>();
    boolean  exitCondition;




    @Given("user run chrome browser")
    public void  setup(){
        System.setProperty("webdriver.chrome.driver","c:\\Drivers\\chromedriver.exe");
        driver =new ChromeDriver();
    }

    @Given("user open application home page")
    public void userOpenApplicationHomePage() {
         hpage=new HomePage( driver);
         hpage.openHomePageInBrouser();
    }

    @Then("user cont the structure values of the Table")
    public void userContTheStructureValuesOfTheTable() {
        WebElement tableElem=hpage.getTablElemet();
        structureValues=myHtmlTools.getTableColumnValues(tableElem,1);
        System.out.println(structureValues.size());
    }
/*
*
       System.out.println("BEFOR WAIT");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("POST WAIT");
        WebElement tableElem=hpage.getTablElemet();
        structureValues=myHtmlTools.getTable1stColumnValues(tableElem);

        System.out.println(structureValues.size());
*
* */

    @And("the number of defferent  values need to be fore")
    public void theNumberOfDefferentValuesNeedToBe() {

        if(this.structureValues.size()==4){
            exitCondition=true;
        }else{
            exitCondition=false;
        }
        Assert.assertTrue(exitCondition);

        //Assert.assertTrue(this.structureValues.size()==4);

    }

    @Then("the Home page sould be displayed")
    public void theHomePageSoudBeDisplayed() {
        Assert.assertTrue( hpage.isDisplayed());
    }

    @Then("user print tabel data")
    public void userPrintTabelData() {
        WebElement table=hpage.getTablElemet();
        myHtmlTools.printTableTbodyData(table);
        Assert.assertTrue( true);
    }

    @Then("verify that Structure {string} has {string} as height")
    public void verifyThatStructureHasAsHeight(String str, String h) {
        // th containing structure name
        WebElement table=hpage.getTablElemet();
        WebElement th=table.findElement(By.ById.xpath("tbody/tr/th [contains(text(), '"+str+"')]"));
        // find 3rd td indexed by 2  in th parent
        WebElement td3=th.findElement(By.xpath("..")).findElements(By.tagName("td")).get(2);
        exitCondition=  h.equalsIgnoreCase(td3.getText());
        Assert.assertTrue(exitCondition);
    }

    @Then("Verify that sixth row has two col")
    public void verifyThat6ThRowHasTwoCol() {
        WebElement table=hpage.getTablElemet();
        int  tfootChildsNBR=table.findElement(By.tagName("tfoot")).findElements(By.tagName("tr")).get(0).findElements(By.xpath("./child::*")).size();
        exitCondition=tfootChildsNBR==2;
        Assert.assertTrue(exitCondition);
    }
}
