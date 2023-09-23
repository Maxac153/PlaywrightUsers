package test;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.BasePage;
import pages.ProfilePage;
import pages.RegistrationAndAuthorizationPage;
import wrapper.Wrapper;

@Epic("Test user registration")
public class RegistrationTest extends Wrapper {
    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "Корректные данные, Tur123, max@gmail.com, 123, http://users.bugred.ru/",
            "Пропуск @ в email, Tur123, maxgmail.com, 123, http://users.bugred.ru/user/register/index.html",
            "Пропуск . в email, Tur123, max@gmailcom, 123, http://users.bugred.ru/user/register/index.html",
            "Пропуск имени пользователя, '', max@gmail.com, 123, http://users.bugred.ru/user/login/index.html",
            "Пропуск email пользователя, Tur123, '', 123, http://users.bugred.ru/user/login/index.html",
            "Пропуск пароля пользователя, Tur123, max@gmail.com, '', http://users.bugred.ru/user/login/index.html",
    })
    void regUserTest(String testName, String userName, String userEmail, String userPassword, String extendedResult) {
        page.navigate(baseUrl);

        // Registration
        RegistrationAndAuthorizationPage.regUser(page, userName, userEmail, userPassword);
        String result = page.url();

        // Wait load Page
        if (extendedResult.equals("http://users.bugred.ru/"))
            page.waitForURL(result);

        if (page.url().equals("http://users.bugred.ru/")) {
            // Logout
            BasePage.logoutProfile(page);

            // Authorization admin
            RegistrationAndAuthorizationPage.autUser(page, adminEmail, adminPassword);

            // Delete user
            ProfilePage.deleteUser(page, userName);

            // Logout
            BasePage.logoutProfile(page);
        }

        Assertions.assertEquals(extendedResult, result);
    }
}