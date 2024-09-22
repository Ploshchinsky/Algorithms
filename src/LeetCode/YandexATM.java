package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class YandexATM {
    private static final int[] NOMINALS = {50, 100, 500, 1_000, 5_000};
    private int[] balance;

    public YandexATM() {
        balanceInit();
    }

    private void balanceInit() {
        balance = new int[NOMINALS.length];
        Arrays.fill(balance, 10);
    }

    public Map<Integer, Integer> withdraw(int amount) {
        Map<Integer, Integer> result = new HashMap<>();

        if (totalBalance() < amount || !amountIsCorrect(amount)) {
            return null;
        }

        while (amount > 0) {
            for (int i = balance.length - 1; i >= 0; i--) {
                while (balance[i] > 0 && NOMINALS[i] <= amount) {
                    amount -= NOMINALS[i];
                    balance[i]--;
                    result.put(NOMINALS[i], result.getOrDefault(NOMINALS[i], 0) + 1);
                }
            }
        }
        return result;
    }

    private boolean amountIsCorrect(int amount) {
        return amount % 50 == 0;
    }

    private int totalBalance() {
        int result = 0;
        for (int i = 0; i < balance.length; i++) {
            result += balance[i] * NOMINALS[i];
        }
        return result;
    }

    public static void main(String[] args) {
        YandexATM atm = new YandexATM();
        System.out.println(atm.withdraw(12_350));
    }
}
