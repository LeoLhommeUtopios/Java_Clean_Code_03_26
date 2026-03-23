package org.example;

public class DemoOrderCleanCode {

//    public void handleOrder (Order order) {
//        if(order.getItems().isEmpty()){
//            throw new IllegalArgumentException("Empty order");
//        }
//        double total = 0;
//        for (Item item : order.getItems()){
//            total += item.getPrice();
//        }
//        System.out.println("total"+total);
//    }

    public void handleOrder(Order order){
        validateOrder(order);
        double total = order.getTotal();
        printTotal(total);
    }

    public void validateOrder(Order order){
        if(order.getItems().isEmpty()){
            throw new IllegalArgumentException("Empty Order");
        }
    }

    public void printTotal (double total){
        System.out.println("Total : "+total);
    }

//    public void calculateDiscountForOrder (Order order){
//        double discount = 0;
//        if(order.getTotal()>100){
//            discount = order.getTotal()*0.20;
//        }
//
//        double tax = order.getTotal()*0.20;
//        System.out.println("Discount : "+discount+", Tax : "+tax);
//    }
//
//    public void calculateDiscountForAnotherOrder (Order order){
//        double discount = 0;
//        if(order.getTotal()>100){
//            discount = order.getTotal()*0.15;
//        }
//
//        double tax = order.getTotal()*0.20;
//        System.out.println("Discount : "+discount+", Tax : "+tax);
//    }


    private double calculateDiscount(Order order){
        double discount = 0;
        if(order.getTotal()>300){
            discount= order.getTotal()*0.15;
        }
        return discount;
    }

    private double calculateTax(Order order){
        double tax = order.getTotal()*0.20;
        return tax;
    }

    public void printOrderDetails (Order order){
        double discount = calculateDiscount(order);
        double tax = calculateTax(order);
        System.out.println("discount : "+discount+", Tax : "+tax);
    }

}
