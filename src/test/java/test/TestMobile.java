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
    public void test_2() {
        TinkoffTariffsPage tinkoffTariffsPage = app.tinkoffTariffs;
        tinkoffTariffsPage.open();
        tinkoffTariffsPage.selectRegion("Москва");
        tinkoffTariffsPage.reloadPage();
        tinkoffTariffsPage.isRegionEqualsValue("Москва");
        String sumMoscow = tinkoffTariffsPage.getSummary();
        tinkoffTariffsPage.selectRegion("Краснодар");
        tinkoffTariffsPage.compareSummaryWithValueNotEquals(sumMoscow);
        tinkoffTariffsPage.selectValue("Звонки", "Безлимитные минуты");
        tinkoffTariffsPage.selectValue("Интернет", "Безлимитный интернет");
        tinkoffTariffsPage.checkCheckBox("Безлимитные СМС", true);
        tinkoffTariffsPage.checkCheckBox("Режим модема", true);
        String sumKrasn = tinkoffTariffsPage.getSummary();

        tinkoffTariffsPage.selectRegion("Москва");
        tinkoffTariffsPage.selectValue("Звонки", "Безлимитные минуты");
        tinkoffTariffsPage.selectValue("Интернет", "Безлимитный интернет");
        tinkoffTariffsPage.checkCheckBox("Безлимитные СМС", true);
        tinkoffTariffsPage.checkCheckBox("Режим модема", true);
        tinkoffTariffsPage.compareSummaryWithValue(sumKrasn);

    }


    @Test
    public void test_3() {
        TinkoffTariffsPage tinkoffTariffsPage = app.tinkoffTariffs;
        tinkoffTariffsPage.open();
        tinkoffTariffsPage.selectValue("Звонки", "0 минут");
        tinkoffTariffsPage.selectValue("Интернет", "0 ГБ");
        tinkoffTariffsPage.checkCheckBox("Мессенджеры", false);
        tinkoffTariffsPage.checkCheckBox("Социальные сети", false);
        tinkoffTariffsPage.checkCheckBox("Музыка", false);
        tinkoffTariffsPage.checkCheckBox("Видео", false);
        tinkoffTariffsPage.checkCheckBox("Безлимитные СМС", false);
        tinkoffTariffsPage.compareSummaryWithValue("Общая цена: 0 \u20BD");
        tinkoffTariffsPage.checkActiveButton();
    }

}
