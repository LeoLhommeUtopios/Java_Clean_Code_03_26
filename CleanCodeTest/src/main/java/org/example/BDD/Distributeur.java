package org.example.BDD;

public class Distributeur {

    public RetraitResultat retirer (Compte compte,double montant){
        compte.setSolde(compte.getSolde() - montant);
        return  new RetraitResultat(montant);
    }
}
