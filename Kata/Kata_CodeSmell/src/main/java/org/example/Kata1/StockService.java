package org.example.Kata1;

import org.example.Kata1.model.Item;

public interface StockService {
    int getStockForItem(Item item);
    void updateStock(Item item, int quantity);
}
