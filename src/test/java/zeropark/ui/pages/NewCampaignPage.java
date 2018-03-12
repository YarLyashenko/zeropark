package zeropark.ui.pages;

import zeropark.ui.pages.domainCampaign.TargetingOptionsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NewCampaignPage extends BasePage {
    public TargetingOptionsPage newDomainCampaign() {
        $("a[href='/bidding/campaign/domain/add']").click();
        return page(TargetingOptionsPage.class);
    }

    public void newPopupCampaign() {
        $("a[href='/bidding/campaign/popup/add']").click();
    }

    public void newInAppCampaign() {
        $("a[href='/bidding/campaign/inapp/add']").click();
    }
}
