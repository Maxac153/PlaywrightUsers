package pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

public class RegistrationAndAuthorizationPage {
    @Step("Registration user")
    public static void regUser(Page page, String name, String email, String password) {
        page.locator("//span[text()='Войти']").click();
        page.fill("//input[@required=''][@name='name']", name);
        page.fill("//input[@required=''][@name='email']", email);
        page.fill("//input[@required=''][@name='password']", password);
        page.locator("//input[@value='Зарегистрироваться']").click();
    }
    @Step("Authorization user")
    public static void autUser(Page page, String email, String password) {
        page.locator("//span[text()='Войти']").click();
        page.fill("//input[@name='login']", email);
        page.fill("//input[@name='password']", password);
        page.locator("//input[@value='Авторизоваться']").click();
    }
}
