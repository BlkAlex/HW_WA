import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestVacancies {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", "C:/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testVacancies_1() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::div[5]")).click();
        driver.findElement(By.name("socialLink0")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::button[1]")).click();
    }

    String getXpathByNameOfWebElement(String name){
        String xpath = "";
        switch (name){
            case "name" :
            case "birthday" :
            case "city" :
            case "email" :
            case "phone" :
                return String.format("//input[@name='%s']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]",name);
            case "ui-checkbox__text-wrapper" :
            case "ui-upload" :
                return  String.format("//*[@class=\"%s\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]",name);
        }
        return xpath;
    }
    @Test
    public void testVacancies_2() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        WebElement nameField = driver.findElement(By.name("name"));
        WebElement birthdayField = driver.findElement(By.name("birthday"));
        WebElement cityField = driver.findElement(By.name("city"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement phoneElement = driver.findElement(By.name("phone"));

        nameField.sendKeys("qq");
        nameField.sendKeys(Keys.TAB);
        assertEquals("Допустимо использовать только буквы русского алфавита и дефис",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("name"))).getText());

        nameField.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        nameField.sendKeys("вв");
        nameField.sendKeys(Keys.TAB);
        assertEquals("Необходимо ввести фамилию и имя через пробел",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("name"))).getText());

        birthdayField.sendKeys("14.14.1414");
        birthdayField.sendKeys(Keys.TAB);
        assertEquals("Поле заполнено некорректно",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("birthday"))).getText());

        cityField.sendKeys(" ");
        cityField.sendKeys(Keys.TAB);
        assertEquals("Поле обязательное",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("city"))).getText());

        emailField.sendKeys("123");
        emailField.sendKeys(Keys.TAB);

        assertEquals("Введите корректный адрес эл. почты",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("email"))).getText());

        phoneElement.sendKeys("+7(123)");
        phoneElement.sendKeys(Keys.TAB);

        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("phone"))).getText());
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::div[5]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::div[5]")).sendKeys("C:\\fakepath\\1.xml");
//        assertEquals("Неверный тип документа, разрешенные форматы - pdf, doc, docx, odt",
//                driver.findElement(By.xpath("//*[@class=\"ui-upload\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'ui-text')]")).getText());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить ещё ссылку'])[1]/following::label[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::button[1]")).click();

        assertEquals("Поле обязательное",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("ui-checkbox__text-wrapper"))).getText());

        assertEquals("Поле обязательное",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("ui-upload"))).getText());
        assertEquals("Поле обязательное",
                driver.findElement(By.xpath(getXpathByNameOfWebElement("ui-checkbox__text-wrapper"))).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
