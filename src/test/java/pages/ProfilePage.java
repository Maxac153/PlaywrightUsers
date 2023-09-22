package pages;

import com.microsoft.playwright.Page;

public class ProfilePage {

    // Работает только из под Админа
    public static void deleteUser(Page page, String query) {
        page.fill("//input[@placeholder='Введите email или имя']", query);
        page.locator("//button[text()='Найти']").click();
        page.locator("//a[text()='Удалить']").click();
    }
}
