Feature: Hepsiburada Case

  @HepsiburadaCase
  Scenario: Adding a product to the cart by logging in
    Given The user visits the website "https://www.hepsiburada.com/"
    When The user logs in "testautomation174@gmail.com" and "Hepsi12345"
    And The user searches for "cep telefonu" for the product he wants to buy
    And The user filters "3000" – "5000" as the price range in the search result
    And The user selects a random product from the bottom line in the product list displayed in the filtered result and goes to the product details
    And For the product whose details are opened, the product of the seller with the lowest score is added to the cart
    Then It is checked that the product has been added to the basket correctly

  @HepsiburadaCase
  Scenario: Adding a product to the cart without logging in
    Given The user visits the website "https://www.hepsiburada.com/"
    And The user searches for "cep telefonu" for the product he wants to buy
    And The user filters "3000" – "5000" as the price range in the search result
    And The user selects a random product from the bottom line in the product list displayed in the filtered result and goes to the product details
    And For the product whose details are opened, the product of the seller with the lowest score is added to the cart
    Then It is checked that the product has been added to the basket correctly