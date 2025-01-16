package com.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import com.pages.cookieclickerPage;

public class cookieclicker {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate(cookieclickerPage.siteUrl);
            final Locator cookie = page.locator("#bigCookie");
            final Locator availableUpgrade = page.locator("//*[@class='product unlocked enabled'][last()]");
            final Locator crateUpgrade = page.locator("//*[@class='crate upgrade enabled'][last()]");
            final Locator closenotes = page.locator("//*[@id='notes']//*[@class='close'][last()]");

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Web version")).click();
            page.getByText("English").click();
            page.locator("#note-1").getByText("x", new Locator.GetByTextOptions().setExact(true)).click();

            while (true) {
                if (crateUpgrade.isVisible()) {
                    crateUpgrade.click();
                } else if (availableUpgrade.isVisible()) {
                    availableUpgrade.click();
                }
                // if (closenotes.isVisible()) {
                // closenotes.click();
                // }
                cookie.click();

            }
        }

    }

}