package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox extends Element {

    public boolean getState() {
        return webElement.findElement(By.xpath(".//input")).getAttribute("checked") != null;
    }

    public CheckBox(WebDriver driver, String name, String type) {
        super(driver, type, name);
    }

}
