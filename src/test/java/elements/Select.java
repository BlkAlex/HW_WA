package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Select {
    WebElement selectElement;

    public void Select(WebDriver driver, String locator) {
        selectElement = driver.findElement(By.xpath(locator));
    }

    public void selectValueByName(String name) {
        //todo
    }

    public String getCurrentValue() {
        return selectElement.getText();//fixme
    }
}
