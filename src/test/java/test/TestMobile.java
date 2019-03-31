package test;

import org.junit.Test;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import pages.TinkoffTariffsPage;


public class TestMobile extends BaseRunner {
    @Test
    public void test_1() {
        TinkoffTariffsPage tinkoffTariffsPage = app.tinkoffTariffs;
        GoogleMainPage googleMainPage = app.google;
        GoogleResultPage googleResultPage = app.googleResults;
        googleMainPage.open();
        googleMainPage.setTexttoSerchField("мобайл тинькофф");
        googleMainPage.clickOnHintElement("тарифы");
        googleResultPage.clickSearchResultsByLinkContains("https://www.tinkoff.ru/mobile-operator/tariffs/");
        googleResultPage.switchToWindow("Тарифы Тинькофф Мобайла");
        tinkoffTariffsPage.checkPageTitle("Тарифы Тинькофф Мобайла");
        tinkoffTariffsPage.switchToWindow("мобайл тинькофф тарифы - Поиск в Google");
        googleResultPage.closeCurrentTab();
        googleResultPage.switchToWindow("Тарифы Тинькофф Мобайла");
        tinkoffTariffsPage.checkCurrentURL("https://www.tinkoff.ru/mobile-operator/tariffs/");
    }

    @Test
    public void testVacancies_2() {
        TinkoffTariffsPage tinkoffTariffsPage = app.tinkoffTariffs;
        tinkoffTariffsPage.open();
        tinkoffTariffsPage.selectValue("Звонки", "0 минут");
        tinkoffTariffsPage.selectValue("Интернет", "0 ГБ");
        tinkoffTariffsPage.checkCheckBox("Мессенджеры", true);
        tinkoffTariffsPage.checkCheckBox("Социальные сети", true);
        tinkoffTariffsPage.checkCheckBox("Музыка", true);
        tinkoffTariffsPage.checkCheckBox("Видео", true);
        tinkoffTariffsPage.checkCheckBox("Безлимитные СМС", true);

    }

}
