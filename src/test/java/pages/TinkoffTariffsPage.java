package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class TinkoffTariffsPage extends Page {
    public TinkoffTariffsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeNameField(String value){
        //Заполняем форму максиально быстро, пытаясь игнорировать анимацию страницы
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    driver.findElement(By.name("name")).sendKeys(value);
                    driver.findElement(By.name("email")).click();
                    return true;
                });
    }

    public void checkPageTitle(String title){
        assertTrue(driver.getTitle().contains(title));
    }

}