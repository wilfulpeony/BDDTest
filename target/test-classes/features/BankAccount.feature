Feature: Bank Account

  Scenario Outline: User is able to pick actions for account
    Given user is on a home page
    When user selects "<action>"
    Then "<action>" page was opened
    Examples:
      | action               |
      | Open new account     |
      | Withdraw money       |
      | Put money on account |
      | View Account         |

  Scenario Outline: User is able to create new account
    Given user is on a home page
    When user selects "Open new account"
    And user creates "<accountType>" account for "OWNERID_RANDOM" with balance "100"
    Then message about successful creation is shown

    Examples:
      | accountType       |
      | Basic account     |
      | Overdraft account |

  Scenario: User is able to create accounts with duplicate owner
    Given user is on a home page
    When user selects "Open new account"
    And user tries to create two accounts with same owner
    Then message "Couldn't create duplicated user id" is shown

  Scenario Outline: User is not able to create new account with invalid balance
    Given user is on a home page
    When user selects "Open new account"
    And user creates "<accountType>" account for "OWNERID_RANDOM" with balance "<balance>"
    Then message about failed creation is shown

    Examples:
      | accountType       | balance              |
      | Basic account     | -300                 |
      | Basic account     | asdasdasdad          |
      | Basic account     | !!!!!                |
      | Basic account     | 31231231231231231231 |
      | Overdraft account | -300                 |
      | Overdraft account | asdasdasdad          |
      | Overdraft account | !!!!!                |
      | Overdraft account | 31231231231231231231 |

  Scenario Outline: User is able to put money on account
    Given user is on a home page
    And there is money on "<accountType>" account
    When user selects "Put money on account"
    And user deposits money on "<accountType>" account
    Then user sees that money was added on account
    Examples:
      | accountType |
      | basic       |
      | overdraft   |

  Scenario Outline: User is unable to put invalid amount of money on account
    Given user is on a home page
    When user selects "Put money on account"
    And user deposits following amount "<amount>" on "<accountType>" account
    Then message about failed transation is shown
    Examples:
      | accountType | amount    |
      | basic       | -1        |
      | basic       | asdasdasd |
      | basic       | !!!!!!    |
      | overdraft   | -1        |
      | overdraft   | asdasdasd |
      | overdraft   | !!!!!!    |

  Scenario Outline: User is able to withdraw money from account
    Given user is on a home page
    And there is money on "<accountType>" account
    When user selects "Withdraw money"
    And user withdraws following amount "<amount>" on "<accountType>" account
    Then user sees that money was pulled from account
    Examples:
      | accountType | amount |
      | basic       | 1      |
      | overdraft   | 1      |

    Scenario: User is able to go into overdraft if they have right account type
      Given user is on a home page
      And there is money on "overdraft" account
      When user selects "Withdraw money"
      And user withdraws following amount "500" on "overdraft" account
      Then user sees no money on account





