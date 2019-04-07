package elements;

public class Locators {
    public static String getLocator(String type, String name) {
        switch (type) {
            case "selector":
                return String.format("//*[@class='ui-form__field'][.//*[contains(@class,'label')][contains(text(),'%s')]]", name);
            case "selector-item":
                return String.format("//div[@class='ui-dropdown-field-list__item'][.//*[@class='ui-dropdown-field-list__item-text'][text()='%s']]", name);
            case "checkbox":
                return String.format("//label[contains(@class,'ui-checkbox')][//*[contains(text(),'%s')]]", name);
            case "checkbox-with-description":
                return String.format("//div[contains(@class,'CheckboxWithDescription')][.//*[contains(text(),'%s')]]//div[contains(@class,'container')]", name);
            case "button":
                return String.format("//button[contains(@class,'Button')][.//*[contains(text(),'%s')]]", name);
            case "summary-price":
                return String.format("//h3[contains(@class,'mobileOperatorProductCalculator')][contains(text(),'%s')]", name);
            case "region-title":
                return "//div[contains(@class,'MvnoRegionConfirmation__title')]";
            case "region-name":
                return String.format("//div[contains(@class,'MobileOperatorRegionsPopup__region')]//*[contains(text(),'%s')]", name);
            case "region-change-button":
                return "//span[contains(@class,'MvnoRegionConfirmation')][contains(text(),'Нет, изменить')]";
            case "input":
                return String.format("//*[@name='%s']", name);
            case "uploader":
                return String.format("//div[@class='ui-upload'][//*[contains(text(),'%s')]]", name);
        }
        throw new RuntimeException(String.format("Неизвестный тип поля : %s", type));
    }
}
