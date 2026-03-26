package org.example.Kata2;

public class ElectronicsProduct extends Product{
    private boolean onSale;

    public ElectronicsProduct(double basePrice,boolean onSale) {
        super(basePrice);
        this.onSale = onSale;
    }

    @Override
    public double calculaterPrice() {
        double price = basePrice + basePrice* 0.15;
        if(onSale){
            price -= price * 0.1;
        }

        return price;
    }
}
