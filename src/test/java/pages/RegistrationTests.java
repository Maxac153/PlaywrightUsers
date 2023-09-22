package pages;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import wrapper.WrapperTests;

public class RegistrationTests extends WrapperTests {
    @Test
    void regUser() {
        final String userName = "Tur123";
        final String userEmail = "max@gmail.com";
        final String userPassword = "123";

        page.navigate(baseUrl);

        // Registration
        page.locator("//span[text()='Войти']").click();
        page.fill("//input[@required=''][@name='name']", userName);
        page.fill("//input[@required=''][@name='email']", userEmail);
        page.fill("//input[@required=''][@name='password']", userPassword);
        page.locator("//input[@value='Зарегистрироваться']").click();

        page.waitForURL("http://users.bugred.ru/");
        if (page.url().equals("http://users.bugred.ru/")) {
            // Logout
            page.locator("xpath=//a[@class='dropdown-toggle']").click();
            page.locator("xpath=//a[text()='Выход']").click();

            // Authorization admin
            page.locator("//span[text()='Войти']").click();
            page.fill("//input[@name='login']", adminEmail);
            page.fill("//input[@name='password']", adminPassword);
            page.locator("//input[@value='Авторизоваться']").click();

            // Delete user
            page.fill("//input[@placeholder='Введите email или имя']", userName);
            page.locator("//button[text()='Найти']").click();
            page.locator("//a[text()='Удалить']").click();

            // Logout
            page.locator("xpath=//a[@class='dropdown-toggle']").click();
            page.locator("xpath=//a[text()='Выход']").click();
        }
    }
}