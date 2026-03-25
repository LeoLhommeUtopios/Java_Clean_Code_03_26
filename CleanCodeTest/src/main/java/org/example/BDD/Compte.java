package org.example.BDD;

public class Compte {

    private double solde;

    public Compte(double solde) {
        this.solde = solde;
    }

    public double getSolde(){
        return solde;
    }

    public void setSolde(double montant){
        solde = montant;
    }
}
