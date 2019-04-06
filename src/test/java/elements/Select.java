package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Select extends Element {

    public Select(WebDriver driver, String name) {
        super(driver, "selector", name);
    }


    public void selectValueByName(String name) {
        webElement.findElement(By.xpath("." + Locators.getLocator("selector-item", name))).click();
    }

    public String getCurrentValue() {
        return webElement.getText();//fixme
    }
}
