package pages;

import elements.Button;
import elements.CheckBox;
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
        assertTrue(new Button(driver, "//button[contains(@class,'Button')]").isActive());
    }

    public void compareSummaryWithValue(String value) {
        assertEquals(value, driver.findElement(By.xpath("//h3[contains(@class,'mobileOperatorProductCalculator')][contains(text(),'Общая цена')]")).getText());
    }

    public void compareSummaryWithValueNotEquals(String value) {
        assertNotEquals(value, driver.findElement(By.xpath("//h3[contains(@class,'mobileOperatorProductCalculator')][contains(text(),'Общая цена')]")).getText());
    }

    public String getSummary() {
        return driver.findElement(By.xpath("//h3[contains(@class,'mobileOperatorProductCalculator')][contains(text(),'Общая цена')]")).getText();
    }
    public void checkCheckBox(String name, boolean state) {
        CheckBox checkBox = new CheckBox(driver, String.format("//div[contains(@class,'CheckboxWithDescription')][.//*[contains(text(),'%s')]]//div[contains(@class,'container')]", name));
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
            driver.findElement(By.xpath("//div[contains(@class,'MvnoRegionConfirmation__title')]")).click();
        } else {
            driver.findElement(By.xpath("//span[contains(@class,'MvnoRegionConfirmation')][contains(text(),'Нет, изменить')]")).click();
        }
        driver.findElement(By.xpath(String.format("//div[contains(@class,'MobileOperatorRegionsPopup__region')]//*[contains(text(),'%s')]", value))).click();
    }

    public void isRegionEqualsValue(String value) {
        assertTrue(driver.findElement(By.xpath("//div[contains(@class,'MvnoRegionConfirmation__title')]")).getText().contains(value));
    }

    public boolean isRegionSelected() {
        return !driver.findElement(By.xpath("//div[contains(@class,'MvnoRegionConfirmation__title')]")).getText().contains("Ваш регион");
    }
}