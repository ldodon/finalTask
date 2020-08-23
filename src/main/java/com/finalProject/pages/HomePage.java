package com.finalProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{


    @FindBy(css = "#contact-link")
    private WebElement contactUs;
    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    private WebElement women;


    public HomePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public String getPageUrl() {
        return "/index.php";
    }

    public WebElement getContactUs(){
        return contactUs;
    }
    public WebElement getWomen(){
        return women;
    }
}
