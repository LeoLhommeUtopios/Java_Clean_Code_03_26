package org.example.KataBase;

public class InvoicePrinter {
    public String print(Session s, ParkingService svc) {

        double price = svc.calculate(s, /*applyPromo*/ true);
        String v = s.vehicleType;
        String wk = s.wknd ? "WEEKEND" : "WEEKDAY";
        String pr = (s.promo != null) ? s.promo : "NO_PROMO";

        return "INVOICE[" + v + ";" + wk + ";" + pr + "]=" + price + "€";
    }

    public double getPrice(Session s, ParkingService p) {
        return p.calculate(s, true);
    }
}
