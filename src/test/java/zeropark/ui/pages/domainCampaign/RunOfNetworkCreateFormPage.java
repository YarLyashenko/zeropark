package zeropark.ui.pages.domainCampaign;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import zeropark.ui.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class RunOfNetworkCreateFormPage extends BasePage {

    public RunOfNetworkCreateFormPage save() {
        $("#btn-save").click();
        return this;
    }

    public RunOfNetworkCreateFormPage withName(String name) {
        $(By.name("name")).setValue(name);
        return this;
    }

    public RunOfNetworkCreateFormPage withCountry(String countryName) {
        $(By.name("geoCountry")).selectOptionContainingText(countryName);
        return this;
    }

    public RunOfNetworkCreateFormPage withBid(String bid) {
        SelenideElement bidField = $(By.name("bid"));
        bidField.click();
        bidField.setValue(bid);
        return this;
    }

    public RunOfNetworkCreateFormPage isAdult(boolean adult) {
        if (adult) {
            $(By.cssSelector("input[value='ADULT']")).setSelected(true);
        } else {
            $(By.cssSelector("input[value='NON_ADULT']")).setSelected(true);
        }
        return this;
    }

    public RunOfNetworkCreateFormPage withDestinationUrl(String destinationUrl) {
        $(By.name("destinationUrl")).setValue(destinationUrl);
        return this;
    }

    public SelenideElement getCampaignNameValidationMessage() {
        return $(By.id("name.errors"));
    }

    public SelenideElement getCountryValidationMessage() {
        return $(By.id("geoCountry.errors"));
    }

    public SelenideElement getBidValidationMessage() {
        return $(By.id("bid.errors"));
    }

    public SelenideElement getAdultFiltersValidationMessage() {
        return $(By.id("adultFiltersValidation.errors"));
    }

    public SelenideElement getDestinationUrlValidationMessage() {
        return $(By.id("destinationUrl.errors"));
    }
}
