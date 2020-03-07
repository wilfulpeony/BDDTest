package org.pages;

import org.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAccountPage extends CommonPage {

    @FindBy(xpath = "//*[@name='Type']")
    public WebElement selectDropdown;
    @FindBy(xpath = "//h1[contains(text(),\"Please, enter your ID to view account:\")]")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@name=\"ownerId\"]")
    public WebElement ownerIdInputField;

    @FindBy(xpath = ".//center[text()]")
    public WebElement labelSuccess;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

}
