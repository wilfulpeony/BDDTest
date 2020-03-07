package org.pages;

import org.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawPage extends CommonPage {

    @FindBy(xpath = "//*[@name='Type']")
    public WebElement selectDropdown;
    @FindBy(xpath = "//h1[contains(text(),\"Please, enter info to withdraw:\")]")
    public WebElement pageTitle;
}
