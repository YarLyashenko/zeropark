package zeropark.ui.pages.dashboard;

import com.codeborne.selenide.SelenideElement;

public class CampaignsTableRow {
    private SelenideElement row;

    public CampaignsTableRow(SelenideElement row) {
        this.row = row;
    }

    public SelenideElement getName() {
        return row.find("span.campaign-real-name").closest("td");
    }

    public SelenideElement getLocation() {
        return row.find("td", 3);
    }

    public SelenideElement getType() {
        return row.find("td", 4);
    }

    public SelenideElement getBidCell() {
        return row.find("td", 9);
    }

    public SelenideElement getBidCellInput() {
        return getBidCell().find("input");
    }
}
