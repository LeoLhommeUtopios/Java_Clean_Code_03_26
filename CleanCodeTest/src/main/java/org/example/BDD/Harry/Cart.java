
package org.example.BDD.Harry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

    private final double BOOK_PRICE;

    private final static double[] REDUCTIONS = {
            0.0,
            0.0,
            0.05,
            0.10,
            0.20,
            0.25
    };

    private final int[] quantites = new int[6];

    public Cart(double price) {
        BOOK_PRICE = price;
    }

    public void addBook (int book,int quantity){
        if(book<1 || book>5){
            throw new IllegalArgumentException("No Book Found");
        }
        quantites[book] += quantity;
    }

    public double calculateTotalPrice (){
        List<Integer> stocks = new ArrayList<>();
        for(int i =1 ; i<=5;i++){
            if(quantites[i]>0){
                stocks.add(quantites[i]);
            }
        }

        return calculatePrice(stocks);
    }

    private double calculatePrice (List<Integer> stocks){
        stocks.removeIf(q -> q == 0);
        if(stocks.isEmpty()){
            return 0.0;
        }
        Collections.sort(stocks, Collections.reverseOrder());

        double prixMin = Double.MAX_VALUE;

        for(int tailleGroupe = 1; tailleGroupe<=stocks.size();tailleGroupe++){
            List<Integer> restants = new ArrayList<>(stocks);
            for (int i =0; i <tailleGroupe;i++){
                restants.set(i,restants.get(i)-1);
            }

            double prixGroupe = PrixGroupe(tailleGroupe);
            double prixTotal = prixGroupe +calculatePrice(restants);

            if(prixTotal < prixMin){
                prixMin = prixTotal;
            }
        }
        return prixMin;
    }

    private double PrixGroupe (int taille){
        double reduction = REDUCTIONS[taille];
        return taille * BOOK_PRICE * (1 - reduction);
    }
}
