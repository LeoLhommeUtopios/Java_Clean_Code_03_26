package StepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BDD.Compte;
import org.example.BDD.Distributeur;
import org.example.BDD.RetraitResultat;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public class WithdrawSteps {

    private Compte compte;
    private Distributeur distributeur;
    private RetraitResultat retraitResultat;


    @Given("mon compte a un solde de {int} euros")
    public void mon_compte_a_un_solde_de_euros(Integer int1) {
        compte = new Compte(int1);
    }
    @When("je demande à retirer {int} euros")
    public void je_demande_à_retirer_euros(Integer int1) {
        this.distributeur = new Distributeur();
        this.retraitResultat = distributeur.retirer(compte,int1);
    }
    @Then("je devrais recevoir {int} euros")
    public void je_devrais_recevoir_euros(Integer int1) {
        Assertions.assertEquals((double) int1,retraitResultat.getMontant());
    }
    @Then("mon solde devrait être de {int} euros")
    public void mon_solde_devrait_être_de_euros(Integer int1) {
        Assertions.assertEquals((double) int1,compte.getSolde());
    }

}
