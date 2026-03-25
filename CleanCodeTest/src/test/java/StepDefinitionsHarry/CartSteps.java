
package StepDefinitionsHarry;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BDD.Harry.Cart;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class CartSteps {

    private Cart cart;

    @Given("the unit price of a book is {int} euros")
    public void theUnitPriceOfABookIs (int price){
        cart = new Cart(price);
    }

    @When("I add {int} copy/copies of book {int} to my cart")
    public void iAddCopiesOfBookToMyCart (int quantity,int bookNumber){
        cart.addBook(bookNumber,quantity);
    }

    @When("my cart is empty")
    public void myCartIsEmpty(){
        cart = new Cart(8);
    }

    @Then("the total price is {double} euros")
    public void theTotalPriceIs(double expectedPrice){
        double actualPrice = cart.calculateTotalPrice();
        assertThat(actualPrice)
                .as("Price total")
                .isCloseTo(expectedPrice,within(0.001));
    }

}
