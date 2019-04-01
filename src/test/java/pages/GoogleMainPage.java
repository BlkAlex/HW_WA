package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends Page {
    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    private WebElement searchField;


    public void open() {
        driver.navigate().to("https://www.google.ru/");
        isLoadedByTitleContains("Google");
    }

    public void clickOnHintElement(String hintText){
        driver.findElement(By.xpath(String.format("//li[./*[@class=\"suggestions-inner-container\"][contains(.,'%s %s')]]",searchField.getAttribute("value"),hintText))).click();
    }
    public void setTexttoSerchField(String text){
        searchField.sendKeys(text);
    }


    public boolean isLoadedByTitleContains(String substring) {
        wait.until(d -> d.getTitle().contains(substring));
        return true;
    }

}
