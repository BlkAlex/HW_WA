package elements;

import org.openqa.selenium.WebDriver;

public class TextInput extends Element {

    public TextInput(WebDriver driver, String name) {
        super(driver, "input", name);
    }

    public void setText(CharSequence... chars) {
        webElement.sendKeys(chars);
    }
}
