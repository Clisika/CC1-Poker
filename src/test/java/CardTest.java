import org.example.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CardTest {
    @Test
    void testCreationCarte() {
        Card card = new Card(14, "Spades");
        Assertions.assertEquals(14, card.getValue());
        Assertions.assertEquals("Spades", card.getSuit());
    }
}
