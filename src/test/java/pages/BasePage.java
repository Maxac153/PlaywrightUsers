package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class BasePage {
    @Step("Logout profile")
    public static void logoutProfile(Page page) {
        page.locator("xpath=//a[@class='dropdown-toggle']").click();
        page.locator("xpath=//a[text()='Выход']").click();
    }
}
