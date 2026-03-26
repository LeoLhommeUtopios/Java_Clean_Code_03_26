package org.example.Kata1;

import org.example.Kata1.exceptions.InsufficientStockException;
import org.example.Kata1.exceptions.InvalidOrderException;
import org.example.Kata1.model.Item;
import org.example.Kata1.model.Order;

public class OrderManager {
    private StockService stockService;
    private TaxService taxService;
    private NotificationService notificationService;

    public OrderManager(StockService stockService, TaxService taxService, NotificationService notificationService) {
        this.stockService = stockService;
        this.taxService = taxService;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order) throws InvalidOrderException, InsufficientStockException {
        validateOrder(order);
        checkStock(order);

        double subtotal = calculateSubtotal(order);
        double total = calculateTotal(subtotal);

        updateStock(order);
        notificationService.sendOrderConfirmation(order,total);
    }

    private void validateOrder(Order order) throws InvalidOrderException  {
        if(order == null || order.getItems() == null || order.getItems().isEmpty()) {
            throw new InvalidOrderException("La commande est invalide");
        }
    }

    private double calculateSubtotal(Order order){
        return order.getItems().stream()
                .mapToDouble(item -> item.getPrice()*item.getQuantity())
                .sum();
    }

    private double calculateTotal(double subtotal) {
        double taxes = taxService.calculateTax(subtotal);
        return subtotal+taxes;
    }

    private void checkStock(Order order) throws InsufficientStockException {
        for (Item item : order.getItems()) {
            int availableStock = stockService.getStockForItem(item);
            if (availableStock < item.getQuantity()) {
                throw new InsufficientStockException(
                        "Stock insuffisant pour l'article : " + item.getName()+
                        ", Stock disponible"+availableStock+
                        ",quantité demandé : "+item.getQuantity()
                );
            }
        }
    }

    private void updateStock(Order order) {
        order.getItems()
                .forEach(item ->
                        stockService.updateStock(item,item.getQuantity())
                );
    }

}

