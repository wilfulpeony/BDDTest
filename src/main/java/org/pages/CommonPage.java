package org.pages;

import org.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPage extends DriverFactory{

    public CommonPage(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }
}
