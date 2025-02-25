## Overview
This project is a collection of fully functional examples written in Java programming language, showing how to implement 14 typical algorithms && data Structures from sketch. It is created with ambition to make a short, complete and realistic DSA study guide for coding interviews as well as competitive programming.

1. LinearSearch 线性查找
2. SelectionSort 选择排序
3. InsertionSort 插入排序
4. QuickSort 快速排序
5. Array
6. Stack & Queue
  * Stack (将增删操作限制为单侧，并且数据满足后入先出 LIFO)
    * ARStack
    * LLStack
  * Queue (数据满足先入先出 FIFO)
    * ARQueue
    * LLQueue
    * CircularQueue 循环队列
    * PriorityQueue 优先队列
7. LinkedList
  * ListNode
8. Recursion 递归构造
9. MergeSort 归并排序
10. QuickSort 快速排序
11. BinarySearchTree 二分搜索树 (左子树中所有元素小于当前节点元素，右子树中所有元素大于当前节点元素)
  * TreeNode
12. Set&Map 集合与映射
13. Heap 堆



| LL      | BST     |  
| -------- | ------- | 
| E e<br>Node next | E e<br>Node left<br>Node right  |  
| Node head<br>int size| Node root<br>int size |



| Set      | Map     |  
| -------- | ------- | 
|void add(E)<br>void remove(E)<br>boolean contains(E)<br>int getSize()<br>boolean isEmpty()  | void add(K, V)<br>V remove(K)<br>boolean contains(K)<br>V get(K)<br>void set(K,V)<br>int getSize()<br>boolean isEmpty()   |     


## Stack
* ARStack
* LLStack (栈内元素数量不可预料，时大时小)
## Queue
* Deque
* PriorityQueue
* BlockingQueue (ARBlockingQueue, LLBlockingQueue, PriorityBlockingQueue)

## List
* ArrayList
* LinkedList
* Vector
## Set
HashSet
SortedSet, TreeSet
ConcurrentSkipListSet

## Map
HashMap
TreeMap
ConcurrentHashMap




## Problem Set

|  #  |      Title     |   Code   |    Document   |  Video  | Difficulty  | Tag                   
|-----|----------------|----------|---------------|---------|-------------|--------
|1|Absolute value||[Theory](https://www.geeksforgeeks.org/program-to-find-absolute-value-of-a-given-number/)||:green_square: Easy| abs() |
|2| Celsius To Fahrenheit ||[Theory](https://www.geeksforgeeks.org/program-celsius-fahrenheit-conversion/)||:green_square: Easy| Math |
|3| Roots of Quadratic equation||[Theory](https://www.geeksforgeeks.org/program-to-find-the-roots-of-quadratic-equation/)||:green_square: Easy| Math |
|4| [Factorial Of Number](https://practice.geeksforgeeks.org/problems/factorial5739/1)||||:green_square: Easy| Math |
|5| [Count digits in a factorial ](https://practice.geeksforgeeks.org/problems/count-digits-in-a-factorial3957/1)||||:green_square: Easy| Factorial, Math |
|6| [Series GP](https://practice.geeksforgeeks.org/problems/series-gp4646/1)||||:green_square: Easy| Basic Math |
|7| [Prime Number](https://practice.geeksforgeeks.org/problems/prime-number2314/1)||||:green_square: Easy| Basic Math |
|8| Exactly 3 Divisors ||[Theory](https://www.geeksforgeeks.org/numbers-exactly-3-divisors/)||:green_square: Easy| Basic Math |
|9| Addition Under Modulo||[Theory](https://www.geeksforgeeks.org/sum-of-two-numbers-modulo-m/)||:green_square: Easy| Modulo |
|10| Multiplication Under Modulo||[Theory](https://www.geeksforgeeks.org/multiply-large-integers-under-large-modulo/)||:green_square: Easy| Modulo |
|11| [Modular Multiplicative Inverse](https://practice.geeksforgeeks.org/problems/modular-multiplicative-inverse-1587115620/1)||||:green_square: Easy| Modulo |
|12| [Trailing zeroes in factorial](https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1)||||:orange_square: Medium| Logic |
|13| [Prime Factors ](https://practice.geeksforgeeks.org/problems/prime-factors5052/1)||||:orange_square: Medium| Prime |


出现频度为5： 
1. Leet Code OJ 1. Two Sum [Difficulty: Easy] 
2. Leet Code OJ 8. String to Integer (atoi) [Difficulty: Easy] 
3. Leet Code OJ 15. 3Sum [Difficulty: Medium] 
4. Leet Code OJ 20. Valid Parentheses [Difficulty: Easy] 
5. Leet Code OJ 21. Merge Two Sorted Lists [Difficulty: Easy] 
6. Leet Code OJ 28. Implement strStr() [Difficulty: Easy] 
7. Leet Code OJ 56. Merge Intervals [Difficulty: Hard] 
8. Leet Code OJ 57. Insert Interval [Difficulty: Hard] 
9. Leet Code OJ 65. Valid Number [Difficulty: Hard] 
10. Leet Code OJ 70. Climbing Stairs [Difficulty: Easy] 
11. Leet Code OJ 73. 链式结构.Set Matrix Zeroes [Difficulty: Medium] 
12. Leet Code OJ 88. Merge Sorted Array [Difficulty: Easy] 
13. Leet Code OJ 98. Validate Binary Search Tree [Difficulty: Medium] 
14. Leet Code OJ 125. Valid Palindrome [Difficulty: Easy] 
15. Leet Code OJ 127. Word Ladder [Difficulty: Medium]

出现频度为4： 
1. Leet Code OJ 2. Add Two Numbers [Difficulty: Medium] 
2. Leet Code OJ 12. Integer to Roman 
3. Leet Code OJ 13. Roman to Integer 
4. Leet Code OJ 22. Generate Parentheses 
5. Leet Code OJ 23. Merge k Sorted Lists 
6. Leet Code OJ 24. Swap Nodes in Pairs 
7. Leet Code OJ 27. Remove Element [Difficulty: Easy] 
8. Leet Code OJ 46. Permutations 
9. Leet Code OJ 49. Anagrams 
10. Leet Code OJ 67. Add Binary 
11. Leet Code OJ 69. Sqrt(x) 
12. Leet Code OJ 77. Combinations 
13. Leet Code OJ 78. Subsets 
14. Leet Code OJ 79. Word Search 
15. Leet Code OJ 91. Decode Ways [Difficulty: Medium] 
16. Leet Code OJ 102. Binary Tree Level Order Traversal [Difficulty: Easy] 
17. Leet Code OJ 129. Sum Root to Leaf Numbers 
18. Leet Code OJ 131. Palindrome Partitioning

## Reference
1.  https://chasserush.github.io/DataStructureVisualizations/
LixiangZhao commit

LixiangZhao has been invited as a collaborator of this project.
