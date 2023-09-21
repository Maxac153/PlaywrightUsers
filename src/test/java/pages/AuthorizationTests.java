package pages;
import org.junit.jupiter.api.Test;
import wrapper.WrapperTests;

public class AuthorizationTests extends WrapperTests {
    @Test
    void shouldClickButton() {
        final String name = "Tur123";
        final String email = "max@gmail.com";
        final String password = "123";
        final String baseUrl = "http://users.bugred.ru/";

        page.navigate(baseUrl);
        page.getByText("Войти").click();
        page.fill("//input[@required=''][@name='name']", name);
        page.fill("//input[@required=''][@name='email']", email);
        page.fill("//input[@required=''][@name='password']", password);
        page.getByText("Зарегистрироваться").click();
    }
}