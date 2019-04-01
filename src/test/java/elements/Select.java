package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Select {
    private final WebElement selectElement;

    public Select(WebDriver driver, String name) {
        selectElement = driver.findElement(By.xpath(Locators.getLocator("selector", name)));
    }


    public void clickDropDown() {
        selectElement.click();
    }

    public void selectValueByName(String name) {
        selectElement.findElement(By.xpath("." + Locators.getLocator("selector-item", name))).click();
    }

    public String getCurrentValue() {
        return selectElement.getText();//fixme
    }
}
