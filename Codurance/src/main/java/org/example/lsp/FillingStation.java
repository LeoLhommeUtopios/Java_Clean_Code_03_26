package org.example.lsp;


public class FillingStation {

    public void refuel(FuelVehicle vehicle) {
            vehicle.fillUpWithFuel();
    }

    public void charge(ElectricCar vehicle) {
            vehicle.chargeBattery();
    }
}
