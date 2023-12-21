
# Arrays and Strings `v0`

## Two Pointer
Two pointers is an extremely common technique used to solve array and string problems. It involves having two integer variables that both move along an iterable. This means we will have two integers, usually named something like <code>i</code> and `j`, or left and right which each represent an index of the array or string.

---
## Sliding Window
Like two pointers, sliding windows work the same with arrays and strings - the important thing is that they're iterables with **ordered elements**. For the sake of brevity, the first part of this article up until the examples will be focusing on arrays. However, all the logic is identical for strings.

### Subarrays
Given an array, a subarray is a contiguous section of the array. All the elements must be adjacent to each other in the original array and in their original order. For example, with the array [1, 2, 3, 4], the subarrays (grouped by length) are:

* [1], [2], [3], [4]
* [1, 2], [2, 3], [3, 4]
* [1, 2, 3], [2, 3, 4]
* [1, 2, 3, 4]

A subarray can be defined by two indices, the start and end. For example, with [1, 2, 3, 4], the subarray [1, 2, 3] has a starting index of 0 and an ending index of 2. Let's call the starting index the **left bound** and the ending index the **right bound**. Another name for subarray in this context is "window".

### When should we use sliding window?
There is a very common group of problems involving subarrays that can be solved efficiently with sliding window. Let's talk about how to identify these problems.

First, the problem will either explicitly or implicitly define criteria that make a subarray "valid".