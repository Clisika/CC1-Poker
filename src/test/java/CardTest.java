import org.example.Card;
import org.example.PokerEvaluator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class CardTest {
    @Test
    void testCreationCarte() {
        Card card = new Card(14, "Spades");
        Assertions.assertEquals(14, card.getValue());
        Assertions.assertEquals("Spades", card.getSuit());
    }

    @Test
    void shouldReturnStraight() {
        int[][] hand = {
                {5, 1},
                {6, 1},
                {7, 1},
                {8, 1},
                {9, 1}
        };

        int score = PokerEvaluator.evaluate(hand);
        assertEquals(40, score);
    }

    @Test
    void shouldReturnFlush() {
        int[][] hand = {
                {2, 1},
                {7, 1},
                {9, 1},
                {11, 1},
                {13, 1}
        };

        int score = PokerEvaluator.evaluate(hand);
        assertEquals(45, score);
    }
}

