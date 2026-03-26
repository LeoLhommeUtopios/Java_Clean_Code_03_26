package org.example.KataBase;

import java.time.Duration;

public class ParkingService {
    public double calculate(Session s, boolean applyPromo) {
        if (s == null || s.in == null || s.out == null) return 0.0;

        long minutes = Duration.between(s.in, s.out).toMinutes();
        if (minutes <= 15) {
            return 0.0;
        }

        double rate;
        if ("CAR".equals(s.vehicleType)) {
            rate = 3.0;
        } else if ("MOTORBIKE".equals(s.vehicleType)) {
            rate = 2.0;
        } else if ("TRUCK".equals(s.vehicleType)) {
            rate = 6.0;
        } else {
            rate = 3.0;
        }

        double hoursCharged = Math.ceil((minutes - 15) / 60.0);

        double total = rate * hoursCharged;

        if (s.wknd) {
            total = total * 0.9; // -10%
        }

        if (applyPromo && s.promo != null && "PROMO10".equalsIgnoreCase(s.promo)) {
            total = total * 0.9; // -10% supplémentaire
        }

        if (total > 18.0) {
            total = 18.0;
        }

        total = PriceUtils.rnd(total);
        total = PriceUtils.roundToCents(total);

        if (s.zone != null && s.zone.startsWith("X")) {
            total = total + 0.0;
        }

        return total;
    }


    public double legacy(Session s) {
        return 42.0;
    }
}
