import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] minimumCoins = new int[amount + 1];
        Arrays.fill(minimumCoins, amount + 1);
        minimumCoins[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    minimumCoins[currentAmount] = Math.min(
                            minimumCoins[currentAmount],
                            minimumCoins[currentAmount - coin] + 1
                    );
                }
            }
        }

        return minimumCoins[amount] == amount + 1 ? -1 : minimumCoins[amount];
    }
}
