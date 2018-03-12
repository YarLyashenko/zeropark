package zeropark.ui.pages.dashboard;

import com.codeborne.selenide.CollectionCondition;
import zeropark.ui.pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage extends BasePage {
    public static final String DASHBOARD_PAGE_ADDRESS = BASE_PAGE + "/bidding";

    public DashboardPage filterCampaign(String name) {
        $("input#all-campaigns-quicksearch")
                .setValue(name)
                .pressEnter();
        sleep(1000);
        return this;
    }

    public List<CampaignsTableRow> getCampaignsTableRows() {
        return $$("#all-campaigns-table table tr")
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream()
                .map(CampaignsTableRow::new)
                .collect(Collectors.toList());
    }

    public CampaignsTableRow getCampaignsTableRow(String campaignName) {
        return getCampaignsTableRows().stream()
                .filter(row -> row.getName().getText().equalsIgnoreCase(campaignName))
                .findFirst()
                .orElse(null);
    }
}
