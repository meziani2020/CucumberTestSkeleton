package utitilies;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HtmlTools {



    public List<WebElement> getTableHeaderElements(WebElement tableWE) {
        List<WebElement> headcolumns;
        List<String> Values;

          WebElement  Thead =tableWE.findElement(By.tagName("thead"));
          WebElement  TheadTr=Thead.findElement(By.tagName("tr"));

          headcolumns= TheadTr.findElements(By.tagName("tr"));

         return headcolumns;
    }

    public List<String> getTable1stColumnValues(WebElement tableWE) {
        WebElement  TbodyElement  ;
        List<WebElement> TrList; //Lines
        WebElement  trElement;
        WebElement  thElement;
        String txtValue;
        List<String> values= new ArrayList<>();
        TbodyElement =tableWE.findElement(By.tagName("tbody"));
        TrList=TbodyElement.findElements(By.tagName("tr"));

        for(int i=0;i< TrList.size();i++){
            trElement=TrList.get(i);
            List<WebElement> childs = trElement.findElements(By.xpath("./child::*"));
            for (WebElement e  : childs)
            {
               // System.out.println(e.getTagName());
            }
            thElement=childs.get(0);
            //thElement=trElement.findElement(By.tagName("th"));
            txtValue=thElement.getText();
            System.out.println("i="+i+",   value=("+txtValue+")");
            values.add(txtValue);
        }
        return values;
        }



    public List<String>  getTableColumnValues(WebElement tableWE, int columIndex) {
        WebElement  TbodyElement  ;
        List<WebElement> TrList; //Lines
        WebElement  trElement;
        WebElement  caseElement;
        String txtValue;
        List<String> values= new ArrayList<>();
        TbodyElement =tableWE.findElement(By.tagName("tbody"));
        TrList=TbodyElement.findElements(By.tagName("tr"));

        for(int i=0;i< TrList.size();i++){
            trElement=TrList.get(i);
            List<WebElement> childs = trElement.findElements(By.xpath("./child::*"));
            caseElement=childs.get(columIndex);
            //thElement=trElement.findElement(By.tagName("th"));
            txtValue=caseElement.getText();
            System.out.println("i="+i+",   value=("+txtValue+")");
            values.add(txtValue);
        }
        return values;
    }


    public List<String>  getTableTbodyRowValues(WebElement tableWE, int rowIndex) {
        WebElement  TbodyElement  ;
        List<WebElement> TrList; //Lines
        WebElement  trElement;
        WebElement  caseElement;
        String txtValue;
        List<String> values= new ArrayList<>();
        TbodyElement =tableWE.findElement(By.tagName("tbody"));
        TrList=TbodyElement.findElements(By.tagName("tr"));
        trElement=TrList.get(rowIndex);
        List<WebElement> childs = trElement.findElements(By.xpath("./child::*"));
        for(int i=0;i< childs.size();i++){
            caseElement=childs.get(i);
            txtValue=caseElement.getText();
            values.add(txtValue);
        }
        return values;
    }



    public  void printTableTbodyData(WebElement tableWE) {
        List<String> cases=new ArrayList();
        int rowNbr=tableWE.findElement(By.tagName("tbody")).findElements(By.tagName("tr")).size();
        for(int i =0;i<rowNbr;i++){
            cases=this.getTableTbodyRowValues(tableWE,i);
            for(int j=0;j<cases.size();j++){
                System.out.print( cases.get(j)+",  ");
            }
            System.out.println();
        }

    }












}
