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


    @Test
    public void testVacancies_2() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("qw");
        driver.findElement(By.name("name")).sendKeys(Keys.TAB);
        assertEquals("Допустимо использовать только буквы русского алфавита и дефис",
                driver.findElement(By.xpath("//input[@name='name']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE);
        driver.findElement(By.name("name")).sendKeys("вв");
        driver.findElement(By.name("name")).sendKeys(Keys.TAB);
        assertEquals("Необходимо ввести фамилию и имя через пробел",
                driver.findElement(By.xpath("//input[@name='name']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());

        driver.findElement(By.name("birthday")).click();
        driver.findElement(By.name("birthday")).clear();
        driver.findElement(By.name("birthday")).sendKeys("14.14.1414");
        driver.findElement(By.name("birthday")).sendKeys(Keys.TAB);
        assertEquals("Поле заполнено некорректно",
                driver.findElement(By.xpath("//input[@name='birthday']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());

        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).sendKeys(" ");
        driver.findElement(By.name("city")).sendKeys(Keys.TAB);
        assertEquals("Поле обязательное",
                driver.findElement(By.xpath("//input[@name='city']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("123");
        driver.findElement(By.name("email")).sendKeys(Keys.TAB);

        assertEquals("Введите корректный адрес эл. почты",
                driver.findElement(By.xpath("//input[@name='email']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());

        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("+7(123)");
        driver.findElement(By.name("phone")).sendKeys(Keys.TAB);

        assertEquals("Номер телефона должен состоять из 10 цифр, начиная с кода оператора",
                driver.findElement(By.xpath("//input[@name='phone']/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());

//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::div[5]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перетащите файлы сюда'])[1]/following::div[5]")).sendKeys("C:\\fakepath\\1.xml");
//        assertEquals("Неверный тип документа, разрешенные форматы - pdf, doc, docx, odt",
//                driver.findElement(By.xpath("//*[@class=\"ui-upload\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'ui-text')]")).getText());

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить ещё ссылку'])[1]/following::label[1]")).click();

        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::button[1]")).click();


        assertEquals("Поле обязательное",
                driver.findElement(By.xpath("//*[@class=\"ui-checkbox__text-wrapper\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());



        // теперь обязхательность полей
        assertEquals("Поле обязательное",
                driver.findElement(By.xpath("//*[@class=\"ui-upload\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());
        assertEquals("Поле обязательное",
                driver.findElement(By.xpath("//*[@class=\"ui-checkbox-directive\"]/ancestor::*[@class='ui-form__field']//*[contains(@class,'error-message')]")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
