package pages;

import com.microsoft.playwright.*;

public class AuthorizationTests {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://users.bugred.ru/");
            System.out.println(page.title());
        }
    }
}
