package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;

public class PokerEvaluator {

    public static int evaluate(int[][] hand) {
        Map<Integer, Integer> valueCounts = new HashMap<>();
        for (int[] card : hand) {
            int value = card[0];
            valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);
        }

        // 4 même cartes
        for (int count : valueCounts.values()) {
            if (count == 4) {
                return 60;
            }
        }

        // Full
        if (valueCounts.containsValue(3) && valueCounts.containsValue(2)) {
            return 50;
        }

        // Brelan
        for (int count : valueCounts.values()) {
            if (count == 3) {
                return 30;
            }
        }

        // Suite
        if (isStraight(hand)) {
            return 40;
        }

        // Couleur
        if (isFlush(hand)) {
            return 45;
        }

        // Carte haute
        int maxValue = 0;
        for (int[] card : hand) {
            if (card[0] > maxValue) {
                maxValue = card[0];
            }
        }
        return maxValue;

    }

    private static boolean isStraight(int[][] hand) {
        int[][] sortedHand = hand.clone();
        Arrays.sort(sortedHand, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < sortedHand.length - 1; i++) {
            if (sortedHand[i + 1][0] != sortedHand[i][0] + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFlush(int[][] hand) {
        int firstSuit = hand[0][1];
        for (int i = 1; i < hand.length; i++) {
            if (hand[i][1] != firstSuit) {
                return false;
            }
        }
        return true;
    }
}