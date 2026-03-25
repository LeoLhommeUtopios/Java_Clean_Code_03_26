package SolutionKataTDD;

import org.example.SolutionKataTDD.FoodItem;
import org.example.SolutionKataTDD.SmartRefrigerator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SmartRefrigeratorTest {

    private SmartRefrigerator fridge;

    @BeforeEach
    void setUp(){
        fridge = new SmartRefrigerator();
    }
    @Test
    void shouldBeEmptyWhenCreated (){
        assertTrue(fridge.isEmpty());
    }
    @Test
    void shouldNotBeEmptyAfterAddingItem(){
        LocalDateTime expirationdateTime = LocalDateTime.now().plusDays(3);
        String nameItem = "lait";

        fridge.addItem(nameItem,expirationdateTime);

        assertFalse(fridge.isEmpty());
    }

    @Test
    void shouldReturnAddedItem(){
        LocalDateTime expirationdateTime = LocalDateTime.now().plusDays(3);
        String nameItem = "lait";

        fridge.addItem(nameItem,expirationdateTime);
        List<FoodItem> foodItems = fridge.getItems();
        assertEquals(1,foodItems.size());
    }

    @Test
    void shouldStroreFoodItemAddedItems(){
        LocalDateTime expirationdateTime = LocalDateTime.now().plusDays(3);
        String nameItem = "lait";

        fridge.addItem(nameItem,expirationdateTime);
        List<FoodItem> foodItems = fridge.getItems();
        FoodItem foodItem = foodItems.get(0);
        assertEquals(nameItem,foodItem.getNameItem());
        assertEquals(expirationdateTime,foodItem.getExpirationDateTime());
    }

    @Test
    void shouldDeacressedExpirationDateWhenFridgeIsOpenBy1hourifFoodItemIsSealed(){
        LocalDateTime expirationdateTime = LocalDateTime.now().plusDays(3);
        String nameItem = "lait";

        fridge.addItem(nameItem,expirationdateTime);
        fridge.open();
        List<FoodItem> foodItems = fridge.getItems();

        FoodItem foodItem = foodItems.get(0);;
        assertEquals(expirationdateTime.minusHours(1),foodItem.getExpirationDateTime());
    }

    @Test
    void shouldDeacressedExpirationDateWhenFridgeIsOpenBy5hourifFoodItemIsNotSealed(){
        LocalDateTime expirationdateTime = LocalDateTime.now().plusDays(3);
        String nameItem = "lait";

        fridge.addItem(nameItem,expirationdateTime);
        List<FoodItem> foodItems = fridge.getItems();
        FoodItem foodItem = foodItems.get(0);
        foodItem.unSeal();
        fridge.open();
        foodItems = fridge.getItems();
        foodItem = foodItems.get(0);
        assertEquals(expirationdateTime.minusHours(5),foodItem.getExpirationDateTime());
    }
}
