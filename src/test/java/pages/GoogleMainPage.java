package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class GoogleMainPage extends Page {
    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    public WebElement searchField;


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
    public void openSearchResultsPageByRequest(String request) {
        searchField.sendKeys(request);

        //ожидание, игнорирующее StaleElementReferenceException
        wait
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Что-то пошло не так...")
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    //список поисковой выдачи
                    By listItems = By.xpath("//ul[@role='listbox']/li[@role='presentation' and .//*[@role='option']]");
                    List<WebElement> elements = driver.findElements(listItems);
                    for (WebElement el : elements) {
                        System.out.println(el.getText());
                        //из списка вариантов дожиаемся появления нужного, кликаем
                        if (el.getText().equals(request.toLowerCase())) el.click();
                        break;
                    }
                    //Ожидание появления заголовка
                    return d.getTitle().contains(request.toLowerCase() + " - Поиск в Google");
                });
    }

    public boolean isLoadedByTitleContains(String substring) {
        wait.until(d -> d.getTitle().contains(substring));
        return true;
    }

}
