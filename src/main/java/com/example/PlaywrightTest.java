package com.example;

import com.microsoft.playwright.*;
import com.pages.*;

public class PlaywrightTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate(examplePage.siteUrl);
            System.out.println("Page title: " + page.title());
            browser.close();
        }
    }
}
