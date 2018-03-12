package zeropark.ui.pages.domainCampaign;

import zeropark.ui.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TargetingOptionsPage extends BasePage {

    public RunOfNetworkCreateFormPage addRunOfNetworkCampaign() {
        $("a#add_ron").click();
        return page(RunOfNetworkCreateFormPage.class);
    }

    public void addKeywordCampaign() {
        $("a#add_keyword").click();
    }

    public void addTargetedCampaign() {
        $("a#add_targeted").click();
    }

    public void addMultiGeoCampaign() {
        $("a#add_multigeo").click();
    }
}
