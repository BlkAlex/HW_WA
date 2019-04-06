package test;

import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.TinkoffJobPage;


public class TestVacancies extends BaseRunner {
    @Test
    public void testVacancies_1() {
        TinkoffJobPage tinkoffJobMainPage = app.tinkoffJob;
        tinkoffJobMainPage.open();

        app.getLogger().onNewStep("Нажатие на поле имя");
        tinkoffJobMainPage.clickToInput("name");
        app.getLogger().onNewStep("Нажатие на поле дата рождения");
        tinkoffJobMainPage.clickToInput("birthday");
        app.getLogger().onNewStep("Нажатие на поле город");
        tinkoffJobMainPage.clickToInput("city");
        app.getLogger().onNewStep("Нажатие на поле email");
        tinkoffJobMainPage.clickToInput("email");
        app.getLogger().onNewStep("Нажатие на поле телефон");
        tinkoffJobMainPage.clickToInput("phone");

        app.getLogger().onNewStep("Нажатие на чекбокс Согласен с");
        tinkoffJobMainPage.clickToCheckBox("согласен с");
        app.getLogger().onNewStep("Нажатие на кнопку Отправить");
        tinkoffJobMainPage.clickToButton("Отправить");


        app.getLogger().onNewStep("Поверки вывода сообщений об ошибках на всех полях");
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
