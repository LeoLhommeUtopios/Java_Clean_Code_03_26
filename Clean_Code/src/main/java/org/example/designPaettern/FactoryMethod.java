package org.example.designPaettern;

interface Transport {
    String deliver(String payload);
}

class Truc implements Transport{
    @Override
    public String deliver(String payload) {
        return "Road "+payload;
    }
}
class Ship implements Transport{
    @Override
    public String deliver(String payload) {
        return "Sea "+payload;
    }
}

abstract class Logistics{
    public String planDelivry(String payload){
        Transport t = createTransport();
        return t.deliver(payload);
    }
    protected abstract Transport createTransport();
}

class RoadLogistics extends Logistics{

    @Override
    protected Transport createTransport() {
        return new Truc();
    }
}
class SeaLogistics extends Logistics{

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {

        Logistics logistics = new RoadLogistics();
        System.out.println(logistics.planDelivry("Package 1"));

        logistics = new SeaLogistics();
        System.out.println(logistics.planDelivry("Package 2"));
    }
}
