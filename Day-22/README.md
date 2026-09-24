# Day 22 - Coin Change

## Problem Title

**Coin Change (LeetCode 322)**

## Problem Statement

You are given an integer array `coins`, where `coins[i]` represents a coin denomination, and an integer `amount` representing a total amount of money.

Return the fewest number of coins needed to make exactly `amount`. You may use each coin denomination any number of times. If the amount cannot be formed, return `-1`.

## Example Input

```text
coins = [1, 2, 5], amount = 11
```

## Example Output

```text
3
```

## Explanation

The minimum number of coins is `3`: `5 + 5 + 1 = 11`.

## Approach

Use bottom-up dynamic programming.

- `minimumCoins[x]` stores the minimum coins required to make amount `x`.
- Initialize every value to `amount + 1`, which acts as an unreachable marker.
- `minimumCoins[0] = 0` because zero coins are needed to make amount `0`.
- For every amount from `1` to `amount`, try every coin that is not larger than the current amount.
- If the coin is usable, update the answer with:

```text
minimumCoins[currentAmount] = min(
    minimumCoins[currentAmount],
    minimumCoins[currentAmount - coin] + 1
)
```

If `minimumCoins[amount]` is still unreachable, return `-1`.

## Java Solution Reference

See [`CoinChange.java`](./CoinChange.java).

## Time Complexity

`O(amount * number of coin denominations)`

## Space Complexity

`O(amount)`

## Key Learning / Pattern

**Dynamic Programming: unbounded knapsack pattern**

This problem teaches how to build the answer for a larger amount from answers to smaller amounts. Because every denomination can be reused, it is an important example of **unbounded choice dynamic programming**.
