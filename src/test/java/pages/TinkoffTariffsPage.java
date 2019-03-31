package pages;

import elements.Button;
import elements.CheckBox;
import elements.Select;
import elements.TextInput;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TinkoffTariffsPage extends Page {
    public TinkoffTariffsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    Select internetSelect;
    Select callsSelect;
    Select nationalitySelect;
    CheckBox messengersCheckBox;
    CheckBox socialNetsCheckBox;
    CheckBox musicCheckBox;
    CheckBox videoCheckBox;
    CheckBox unlimitedSmsCheckBox;
    CheckBox modemRejimCheckBox;
    CheckBox iAgreeCheckBox;
    TextInput fioTextInput;
    TextInput phoneTextInput;
    TextInput emailTextInput;

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
    }

    public void selectValue(String nameSelector, String value) {
        driver.findElement(By.xpath(String.format("//*[@class='ui-form__field'][.//*[contains(@class,'label')][contains(text(),'%s')]]", nameSelector))).click();
        WebElement element = driver.findElement(By.xpath(String.format
                ("//*[@class='ui-form__field'][.//*[contains(@class,'label')][contains(text(),'%s')]]//div[@class='ui-dropdown-field-list__item'][.//*[@class='ui-dropdown-field-list__item-text'][text()='%s']]"
                        , nameSelector, value)));
        element.click();
    }

    public void checkActiveButton() {
        assertTrue(new Button(driver, "//button[contains(@class,'Button')]").isActive());
    }

    public void compareSummaryWithValue(String value) {
        assertEquals("Общая цена: " + value + " \u20BD", driver.findElement(By.xpath("//h3[contains(@class,'mobileOperatorProductCalculator')][contains(text(),'Общая цена')]")).getText());
    }
    public void checkCheckBox(String name, boolean state) {
        CheckBox checkBox = new CheckBox(driver, String.format("//div[contains(@class,'CheckboxWithDescription')][.//*[contains(text(),'%s')]]//div[contains(@class,'container')]", name));
        if (checkBox.getState() != state) {
            checkBox.setState(state);
        }
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