package com.finalProject.pages;

import org.openqa.selenium.WebDriver;

public class WomenPage extends AbstractPage{

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return "/index.php?id_category=3&controller=category";
    }
}
