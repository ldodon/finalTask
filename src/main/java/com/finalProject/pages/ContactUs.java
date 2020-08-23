package com.finalProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUs extends AbstractPage{

    @FindBy(xpath = "//select[@id='id_contact']")
    private WebElement subject;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@id='id_order']")
    private WebElement orderReference;
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement message;
    @FindBy(xpath = "//button[@id='submitMessage']")
    private WebElement send;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement messageDisplayed;


    public ContactUs(WebDriver driver) {
        super(driver);

    }

    @Override
    public String getPageUrl() {
        return "/index.php?controller=contact";
    }

    public WebElement getEmail() {
        return emailAddress;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getOrder() {
        return orderReference;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSend() {
        return send;

    }
    public WebElement getMessageDisplayed() {
        return messageDisplayed;

    }
}
