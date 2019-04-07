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
        logger.info("Переход по URL https://www.tinkoff.ru/mobile-operator/tariffs/");
    }

    public void selectValue(String nameSelector, String value) {
        Select select = new Select(driver, nameSelector);
        select.click();
        select.selectValueByName(value);
        logger.info("Выбор из селектора  \"" + nameSelector + "\" элемента с тестом " + value);
    }

    public void checkActiveButton() {
        assertTrue(new Button(driver, "Заказать ").isActive());
        logger.info("Проверка кнопки  \"заказать\" на доступность");
    }

    public void compareSummaryWithValue(String value) {
        assertEquals(value, driver.findElement(By.xpath(Locators.getLocator("summary-price", "Общая цена"))).getText());
        logger.info("Проверка соответствия общей цены  \"" + value + "\"с суммой в поле \"общая цена\"");
    }

    public void compareSummaryWithValueNotEquals(String value) {
        assertNotEquals(value, driver.findElement(By.xpath(Locators.getLocator("summary-price", "Общая цена"))).getText());
        logger.info("Проверка несоответствия общей цены  \"" + value + "\"с суммой в поле \"общая цена\"");
    }

    public String getSummary() {
        return driver.findElement(By.xpath(Locators.getLocator("summary-price", "Общая цена"))).getText();
    }

    public void checkCheckBox(String name, boolean state) {

        CheckBox checkBox = new CheckBox(driver, name, "checkbox-with-description");
        if (checkBox.getState() != state) {
            checkBox.click();
            logger.info("Нажатие на чекбокс \"" + name + "\"");
        }
    }

    public void reloadPage() {
        driver.navigate().refresh();
        logger.info("Обновление страницы");
    }

    public void checkPageTitle(String title) {
        assertTrue(driver.getTitle().contains(title));
        logger.info("Проверка соответствия заголовка страницы значению \"" + title + "\"");
    }

    public void selectRegion(String value) {
        if (isRegionSelected()) {
            driver.findElement(By.xpath(Locators.getLocator("region-title", ""))).click();
        } else {
            driver.findElement(By.xpath(Locators.getLocator("region-change-button", ""))).click();
        }
        logger.info("Переход к списку регионов");
        driver.findElement(By.xpath(Locators.getLocator("region-name", value))).click();
        logger.info("Выбор региона " + value);
    }

    public void isRegionEqualsValue(String value) {
        assertTrue(driver.findElement(By.xpath(Locators.getLocator("region-title", ""))).getText().contains(value));
        logger.info("Проверка соответствия региона значению \"" + value + "\"");
    }

    private boolean isRegionSelected() {
        logger.info("Проверка выбран ли регион");
        return !driver.findElement(By.xpath(Locators.getLocator("region-title", ""))).getText().contains("Ваш регион");
    }
}