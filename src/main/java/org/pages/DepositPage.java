package org.pages;

import org.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DepositPage extends CommonPage {
    @FindBy(xpath = "//*[@name='Type']")
    public WebElement selectDropdown;

    @FindBy(xpath = "//h1[contains(text(),\"Please, proceed with your account info:\")]")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@name=\"ownerId\"]")
    public WebElement ownerIdInputField;

    @FindBy(xpath = "//*[@name=\"amount\"]")
    public WebElement amountInputField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = ".//center[text()]")
    public WebElement labelSuccess;
}
