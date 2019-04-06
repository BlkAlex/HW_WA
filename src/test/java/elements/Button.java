package elements;

import org.openqa.selenium.WebDriver;

public class Button extends Element {

    public Button(WebDriver driver, String name) {
        super(driver, "button", name);
    }

    public boolean isActive() {
        return webElement.isEnabled();
    }

}
