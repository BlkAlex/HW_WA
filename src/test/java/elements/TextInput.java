package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput {
    WebElement inputFieldElement;

    public void InputField(WebDriver driver, String locator) {
        inputFieldElement = driver.findElement(By.xpath(locator));
    }

    public void setText(CharSequence... chars) {
        inputFieldElement.sendKeys(chars);
    }

    public String getText() {
        return inputFieldElement.getAttribute("innerHTML");//fixme
    }
}
