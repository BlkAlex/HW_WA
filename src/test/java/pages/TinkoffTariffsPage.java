package pages;

import elements.Button;
import elements.CheckBox;
import elements.Locators;
import elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class TinkoffTariffsPage extends Page {
    public TinkoffTariffsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
    }

    public void selectValue(String nameSelector, String value) {
        Select select = new Select(driver, nameSelector);
        select.clickDropDown();
        select.selectValueByName(value);
    }

    public void checkActiveButton() {
        assertTrue(new Button(driver, "Заказать ").isActive());
    }

    public void compareSummaryWithValue(String value) {
        assertEquals(value, driver.findElement(By.xpath(Locators.getLocator("summary-price", "Общая цена"))).getText());
    }

    public void compareSummaryWithValueNotEquals(String value) {
        assertNotEquals(value, driver.findElement(By.xpath(Locators.getLocator("summary-price", "Общая цена"))).getText());
    }

    public String getSummary() {
        return driver.findElement(By.xpath(Locators.getLocator("summary-price", "Общая цена"))).getText();
    }
    public void checkCheckBox(String name, boolean state) {

        CheckBox checkBox = new CheckBox(driver, name);
        if (checkBox.getState() != state) {
            checkBox.click();
        }
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public void checkPageTitle(String title){
        assertTrue(driver.getTitle().contains(title));
    }

    public void selectRegion(String value) {
        if (isRegionSelected()) {
            driver.findElement(By.xpath(Locators.getLocator("region-title", ""))).click();
        } else {
            driver.findElement(By.xpath(Locators.getLocator("region-change-button", ""))).click();
        }
        driver.findElement(By.xpath(Locators.getLocator("region-name", value))).click();
    }

    public void isRegionEqualsValue(String value) {
        assertTrue(driver.findElement(By.xpath(Locators.getLocator("region-title", ""))).getText().contains(value));
    }

    public boolean isRegionSelected() {
        return !driver.findElement(By.xpath(Locators.getLocator("region-title", ""))).getText().contains("Ваш регион");
    }
}