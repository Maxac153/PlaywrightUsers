package pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;

public class BasePage {
    @DisplayName("Logout profile")
    public static void logoutProfile(Page page) {
        page.locator("xpath=//a[@class='dropdown-toggle']").click();
        page.locator("xpath=//a[text()='Выход']").click();
    }
}
