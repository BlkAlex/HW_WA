package pages;

import elements.Button;
import elements.CheckBox;
import elements.TextInput;
import elements.Uploader;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TinkoffJobPage extends Page {
    public TinkoffJobPage(WebDriver driver) {
        super(driver);
    }

    public void setTextToFiled(String name, CharSequence... text) {
        logger.info("Установка в поле \"" + name + "\" текста \"" + Arrays.toString(text) + "\"");
        new TextInput(driver, name).setText(text);

    }

    public void open() {
        driver.navigate().to("https://www.tinkoff.ru/career/vacancies/");
        logger.info("Переход по URL https://www.tinkoff.ru/career/vacancies/");
    }

    public void clickToInput(String name) {
        TextInput textInput = new TextInput(driver, name);
        textInput.click();
        logger.info("Нажатие на поле ввода \"" + name + "\"");
    }

    public void clickToCheckBox(String name) {
        new CheckBox(driver, name, "checkbox").click();
        logger.info("Нажатие на чекбокс \"" + name + "\"");
    }

    public void clickToButton(String name) {
        new Button(driver, name).click();
        logger.info("Нажатие на кнопку \"" + name + "\"");
    }

    public void checkErrorInput(String name, String errorText) {
        assertEquals(errorText, new TextInput(driver, name).getErrorMessage());
        logger.info("Проверка соответствия ошибки поля \"" + name + "\" тексту " + errorText);
    }

    public void checkErrorCheckbox(String name, String errorText) {
        assertEquals(errorText, new CheckBox(driver, name, "checkbox").getErrorMessage());
        logger.info("Проверка соответствия ошибки чекбокса \"" + name + "\" тексту " + errorText);
    }

    public void checkErrorUploader(String name, String errorText) {
        assertEquals(errorText, new Uploader(driver, name).getErrorMessage());
        logger.info("Проверка соответствия ошибки поля  \"" + name + "\" тексту " + errorText);
    }
}
