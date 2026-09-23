# Day 21 - Find Minimum in Rotated Sorted Array

## Problem Title
Find Minimum in Rotated Sorted Array (LeetCode 153)

## Problem Statement
You are given an array of distinct integers that was originally sorted in ascending order and then rotated an unknown number of times. Return the minimum element in the array.

The solution should run in `O(log N)` time.

## Example Input
```text
nums = [4, 5, 6, 7, 0, 1, 2]
```

## Example Output
```text
0
```

## Explanation
The original sorted array was `[0, 1, 2, 4, 5, 6, 7]`. After rotation, the smaller values moved to the end of the array. The minimum value is the point where the sorted order starts again.

## Approach
Use binary search on the rotated sorted array:

1. Keep two pointers: `left` and `right`.
2. Compare the middle value with the rightmost value.
3. If `nums[middle] > nums[right]`, the minimum must be to the right of `middle`.
4. Otherwise, the minimum is at `middle` or somewhere to its left.
5. When `left == right`, that index stores the minimum element.

This works because at least one side of the rotated array is always sorted, allowing us to discard half of the search space each iteration.

## Java Solution Reference
See [`FindMinimumInRotatedSortedArray.java`](./FindMinimumInRotatedSortedArray.java).

## Time Complexity
`O(log N)`

## Space Complexity
`O(1)` auxiliary space.

## Key Learning / Pattern
- Binary search on a rotated sorted array.
- Use the right boundary to decide which half contains the minimum.
- Calculate the middle index as `left + (right - left) / 2` to avoid integer overflow.
- When binary search asks for a minimum, keep the possible answer by moving `right = middle` instead of skipping `middle`.
