package test;

import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.TinkoffJobPage;


public class TestVacancies extends BaseRunner {
    @Test
    public void testVacancies_1() {
        TinkoffJobPage tinkoffJobMainPage = app.tinkoffJob;
        tinkoffJobMainPage.open();

        tinkoffJobMainPage.clickToInput("name");
        tinkoffJobMainPage.clickToInput("birthday");
        tinkoffJobMainPage.clickToInput("city");
        tinkoffJobMainPage.clickToInput("email");
        tinkoffJobMainPage.clickToInput("phone");

        tinkoffJobMainPage.clickToCheckBox("согласен с");
        tinkoffJobMainPage.clickToButton("Отправить");
        tinkoffJobMainPage.checkErrorInput("name", "Поле обязательное");
        tinkoffJobMainPage.checkErrorInput("birthday", "Поле обязательное");
        tinkoffJobMainPage.checkErrorInput("city", "Поле обязательное");
        tinkoffJobMainPage.checkErrorInput("email", "Поле обязательное");
        tinkoffJobMainPage.checkErrorCheckbox("согласен с", "Поле обязательное");
        tinkoffJobMainPage.checkErrorUploader("загрузите", "Поле обязательное");
    }

    @Test
    public void testVacancies_2() {
        TinkoffJobPage tinkoffJobMainPage = app.tinkoffJob;
        tinkoffJobMainPage.open();
        tinkoffJobMainPage.setTextToFiled("name", "qq");
        tinkoffJobMainPage.setTextToFiled("name", Keys.TAB);
        tinkoffJobMainPage.checkErrorInput("name", "Допустимо использовать только буквы русского алфавита и дефис");
        tinkoffJobMainPage.setTextToFiled("name", Keys.BACK_SPACE, Keys.BACK_SPACE);

        tinkoffJobMainPage.setTextToFiled("name", "вв");
        tinkoffJobMainPage.setTextToFiled("name", Keys.TAB);
        tinkoffJobMainPage.checkErrorInput("name", "Необходимо ввести фамилию и имя через пробел");

        tinkoffJobMainPage.setTextToFiled("birthday", "14.14.1414");
        tinkoffJobMainPage.setTextToFiled("birthday", Keys.TAB);
        tinkoffJobMainPage.checkErrorInput("birthday", "Поле заполнено некорректно");

        tinkoffJobMainPage.setTextToFiled("city", " ");
        tinkoffJobMainPage.setTextToFiled("city", Keys.TAB);
        tinkoffJobMainPage.checkErrorInput("city", "Поле обязательное");

        tinkoffJobMainPage.setTextToFiled("email", "123");
        tinkoffJobMainPage.setTextToFiled("email", Keys.TAB);
        tinkoffJobMainPage.checkErrorInput("email", "Введите корректный адрес эл. почты");

        tinkoffJobMainPage.setTextToFiled("phone", "7(123)");
        tinkoffJobMainPage.setTextToFiled("phone", Keys.TAB);
        tinkoffJobMainPage.checkErrorInput("phone", "Номер телефона должен состоять из 10 цифр, начиная с кода оператора");

        tinkoffJobMainPage.clickToCheckBox("согласен с");
        tinkoffJobMainPage.clickToButton("Отправить");
        tinkoffJobMainPage.checkErrorCheckbox("согласен с", "Поле обязательное");
        tinkoffJobMainPage.checkErrorUploader("загрузите", "Поле обязательное");

    }

}
