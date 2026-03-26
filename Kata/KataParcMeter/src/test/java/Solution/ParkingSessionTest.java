package Solution;


import org.example.Solution.ParkingSession;
import org.example.Solution.ValueObject.Price;
import org.example.Solution.Strategy.PromoCode;
import org.example.Solution.ValueObject.VehicleType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkingSessionTest {
    @Test
    void should_calculate_weekend_discount_correctly() {
        var session = new ParkingSession(
                VehicleType.CAR,
                LocalDateTime.of(2025, 1, 4, 10, 0),
                LocalDateTime.of(2025, 1, 4, 11, 0),
                PromoCode.none(),
                true
        );
        assertThat(session.calculateCost(false)).isEqualTo(Price.of(2.70));
    }

    @Test
    void should_apply_daily_cap() {
        var session = new ParkingSession(
                VehicleType.TRUCK,
                LocalDateTime.of(2025, 1, 7, 8, 0),
                LocalDateTime.of(2025, 1, 7, 18, 0), // 10h
                PromoCode.none(),
                false
        );
        assertThat(session.calculateCost(false)).isEqualTo(Price.of(18.00));
    }
}
