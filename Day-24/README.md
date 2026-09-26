# Day 24 - Trapping Rain Water

## Problem Title
**Trapping Rain Water (LeetCode 42)**

## Problem Statement
Given an array height where each value represents the height of a vertical bar, calculate how much rainwater can be trapped after raining.

## Example Input
height = [0,1,0,2,1,0,1,3,2,1,2,1]

## Example Output
6

## Explanation
Water above an index depends on the shorter of the tallest bar on its left and the tallest bar on its right.

waterAtIndex = min(leftMax, rightMax) - height[index]

The two-pointer method keeps the best boundary seen from both sides. The side with the smaller current height is processed first because its trapped water is limited by that side's maximum boundary.

## Approach
1. Start two pointers at the left and right ends.
2. Track leftMax and rightMax, the highest bars seen so far from each side.
3. If height[left] <= height[right], process the left side and update leftMax or add trapped water.
4. Otherwise, process the right side similarly.
5. Continue until the pointers meet.

This avoids building separate prefix and suffix arrays.

## Java Solution Reference
See TrappingRainWater.java in this folder.

## Time Complexity
O(N) time, where N is the number of bars.

## Space Complexity
O(1) auxiliary space.

## Key Learning / Pattern
Two Pointers with Running Boundary Maximums.
This pattern reduces the usual O(N) extra-space solution to O(1) auxiliary space by processing the side whose current boundary is smaller.
