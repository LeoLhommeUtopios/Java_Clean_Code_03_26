package org.example.KataBase;

public class PriceUtils {
    public static double rnd(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
    public static double roundToCents(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
