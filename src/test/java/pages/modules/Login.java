package pages.modules;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.ZeroBase;
import utilities.Browser_Utils;
import utilities.ConfigurationReader;

public class Login extends ZeroBase {

    @FindBy(id = "signin_button")
    private WebElement signinBtnMain;

    @FindBy(id = "user_login")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(name = "submit")
    private WebElement signinBtn;

    @FindBy(xpath = "//a[text()=\"Forgot your password ?\"]")
    private WebElement forgotPassword;

    @FindBy(xpath = "//div[contains(text(),\"Login and/or password are wrong\")]")
    private WebElement errorMessage;


    /**
     * Method to login as specific user
     *
     * @param user_name
     * @param user_password
     */
    public void login(String user_name, String user_password) {
        signinBtnMain.click();
        Browser_Utils.waitForPageToLoad(10);
        userName.sendKeys(user_name);
        password.sendKeys(user_password, Keys.ENTER);
        Browser_Utils.waitForPageToLoad(10);
    }

    /**
     * Login with default user name and password
     */
    public void login() {
        signinBtnMain.click();
        Browser_Utils.waitForPageToLoad(10);
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        Browser_Utils.waitForPageToLoad(10);
    }

    /**
     * This method returns error message
     *
     * @return string
     */
    public String getErrorMessage() {
        return errorMessage.getText().trim();
    }
}
