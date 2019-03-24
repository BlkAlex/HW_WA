package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class TinkoffJobPage {
    public TinkoffJobPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void setTextToFiled(String filed, CharSequence... text) {
        driver.findElement(By.name(filed)).sendKeys(text);
    }

    WebDriver driver;
    WebDriverWait wait;

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/career/vacancies/");
        //isLoadedByTitleContains("Google");
    }

    public void clickToInput(String name) {
        driver.findElement(By.xpath(getLocator("input",name))).click();
    }

    public void clickToCheckBox(String name) {
        driver.findElement(By.xpath(getLocator("checkbox",name))).click();
    }

    public void clickToButton(String name) {
        driver.findElement(By.xpath(getLocator("button",name))).click();
    }

    public void checkErrorInput(String field, String errorText) {
        assertEquals(errorText, driver.findElement(By.xpath(getXpathByNameErrorOfWebElement("input",field))).getText());
    }

    public void checkErrorCheckbox(String field, String errorText) {
        assertEquals(errorText, driver.findElement(By.xpath(getXpathByNameErrorOfWebElement("checkbox",field))).getText());
    }

    public void checkErrorUploader(String field, String errorText) {
        assertEquals(errorText, driver.findElement(By.xpath(getXpathByNameErrorOfWebElement("uploader",field))).getText());
    }

    String getXpathByNameErrorOfWebElement(String type, String name) {
        return getLocator(type, name) + "/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]";
//        String xpath = "";
//        switch (name){
//            case "name" :
//            case "birthday" :
//            case "city" :
//            case "email" :
//            case "phone" :
//                return String.format("//input[@name='%s']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]",name);
//            case "ui-checkbox__text-wrapper" :
//            case "ui-upload" :
//                return  String.format("//*[@class=\"%s\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]",name);
//        }
//        return xpath;
    }

    private String getLocator(String type, String name) {
        switch (type) {
            case "input":
                return String.format("//*[@name='%s']", name);
            case "checkbox":
                return String.format("//label[contains(@class,'ui-checkbox')][//*[contains(text(),'%s')]]", name);
            case "button":
                return String.format("//button[//*[contains(text(),'%s')]]", name);
            case "uploader":
                return String.format("//div[@class='ui-upload'][//*[contains(text(),'%s')]]", name);
        }
        throw new RuntimeException(String.format("Неизвестный тип поля : %s", type));
    }
}