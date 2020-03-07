package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {
    @FindBy(xpath = "//*[@name='Type']")
    public WebElement selectDropdown;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    public void selectAction(String action) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + action + "')]")).click();
        selectDropdown.click();
        submitButton.click();
    }

    public void navigateToHomePage() {
        getDriver().navigate().to("http://localhost:8080/BankAccount/");
    }
}