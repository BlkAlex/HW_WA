package elements;

import org.openqa.selenium.WebDriver;

public class Uploader extends Element {

    public Uploader(WebDriver driver, String name) {
        super(driver, "uploader", name);
    }

    public void setText(CharSequence... chars) {
        webElement.sendKeys(chars);
    }

    public String getText() {
        return webElement.getAttribute("innerHTML");
    }
}
