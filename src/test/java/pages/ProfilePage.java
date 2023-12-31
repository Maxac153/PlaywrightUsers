package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

public class ProfilePage {

    // Работает только из под Админа
    @Step("Delete user")
    public static void deleteUser(Page page, String query) {
        page.fill("//input[@placeholder='Введите email или имя']", query);
        page.locator("//button[text()='Найти']").click();
        page.locator("//a[text()='Удалить']").click();
    }
}
