package org.example.SOLID.ocp;

//public class PaymentProcessor {
//    public void pay(String methode){
//        if (methode.equals("paypal")) {
//            System.out.println("Paiment avec paipal");
//        }else if(methode.equals("creditCard")){
//            System.out.println("paiement avec une carte");
//        }
//    }
//}

interface PaymentMethod{
    void pay();
}

class PaypalPayment implements PaymentMethod{
    @Override
    public void pay() {
        System.out.println("Paiment avec paypal");
    }
}

class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay() {
        System.out.println("Paiment avec une carte de credit");
    }
}

class PayementProcessor {
    public void process (PaymentMethod method){
        method.pay();
    }
}
