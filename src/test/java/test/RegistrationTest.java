package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.BasePage;
import pages.ProfilePage;
import pages.RegistrationAndAuthorizationPage;
import wrapper.Wrapper;

public class RegistrationTest extends Wrapper {
    @ParameterizedTest
    @CsvSource({
            "Tur123, max@gmail.com, 123, http://users.bugred.ru/",
    })
    void regUserTest(String userName, String userEmail, String userPassword, String extendedResult) {
        page.navigate(baseUrl);

        // Registration
        RegistrationAndAuthorizationPage.regUser(page, userName, userEmail, userPassword);
        String result = page.url();

        // Wait load Page
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