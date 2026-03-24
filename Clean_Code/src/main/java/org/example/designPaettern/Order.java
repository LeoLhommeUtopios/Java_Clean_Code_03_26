package org.example.designPaettern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {
    private String id;
    private String customerId;
    private List<String> items;
    private boolean express;

    private Order(Builder b){
        this.id = b.id;
        this.customerId = b.customerId;
        this.items = b.items;
        this.express = b.express;
    }

    public static class Builder {
        private String id;
        private String customerId;
        private List<String> items = new ArrayList<>();
        private boolean express;

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder customerId(String customerId){
            this.customerId = customerId;
            return this;
        }
        public Builder items (List<String> items){
            this.items = items;
            return this ;
        }
        public Builder addItems (String item){
            this.items.add(item);
            return this ;
        }
        public Builder express (boolean express){
            this.express= express;
            return this ;
        }
        public Order build(){
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                ", express=" + express +
                '}';
    }
}

class Builder {
    public static void main(String[] args) {
        Order order = new Order.Builder()
                .id("ezae")
                .customerId("zeza")
                .addItems("qzezae")
                .express(true).build();
        System.out.println(order);
    }
}
