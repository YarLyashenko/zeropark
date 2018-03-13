package zeropark.ui;

import org.junit.Test;
import zeropark.ui.pages.BasePage;
import zeropark.ui.pages.CampaignCreatedConfirmationPage;
import zeropark.ui.pages.LoginPage;
import zeropark.ui.pages.NewCampaignPage;
import zeropark.ui.pages.dashboard.CampaignsTableRow;
import zeropark.ui.pages.dashboard.DashboardPage;
import zeropark.ui.pages.domainCampaign.RunOfNetworkCreateFormPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.System.currentTimeMillis;

public class CreateRunOfNetworkCampaignTest extends BaseUITest {

    @Test
    public void validateMandatoryFieldsOfRONCampaignCreationPage() {
        open(BasePage.BASE_PAGE + "/bidding/campaign/add", LoginPage.class)
                .performLogin(LOGIN, PASSWORD);

        NewCampaignPage newCampaignPage = page(NewCampaignPage.class);
        newCampaignPage.newDomainCampaign()
                .addRunOfNetworkCampaign()
                .save();

        RunOfNetworkCreateFormPage createFormPage = page(RunOfNetworkCreateFormPage.class);

        createFormPage.getCampaignNameValidationMessage().shouldBe(visible);
        createFormPage.getCampaignNameValidationMessage().shouldHave(text("This field cannot be empty"));

        createFormPage.getCountryValidationMessage().shouldBe(visible);
        createFormPage.getCountryValidationMessage().shouldHave(text("Select country for your campaign"));

        createFormPage.getBidValidationMessage().shouldBe(visible);
        createFormPage.getBidValidationMessage().shouldHave(text("This field cannot be empty"));

        createFormPage.getAdultFiltersValidationMessage().shouldBe(visible);
        createFormPage.getAdultFiltersValidationMessage().shouldHave(text("Please select at least one of the options in the \"Adult filtering\" section"));

        createFormPage.getDestinationUrlValidationMessage().shouldBe(visible);
        createFormPage.getDestinationUrlValidationMessage().shouldHave(text("This field cannot be empty"));
    }

    @Test
    public void createRunOfNetworkCampaign() {
        String campaignName = currentTimeMillis() + " Domain campaign";
        String countryName = "Poland";
        String campaignType = "Ron";
        String countryNameShort = "PL";
        String bid = "0.0003";
        String destinationUrl = "http://google.com";

        open(BasePage.BASE_PAGE + "/bidding/campaign/add", LoginPage.class)
                .performLogin(LOGIN, PASSWORD);

        NewCampaignPage newCampaignPage = page(NewCampaignPage.class);

        newCampaignPage.newDomainCampaign()
                .addRunOfNetworkCampaign()
                .withName(campaignName)
                .withCountry(countryName)
                .withBid(bid)
                .isAdult(true)
                .withDestinationUrl(destinationUrl)
                .save();

        CampaignCreatedConfirmationPage confirmationPage = page(CampaignCreatedConfirmationPage.class);

        confirmationPage.getHeader().shouldHave(text("Campaign created succesfully!"));
        confirmationPage.getCampaignName().shouldHave(text("Campaign name: " + campaignName));
        confirmationPage.getCampaignCountry().shouldHave(text("Country: " + countryName));
        confirmationPage.getCampaignBid().shouldHave(text("Bid: $" + bid));
        confirmationPage.getAdultFilter().shouldHave(text("Adult filter: Adult only"));
        confirmationPage.getDestinationUrl().shouldHave(text("Destination URL: " + destinationUrl));

        DashboardPage dashboardPage = open(DashboardPage.DASHBOARD_PAGE_ADDRESS, DashboardPage.class);

        CampaignsTableRow createdCampaign = dashboardPage.getCampaignsTableRow(campaignName);

        createdCampaign.getName().shouldHave(text(campaignName));
        createdCampaign.getType().shouldHave(text(campaignType));
        createdCampaign.getLocation().shouldHave(text(countryNameShort));
        createdCampaign.getBidCellInput().shouldHave(value(bid));
    }
}
