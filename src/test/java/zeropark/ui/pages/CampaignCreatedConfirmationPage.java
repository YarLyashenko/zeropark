package zeropark.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CampaignCreatedConfirmationPage extends BasePage {
    public SelenideElement getHeader() {
        return $("div.bidding-page-header h1");
    }

    public SelenideElement getCampaignName() {
        return $("#campaignName");
    }

    public SelenideElement getTrafficType() {
        return $("#campaignTrafficSourceType");
    }

    public SelenideElement getCampaignType() {
        return $("#campaignType");
    }

    public SelenideElement getCampaignCountry() {
        return $("#campaignCountry");
    }

    public SelenideElement getCampaignBid() {
        return $("#campaignBid");
    }

    public SelenideElement getAdultFilter() {
        return $("#campaignAdultFilters");
    }

    public SelenideElement getDestinationUrl() {
        return $("#campaignDestinationUrl");
    }


}
