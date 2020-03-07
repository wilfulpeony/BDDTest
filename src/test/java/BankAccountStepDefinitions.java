import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.pages.*;

import java.util.Arrays;
import java.util.List;

public class BankAccountStepDefinitions {

    public String moneyOnAccount;

    @Given("user is on a home page")
    public void userIsOnAHomePage() {
        HomePage page = new HomePage();
        page.navigateToHomePage();
    }

    @When("user selects {string}")
    public void userSelects(String action) {
        HomePage page = new HomePage();
        page.selectAction(action);
    }

    @Then("{string} page was opened")
    public void pageWasOpened(String action) {
        switch (action) {
            case "Open new account": {
                OpenAccountPage page = new OpenAccountPage();
                Assert.assertTrue(page.pageTitle.isDisplayed());
                break;
            }
            case "Withdraw money": {
                WithdrawPage page = new WithdrawPage();
                Assert.assertTrue(page.pageTitle.isDisplayed());
                break;
            }
            case "Put money on account": {
                DepositPage page = new DepositPage();
                Assert.assertTrue(page.pageTitle.isDisplayed());
                break;
            }
            case "View Account": {
                ViewAccountPage page = new ViewAccountPage();
                Assert.assertTrue(page.pageTitle.isDisplayed());
                break;
            }
        }
    }

    @And("user clicks on submit button")
    public void selectSubmitButton() {
        HomePage page = new HomePage();
        page.submitButton.click();
    }

    @And("user creates {string} account for {string} with balance {string}")
    public void userCreatesAccountForWithBalance(String accountType, String ownerId, String balance) {
        OpenAccountPage page = new OpenAccountPage();
        page.selectAccountType(accountType);
        if (ownerId.endsWith("RANDOM")) {
            page.enterOwnerIdText(ownerId + Math.random());
        } else {
            page.enterOwnerIdText(ownerId);
        }
        page.enterAmount(balance);
        page.submitButton.click();
    }

    @Then("message about successful creation is shown")
    public void messageAboutSuccessfullCreationIsShown() {
        OpenAccountPage page = new OpenAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains("Account for Owner ID"));
        Assert.assertTrue(page.labelSuccess.getText().contains("was created successfully"));
    }

    @Then("message about failed creation is shown")
    public void messageAboutFailedCreationIsShown() {
        OpenAccountPage page = new OpenAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains("Not possible to create such account"));
    }

    @And("user tries to create two accounts with same owner")
    public void userTriesToCreateTwoAccountsWithSameOwner() {
        OpenAccountPage page = new OpenAccountPage();
        page.selectAccountType("Basic");
        String ownerId = "ownerId" + Math.random();
        page.enterOwnerIdText(ownerId);
        page.enterAmount("100");
        page.submitButton.click();
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.selectAction("Open new account");
        page = new OpenAccountPage();
        page.selectAccountType("Basic");
        page.enterOwnerIdText(ownerId);
        page.enterAmount("100");
        page.submitButton.click();
    }

    @Then("message {string} is shown")
    public void messageIsShown(String message) {
        OpenAccountPage page = new OpenAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains(message));
    }

    @When("user deposits money on account")
    public void userDepositsMoneyOnAccount() {
        
    }

    @When("user deposits money on {string} account")
    public void userDepositsMoneyOnAccount(String account) {
        DepositPage page = new DepositPage();
        page.ownerIdInputField.sendKeys(account);
        page.amountInputField.sendKeys("100");
        page.submitButton.click();
    }

    @Then("user sees that money was added on account")
    public void userSeesThatMoneyWasAddedOnAccount() {
        ViewAccountPage page = new ViewAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains(String.valueOf(Double.valueOf(moneyOnAccount) + 100)));
    }

    @And("there is money on {string} account")
    public void thereIsMoneyOnAccount(String arg0) {
        HomePage homePage = new HomePage();
        homePage.selectAction("View Account");
        ViewAccountPage page = new ViewAccountPage();
        page.ownerIdInputField.sendKeys(arg0);
        page.submitButton.click();
        List<String> temp = Arrays.asList(page.labelSuccess.getText().split("\n"));
        moneyOnAccount = temp.get(temp.size()-1);
        homePage.navigateToHomePage();
    }

    @And("user deposits following amount {string} on {string} account")
    public void userDepositsFollowingAmountOnAccount(String arg0, String arg1) {
        DepositPage page = new DepositPage();
        page.ownerIdInputField.sendKeys(arg1);
        page.amountInputField.sendKeys(arg0);
        page.submitButton.click();
    }

    @Then("message about failed transation is shown")
    public void messageAboutFailedTransationIsShown() {
        ViewAccountPage page = new ViewAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains("Not possible transaction"));
    }

    @Then("user sees that money was pulled from account")
    public void userSeesThatMoneyWasPulledFromAccount() {
        ViewAccountPage page = new ViewAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains(String.valueOf(Double.valueOf(moneyOnAccount) - 1)));
    }

    @And("user withdraws following amount {string} on {string} account")
    public void userWithdrawsFollowingAmountOnAccount(String arg0, String arg1) {
        DepositPage page = new DepositPage();
        page.ownerIdInputField.sendKeys(arg1);
        page.amountInputField.sendKeys(arg0);
        page.submitButton.click();
    }

    @Then("user sees no money on account")
    public void userSeesNoMoneyOnAccount() {
        ViewAccountPage page = new ViewAccountPage();
        Assert.assertTrue(page.labelSuccess.getText().contains("0.0"));
    }
}


