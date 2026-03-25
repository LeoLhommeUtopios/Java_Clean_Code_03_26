Feature: Retrait d'argent au distributeur
  Scenario: Retrait avec solde suffisant
    Given mon compte a un solde de 100 euros
    When je demande à retirer 50 euros
    Then je devrais recevoir 50 euros
    And mon solde devrait être de 50 euros

Feature: Retrait d'argent au distributeur
  Scenario: Retrait avec solde insuffisant
    Given mon compte a un solde de 50 euros
    When je demande à retirer 100 euros
    Then je devrais recevoir 0 euros