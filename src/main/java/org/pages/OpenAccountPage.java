package org.pages;

import org.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends CommonPage {


    @FindBy(xpath = "//*[@name='Type']")
    public WebElement selectDropdown;

    @FindBy(xpath = "//h1[contains(text(),\"Please, input info to open new account:\")]")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@name=\"ownerId\"]")
    public WebElement ownerIdInputField;

    @FindBy(xpath = "//*[@name=\"amount\"]")
    public WebElement amountInputField;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = ".//center[text()]")
    public WebElement labelSuccess;

    public void enterOwnerIdText(String name) {
        ownerIdInputField.click();
        ownerIdInputField.sendKeys(name);
    }

    public void enterAmount(String amount) {
        amountInputField.click();
        amountInputField.sendKeys(amount);
    }

    public void selectAccountType(String type) {
        if (type.toLowerCase().contains("basic")) {
            getDriver().findElement(By.xpath(".//*[text()='Basic account']")).click();
        } else if (type.toLowerCase().contains("overdraft")) {
            getDriver().findElement(By.xpath(".//*[text()='Overdraft account']")).click();
        }
    }
}
