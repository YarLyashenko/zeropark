package zeropark.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public LoginPage performLogin(String email, String password) {
        SelenideElement loginButton = $("button#login");
        if (!loginButton.isDisplayed()) return this;

        $("#email").setValue(email);
        $("#password").setValue(password);

        loginButton.click();
        return this;
    }

}
