package org.example.Kata1;

import org.example.Kata1.model.Order;

public interface NotificationService {
    void sendOrderConfirmation(Order order, double total);
}
