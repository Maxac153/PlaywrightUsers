package pages;

import com.microsoft.playwright.Page;

public class RegistrationAndAuthorizationPage {
    public static void regUser(Page page, String name, String email, String password) {
        page.locator("//span[text()='Войти']").click();
        page.fill("//input[@required=''][@name='name']", name);
        page.fill("//input[@required=''][@name='email']", email);
        page.fill("//input[@required=''][@name='password']", password);
        page.locator("//input[@value='Зарегистрироваться']").click();
    }

    public static void autUser(Page page, String email, String password) {
        page.locator("//span[text()='Войти']").click();
        page.fill("//input[@name='login']", email);
        page.fill("//input[@name='password']", password);
        page.locator("//input[@value='Авторизоваться']").click();
    }
}
