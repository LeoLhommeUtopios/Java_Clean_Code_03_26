Feature: Harry Potter book shoipping cart price calculation
  As a customer
  I want to calculate the total price of my shopping cart

  Background:
    Given the unit price of a book is 8 euros

    Scenario: Buying a single book
      When I add 1 copy of book 1 to my cart
      Then the total price is 8.00 euros

    Scenario: Buying two identical book
      When I add 2 copy of book 1 to my cart
      Then the total price is 16.00 euros

  Scenario: Buying two different books with 5% discount
    When I add 1 copy of book 1 to my cart
    And I add 1 copy of book 2 to my cart
    Then the total price is 15.20 euros

  Scenario: Buying three different books with 10% discount
    When I add 1 copy of book 1 to my cart
    And I add 1 copy of book 2 to my cart
    And I add 1 copy of book 3 to my cart
    Then the total price is 21.60 euros

  Scenario: Buying four different books with 20% discount
    When I add 1 copy of book 1 to my cart
    And I add 1 copy of book 2 to my cart
    And I add 1 copy of book 3 to my cart
    And I add 1 copy of book 4 to my cart
    Then the total price is 25.60 euros

  Scenario: Buying five different books with 20% discount
    When I add 1 copy of book 1 to my cart
    And I add 1 copy of book 2 to my cart
    And I add 1 copy of book 3 to my cart
    And I add 1 copy of book 4 to my cart
    And I add 1 copy of book 5 to my cart
    Then the total price is 30.00 euros

  Scenario: Mixed cart - one group of 2 and one single book
    When I add 2 copy of book 1 to my cart
    And I add 1 copy of book 2 to my cart
    Then the total price is 23.20 euros

  Scenario: Mixed cart - two group of 2 different book
    When I add 2 copy of book 1 to my cart
    And I add 2 copy of book 2 to my cart
    Then the total price is 30.40 euros

  Scenario: Complex with different number of all five books
    When I add 1 copy of book 1 to my cart
    And I add 1 copy of book 2 to my cart
    And I add 2 copy of book 3 to my cart
    And I add 2 copy of book 4 to my cart
    And I add 2 copy of book 5 to my cart
    Then the total price is 51.20 euros

    Scenario: Empty cart
      When my cart is empty
      Then the total price is 0.00 euros
