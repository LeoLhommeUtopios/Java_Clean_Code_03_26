import org.example.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    void shouldHaveIsValidMethode(){
        Assertions.assertDoesNotThrow(()->passwordValidator.isValid("test"));
    }

    @Test
    void shouldReturnTrueForPasswordWith8orMoreChareacters(){
        boolean result = passwordValidator.isValid("motdepasse");
        Assertions.assertTrue(result);
    }

    @Test
    void souldReturnFalseForPasswordWithLessThen8Characters(){
        boolean result = passwordValidator.isValid("court");
        Assertions.assertFalse(result);
    }
}
