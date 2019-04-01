package elements;

public class Locators {
    public static String getLocator(String type, String name) {
        switch (type) {
            case "selector":
                return String.format("//*[@class='ui-form__field'][.//*[contains(@class,'label')][contains(text(),'%s')]]", name);
            case "selector-item":
                return String.format("//div[@class='ui-dropdown-field-list__item'][.//*[@class='ui-dropdown-field-list__item-text'][text()='%s']]", name);
        }
        return "";
    }
}
