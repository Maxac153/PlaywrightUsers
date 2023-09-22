package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    public static void logoutProfile(Page page) {
        page.locator("xpath=//a[@class='dropdown-toggle']").click();
        page.locator("xpath=//a[text()='Выход']").click();
    }
}
