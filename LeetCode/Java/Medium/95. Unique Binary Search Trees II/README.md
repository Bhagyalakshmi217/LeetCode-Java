# 📝 95. Unique Binary Search Trees II (LeetCode)

🔗 [Problem Link](https://leetcode.com/problems/unique-binary-search-trees-ii/)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Backtracking, Tree, Binary Search Tree, Binary Tree

### 🚀 Performance
- **Runtime:** 1 ms
- **Memory:** 45 MB

---

### 📜 Problem Description

Given an integer  `n` , return  *all the structurally unique  **BST'** s (binary search trees), which has exactly*  `n`  *nodes of unique values from*   `1`   *to*   `n` . Return the answer in  **any order** .

**Example 1:**

 ![image](https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg) 

```
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

```

**Example 2:**

```
Input: n = 1
Output: [[1]]

```

**Constraints:**

	
- `1 <= n <= 8`