package pages;

import elements.Button;
import elements.CheckBox;
import elements.TextInput;
import elements.Uploader;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class TinkoffJobPage extends Page {
    public TinkoffJobPage(WebDriver driver) {
        super(driver);
    }

    public void setTextToFiled(String name, CharSequence... text) {
        new TextInput(driver, name).setText(text);
    }

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/career/vacancies/");
    }

    public void clickToInput(String name) {
        TextInput textInput = new TextInput(driver, name);
        textInput.click();
    }

    public void clickToCheckBox(String name) {
        new CheckBox(driver, name, "checkbox").click();
    }

    public void clickToButton(String name) {
        new Button(driver, name).click();
    }

    public void checkErrorInput(String name, String errorText) {
        assertEquals(errorText, new TextInput(driver, name).getErrorMessage());
    }

    public void checkErrorCheckbox(String name, String errorText) {
        assertEquals(errorText, new CheckBox(driver, name, "checkbox").getErrorMessage());
    }

    public void checkErrorUploader(String name, String errorText) {
        assertEquals(errorText, new Uploader(driver, name).getErrorMessage());
    }
}
