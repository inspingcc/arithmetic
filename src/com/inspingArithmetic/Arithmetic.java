package com.inspingArithmetic;

import java.util.*;

public class Arithmetic {
    public static void main(String[] args) {
        Arithmetic c = new Arithmetic();

        // 001 爬梯子 - 菲波那切数列
//        System.out.println(climbStairsWithF(3));
        // 9. 回文数
//        System.out.println(c.isPalindrome2(0));
        // 78. 子集
//        List<List<Integer>> ans = c.subsets3(new int[]{1, 2, 3, 4});
        // 22. 括号生成
//        System.out.println(c.generateParenthesis(3));
        // 53.n 皇后问题
//        List<List<String>> records = c.solveNQueens(1);
//        for (int i = 0; i < records.size(); i++) {
//            System.out.println("解法:" + (i + 1));
//            for (int j = 0; j < records.get(i).size(); j++) {
//                System.out.println(records.get(i).get(j));
//            }
//            System.out.println();
//        }
        //  46. 全排列
//        System.out.println(c.permute(new int[]{1, 2, 3}));
        // 47. 全排列 II
//        System.out.println(c.permuteUnique(new int[]{3, 1, 1, 3}));

        // 338. 比特位计数
//        System.out.println(Arrays.toString(c.countBits(8)));

        // 144. 二叉树的前序遍历
        // 94. 二叉树的中序遍历
        // 145. 二叉树的后序遍历 (前序的倒序输出)

        // 39. 组合总和
//        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));

        // 344. 反转字符串
//        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
//        c.reverseString(s);
//        System.out.println(s);

        // 289. 生命游戏
//        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
//        c.gameOfLife(board);
//        System.out.println(new ArrayList<>(Arrays.asList(board)));

        // 73. 矩阵置零
//        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        c.setZeroes(matrix);

        // 171. Excel表列序号
//        System.out.println(c.titleToNumber("ZY"));
        // // 168. Excel表列名称
//        System.out.println(c.convertToTitle(701));
        // 118. 杨辉三角
//        System.out.println(c.generate(5));
        // 48. 旋转图像
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        c.rotate(matrix);
        // 131. 分割回文串
//        System.out.println(c.partition("aab"));
        // // 287. 寻找重复数
//        System.out.println(c.findDuplicate(new int[]{1, 2, 2, 3, 4}));
        // 283. 移动零
//        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{-10,-3,0,5,9};
//        c.moveZeroes(nums);
//        System.out.println(nums);
        // 204. 计数质数
//        System.out.println(c.countPrimes(25));
        // 292. Nim 游戏
//        System.out.println(c.canWinNim(25));
        // 557. 反转字符串中的单词 III
//        System.out.println(c.reverseWords("Let's take LeetCode contest"));
        // 108. 将有序数组转换为二叉搜索树
//        c.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        // 13. 罗马数字转整数
//        System.out.println(c.romanToInt("LVIII"));
        // 242. 有效的字母异位词
//        System.out.println(c.isAnagram("a","b"));
        // 121. 买卖股票的最佳时机
//        int[] prices = new int[]{1, 2, 3, 4, 5};
//        System.out.println(c.maxProfit2(prices));
        // 202. 快乐数
//        System.out.println(c.isHappy(4));
        // 263. 丑数
//        System.out.println(c.isUgly(4));
        // 264. 丑数II
//        System.out.println(c.nthUglyNumber(12));
        // 313. 超级丑数
//        System.out.println(c.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
        // 235. 二叉搜索树的最近公共祖先
        // 155. 最小栈
//        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        minStack.push(3);
//        minStack.push(4);
//        System.out.println(minStack.getMin());
//        minStack.pop();
        // 53. 最大子序和
//        System.out.println(c.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // 231. 2的幂
//        System.out.println(c.isPowerOfTwo(5));
        // 26. 删除排序数组中的重复项
//        System.out.println(c.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        // 88. 合并两个有序数组
//        int[] nums1 = new int[]{2,0};
//        int[] nums2 = new int[]{1};
//        c.merge(nums1, 1, nums2, 1);
        // 141. 环形链表
        // 20. 有效的括号
//        System.out.println(c.isValid("({())}"));
        // 14. 最长公共前缀
//        System.out.println(c.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        // 7. 整数反转
//        System.out.println(c.reverse(123));
        // 59. 螺旋矩阵 II
//        System.out.println(c.generateMatrix(3));
        // 4. 寻找两个有序数组的中位数

    }

    // 4. 寻找两个有序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1; // i 太小了
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1; // i 太大了
            } else { // i 刚刚好
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    // 59. 螺旋矩阵 II
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;    // 左右上下的边界
        int num = 1, total = n * n;
        while (num <= total) {
            for (int i = l; i <= r; i++) {
                ans[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                ans[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                ans[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                ans[i][l] = num++;
            }
            l++;
        }
        return ans;
    }

    private void generateMatrixOut(int[][] ans, int n) {

    }

    // 7. 整数反转
    public int reverse(int x) {
        int newX = 0;
        while (x != 0) {
            int end = x % 10;
            x /= 10;
            if (newX > Integer.MAX_VALUE / 10 || (newX == Integer.MAX_VALUE / 10 && end > 7)) return 0;
            if (newX < Integer.MIN_VALUE / 10 || (newX == Integer.MIN_VALUE / 10 && end < -8)) return 0;
            newX = newX * 10 + end;
        }
        return newX;
    }

    // 14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        int index = 0;
        OUTER:
        while (true) {
            if (strs[0].length() - 1 < index) {
                break;
            }
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() - 1 < index || ch != strs[i].charAt(index)) {
                    break OUTER;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    // 20. 有效的括号
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    characterStack.push(ch);
                    break;
                case ')':
                    if (characterStack.isEmpty()) return false;
                    if ('(' == characterStack.peek()) {
                        characterStack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (characterStack.isEmpty()) return false;
                    if ('{' == characterStack.peek()) {
                        characterStack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (characterStack.isEmpty()) return false;
                    if ('[' == characterStack.peek()) {
                        characterStack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return characterStack.isEmpty();
    }

    // 141. 环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1, nIndex = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nIndex < 0) {
                break;
            }
            if (mIndex < 0) {
                nums1[i] = nums2[nIndex--];
                continue;
            }
            if (nums1[mIndex] > nums2[nIndex]) {
                nums1[i] = nums1[mIndex--];
            } else {
                nums1[i] = nums2[nIndex--];
            }
        }

    }

    // 26. 删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int newLen = nums.length;
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                newLen--;
                offset++;
            } else {
                nums[i - offset] = nums[i];
            }
        }
        return newLen;
    }

    // 231. 2的幂
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & -n) == n;
    }

    // 53. 最大子序和(连续最大和的序列)
    public int maxSubArray(int[] nums) {
        int perSum = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                perSum += nums[i];
            } else {
                perSum = nums[i];
            }
            sum = Math.max(sum, perSum);
        }
        return sum;
    }

    // 160. 相交链表 (快慢指针的思想)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ta = headA;
        ListNode tb = headB;
        boolean aTurn = false;
        boolean bTurn = false;
        while (true) {
            if (ta == tb) {
                return ta;
            } else {
                if (ta.next == null) {
                    if (aTurn == false) {
                        ta = headB;
                        aTurn = true;
                    } else {
                        break;
                    }
                } else {
                    ta = ta.next;
                }

                if (tb.next == null) {
                    if (bTurn == false) {
                        tb = headA;
                        bTurn = true;
                    } else {
                        break;
                    }
                } else {
                    tb = tb.next;
                }
            }
        }
        return null;
    }

    // 155. 最小栈
    static class MinStack {
        /**
         * initialize your data structure here.
         */
        Stack<Integer> data;
        Stack<Integer> helper;

        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (helper.isEmpty() || x <= helper.peek()) {
                helper.push(x);
            }
        }

        public void pop() {
            if (!data.isEmpty()) {
                if (data.peek().equals(helper.peek())) {
                    helper.pop();
                }
                data.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return helper.peek();
        }
    }

    // 217. 存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    // 235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int nodeVal = node.val;
            if (pVal > nodeVal && qVal > nodeVal) {
                node = node.right;
            } else if (pVal < nodeVal && qVal < nodeVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    // 313. 超级丑数
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        nums[0] = 1;
        int[] primesIndex = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primesIndex.length; j++) {
                if (nums[primesIndex[j]] * primes[j] < min) {
                    min = nums[primesIndex[j]] * primes[j];
                }
            }
            nums[i] = min;
            for (int j = 0; j < primesIndex.length; j++) {
                if (nums[primesIndex[j]] * primes[j] == min) {
                    primesIndex[j]++;
                    System.out.println("\tj:" + j);
                }
            }
            System.out.println(nums[i]);
        }
        return nums[n - 1];
    }


    // 264. 丑数II
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0, index3 = 0, imdex5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[imdex5] * 5));
            if (min == nums[index2] * 2) index2++;
            if (min == nums[index3] * 3) index3++;
            if (min == nums[imdex5] * 5) imdex5++;
            nums[i] = min;
        }
        return nums[n - 1];
    }

    // 263. 丑数
    public boolean isUgly(int num) {
        if (num < 0) return false;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    // 202. 快乐数((快慢指针的思想))
    public boolean isHappy(int n) {
        int slow = n, fast = calcNextNumber(n);
        System.out.println("slow:" + slow + ",fast:" + fast);
        while (slow != fast) {
            slow = calcNextNumber(slow);
            fast = calcNextNumber(fast);
            fast = calcNextNumber(fast);
            System.out.println("slow:" + slow + ",fast:" + fast);
        }
        return slow == 1;
    }

    public int calcNextNumber(int n) {
        int m = 0;
        while (n > 0) {
            m += (n % 10) * (n % 10);
            n /= 10;
        }
        return m;
    }

    // 122. 买卖股票的最佳时机 II
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int minPrice = prices[0];
        int perProfit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                perProfit = prices[i] - minPrice;
            } else {
                minPrice = prices[i];
                maxProfit += perProfit;
                perProfit = 0;
            }
        }
        maxProfit += perProfit;
        return maxProfit;
    }

    // 121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    // 242. 有效的字母(适用于所有的字符)异位词
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> recordMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            recordMap.merge(s.charAt(i), 1, (a, b) -> a + b);
            recordMap.merge(t.charAt(i), -1, (a, b) -> a + b);
        }
        for (int v : recordMap.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    // 13. 罗马数字转整数
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'M': {
                    num += 1000;
                    continue;
                }
                case 'D': {
                    num += 500;
                    continue;
                }
                case 'C': {
                    num += 100;
                    continue;
                }
                case 'L': {
                    num += 50;
                    continue;
                }
                case 'X': {
                    num += 10;
                    continue;
                }
                case 'V': {
                    num += 5;
                    continue;
                }
                default: {
                    num += 1;
                    continue;
                }
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 'I' && (arr[i + 1] == 'V' || arr[i + 1] == 'X'))
                num -= 2;
            if (arr[i] == 'X' && (arr[i + 1] == 'L' || arr[i + 1] == 'C'))
                num -= 20;
            if (arr[i] == 'C' && (arr[i + 1] == 'D' || arr[i + 1] == 'M'))
                num -= 200;
        }
        return num;
    }

    // 108. 将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int i, int j) {
        TreeNode node = null;
        if (j - i == 0) {
            node = new TreeNode(nums[i]);
        } else if (j - i == 1) {
            node = new TreeNode(nums[j]);
            node.left = new TreeNode(nums[i]);
        } else if (j - i == 2) {
            node = new TreeNode(nums[i + 1]);
            node.left = new TreeNode(nums[i]);
            node.right = new TreeNode(nums[j]);
        } else {
            int mid = ((j - i) / 2) + i + 1;
            node = new TreeNode(nums[mid]);
            node.left = buildTree(nums, i, mid - 1);
            node.right = buildTree(nums, mid + 1, j);
        }
        return node;
    }

    // 557. 反转字符串中的单词 III
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    // 292. Nim 游戏
    public boolean canWinNim(int n) {
        return ((n & 3) != 0);
    }

    // 204. 计数质数
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    // 283. 移动零
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroIndex == -1) {
                    zeroIndex = i;
                }
            } else {
                if (zeroIndex != -1) {
                    nums[zeroIndex++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    List<List<String>> partitions;

    // 191. 位1的个数
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    // 412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(i + "");
            }
        }
        return ans;
    }

    //TODO 287. 寻找重复数
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len + 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int counter = 0;
            for (int num : nums) {
                if (num < mid) {
                    counter++;
                }
            }
            if (counter < mid) {
                left = mid;
            } else {
                right = right;
            }
        }
        return left;
    }

    // 131. 分割回文串
    public List<List<String>> partition(String s) {
        partitions = new ArrayList<>();
        Stack stack = new Stack();
        splitPartition(s, 0, s.length(), stack);
        return partitions;
    }

    public void splitPartition(String s, int i, int n, Stack stack) {
        if (i == n) {
            partitions.add(new ArrayList<>(stack));
            return;
        }
        for (int j = i + 1; j < n + 1; j++) {
            String subStr = s.substring(i, j);
            if (isHuiWen(subStr)) {
                stack.push(subStr);
                splitPartition(s, j, n, stack);
                stack.pop();
            }
        }
    }

    private boolean isHuiWen(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 48. 旋转图像
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                int a = i, b = j;
                for (int k = 0; k < 3; k++) {
                    matrix[a][b] = matrix[n - b - 1][a];
                    int t = n - b - 1;
                    b = a;
                    a = t;
                }
                matrix[a][b] = temp;
            }
        }
    }

    private void rotateOneTier(int[][] matrix, int i) {
        for (int j = i; j < matrix.length; j++) {

        }
    }


    // 118. 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }
        ans.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            temp[0] = 1;
            temp[i] = 1;
            for (int j = 1; j < i; j++) {
                temp[j] = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
            }
            ans.add(new ArrayList<>(Arrays.asList(temp)));
        }
        return ans;
    }

    // 168. Excel表列名称
    public String convertToTitle(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        while (n > 0) {
            int k = n % 26;
            // Z 的时候
            if (k == 0) {
                n -= 26;
                k = 26;
            }
            stringBuffer.insert(0, (char) (k - 1 + 'A'));
            n = n / 26;
        }
        return stringBuffer.toString();
    }

    // 171. Excel表列序号
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += (s.charAt(i) - 'A' + 1) * (Math.pow(26, (s.length() - i - 1)));
        }
        return num;
    }

    // 73. 矩阵置零
    public void setZeroes(int[][] matrix) {
        boolean firstColIsZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColIsZero = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColIsZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }


    }


    // 289. 生命游戏 (原地算法)
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                aliveOrDead(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void aliveOrDead(int[][] board, int i, int j) {
        int alive = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                // 边界问题
                if (k < 0 || l < 0 || k > board.length - 1 || l > board[0].length - 1) continue;
                if (k == i && l == j) continue;
                if (board[k][l] >= 1) {
                    alive++;
                }
            }
        }
        if (board[i][j] == 1) {
            if (alive < 2 || alive > 3) {
                // 死亡
                board[i][j] = 2;
            }
        } else {
            if (alive == 3) {
                // 复活
                board[i][j] = -1;
            }
        }
    }

    // 344. 反转字符串
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            s[i] ^= s[n - i - 1];
            s[n - i - 1] ^= s[i];
            s[i] ^= s[n - i - 1];
        }
    }

    // 114. 二叉树展开为链表
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        TreeNode pre = null;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }
            pre = node;

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void process() {

    }

    List<List<Integer>> combinationSumResult;

    // 40. 组合总和 II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinationSumResult = new ArrayList<>();
        Stack stack = new Stack();
        Arrays.sort(candidates);
        calcCombinationSum2(candidates, target, 0, candidates.length, stack);
        return combinationSumResult;
    }

    private void calcCombinationSum2(int[] candidates, int remain, int start, int n, Stack<Integer> stack) {
        if (remain == 0) {
            combinationSumResult.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < n; i++) {
            if (remain - candidates[i] < 0) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            stack.push(candidates[i]);
            calcCombinationSum2(candidates, remain - candidates[i], i + 1, n, stack);
            stack.pop();
        }
    }

    // 39. 组合总和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumResult = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        calcCombinationSum(candidates, target, 0, candidates.length, stack);
        return combinationSumResult;
    }

    private void calcCombinationSum(int[] candidates, int remain, int start, int n, Stack<Integer> stack) {
        if (remain == 0) {
            combinationSumResult.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < n; i++) {
            if (remain - candidates[i] < 0) break;
            stack.add(candidates[i]);
            calcCombinationSum(candidates, remain - candidates[i], i, n, stack);
            stack.pop();
        }
    }


    // 145. 二叉树的后序遍历 (前序的倒序输出)
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }

    // 144. 二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // 94. 二叉树的中序遍历 (迭代)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    // 94. 二叉树的中序遍历 (递归)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        midTraversalTree(root, result);
        return result;
    }

    private void midTraversalTree(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        midTraversalTree(root.left, result);
        midTraversalTree(root.right, result);
    }

    // 338. 比特位计数
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (1 & i);
        }
        return result;
    }

    // 47. 全排列 II
    static List<List<Integer>> permuteResult2;
    static boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        used = new boolean[n];
        permuteResult2 = new LinkedList<>();
        Arrays.sort(nums);
        Stack stack = new Stack();
        calcPermute2(nums, 0, n, stack);
        return permuteResult2;
    }

    public void calcPermute2(int[] nums, int i, int n, Stack stack) {
        if (i == n) {
            permuteResult2.add(new ArrayList<>(stack));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (used[j] == false) {
                if (j > 0 && nums[j] == nums[j - 1] && !used[j - 1]) {
                    continue;
                }
                used[j] = true;
                stack.push(nums[j]);
                calcPermute2(nums, i + 1, n, stack);
                stack.pop();
                used[j] = false;
            }
        }
    }


    //  46. 全排列
    static List<List<Integer>> permuteResult;

    public List<List<Integer>> permute(int[] nums) {
        permuteResult = new LinkedList<>();
        List<Integer> numsList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        int n = nums.length;
        calcPermute(0, numsList, n);
        return permuteResult;
    }

    public void calcPermute(int i, List<Integer> nums, int n) {
        if (i == n) {
            permuteResult.add(new LinkedList<>(nums));
            return;
        }
        for (int j = i; j < n; j++) {
            Collections.swap(nums, i, j);
            calcPermute(i + 1, nums, n);
            // 回溯回来
            Collections.swap(nums, i, j);
        }
    }


    public static List<List<String>> queueResults = new ArrayList<>();
    public static int[] mainDui;    // 主对角线
    public static int[] subDui;     // 副对角线
    public static int[] rows;       // 行

    // 53.n 皇后问题
    public List<List<String>> solveNQueens(int n) {
        queueResults = new ArrayList<>();
        mainDui = new int[2 * n - 1];
        subDui = new int[2 * n - 1];
        rows = new int[n];
        int[] queues = new int[n];
        calcQueue(0, n, queues);
        return queueResults;
    }

    private void calcQueue(int row, int n, int[] queues) {
        // 此时已经满足
        if (row == n) {
            recordResult(queues);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (canPlaceQueue(row, col, n, queues)) {
                // 假设当前皇后放在这
                rows[col] = 1;
                mainDui[row - col + n - 1] = 1;
                subDui[row + col] = 1;
                queues[row] = col;
                // 继续放下一个皇后
                calcQueue(row + 1, n, queues);
                // 下一个皇后已经不行了,回溯,当前皇后尝试其他位置
                rows[col] = 0;
                mainDui[row - col + n - 1] = 0;
                subDui[row + col] = 0;
                queues[row] = 0;
            }
        }
    }

    private boolean canPlaceQueue(int row, int col, int n, int[] queues) {
        int result = rows[col] + mainDui[row - col + n - 1] + subDui[row + col];
        return result == 0 ? true : false;
    }

    private void recordResult(int[] queues) {
        List<String> record = new ArrayList<>();
        for (int row = 0; row < queues.length; row++) {
            int col = queues[row];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < col; i++) {
                stringBuilder.append('.');
            }
            stringBuilder.append('Q');
            for (int i = 0; i < queues.length - col - 1; i++) {
                stringBuilder.append('.');
            }
            record.add(stringBuilder.toString());
        }
        queueResults.add(record);
    }


    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    // 22. 括号生成
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("()");
            return ans;
        }
        for (int i = 1; i < (1 << (2 * n - 1)); i++) {
            int num = 1;
            for (int j = 2 * n - 2; j >= 0; j--) {
                if ((i >> j & 1) == 1) {
                    num++;
                } else {
                    num--;
                }
                if (num < 0) break;
            }
            if (num == 0) {
                char[] tChar = new char[2 * n];
                tChar[0] = '(';
                int index = 1;
                for (int j = 2 * n - 2; j >= 0; j--) {
                    if ((i >> j & 1) == 1) {
                        tChar[index++] = '(';
                    } else {
                        tChar[index++] = ')';
                    }
                }
                ans.add(new String(tChar));
            }
        }
        return ans;
    }

    // 78. 子集 - 递归(回溯)
    public List<List<Integer>> subsets3(int[] nums) {
        // 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
        // 说明：解集不能包含重复的子集。
        if (nums.length == 0) {
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        }
        List<List<Integer>> ans = new ArrayList<>();
        int[] subNums = Arrays.copyOf(nums, nums.length - 1);
        int num = nums[nums.length - 1];
        List<List<Integer>> sub = subsets3(subNums);
        ans.addAll(sub);
        for (int i = 0; i < sub.size(); i++) {
            List temp = new ArrayList(sub.get(i));
            temp.add(num);
            ans.add(temp);
        }
        return ans;
    }

    // 78. 子集 - 迭代
    public List<List<Integer>> subsets2(int[] nums) {
        // 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
        // 说明：解集不能包含重复的子集。
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            int len = ans.size();
            for (int i = 0; i < len; i++) {
                List temp = new ArrayList(ans.get(i));
                temp.add(num);
                ans.add(temp);
            }
        }
        return ans;
    }

    // 78. 子集 - 位运算处理(效率不快,但思想很好)
    public List<List<Integer>> subsets(int[] nums) {
        // 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
        // 说明：解集不能包含重复的子集。
        List<List<Integer>> ans = new ArrayList<>();
        // (1 << nums.length): 将所有数的状态组合情况 遍历一遍(即 假设长度为4: 0000,0001,0010...1111)
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // ((i >> j) & 1) :只要i的二进制位为1 将对应数组下标的值加到sub
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            ans.add(sub);
        }
        return ans;
    }

    // 237. 删除链表中的节点node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 9. 回文数 - 解法2
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return x == r || x == r / 10;
    }

    // 9. 回文数
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(x));
        StringBuilder stringBuilder2 = new StringBuilder(Integer.toString(x)).reverse();
        return stringBuilder.toString().equals(stringBuilder2.toString());
    }

    // 42. 接雨水 - 动态规划
    public static int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    // 42. 接雨水 -  使用双指针
    public static int trap1(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    // 070 爬梯子 - 暴力递归法
    public static int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    // 070 爬梯子 - 增加一个记忆的功能
    public static int climbStairsWithMem(int i, int n, int[] mems) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        mems[i] = climbStairsWithMem(i + 1, n, mems) + climbStairsWithMem(i + 2, n, mems);
        return mems[i];
    }

    // 070 爬梯子 - 动态规划
    public static int climbStairsWithDynamicPlanning(int n) {
        if (n == 1) return 1;
        int[] m = new int[n + 1];
        m[1] = 1;
        m[2] = 2;
        for (int j = 3; j <= n; j++) {
            m[j] = m[j - 1] + m[j - 2];
        }
        return m[n];
    }

    // 070 爬梯子 - 菲波那切数列
    public static int climbStairsWithF(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    // 166. 整数到小数
    public static String fractionToDecimal(int numerator, int denominator) {
        // 方法 1：长除法
        //想法
        //
        //核心思想是当余数出现循环的时候，对应的商也会循环。
        //算法
        //
        //需要用一个哈希表记录余数出现在小数部分的位置，当你发现已经出现的余数，就可以将重复出现的小数部分用括号括起来。
        //
        //再出发过程中余数可能为 0，意味着不会出现循环小数，立刻停止程序。
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }

    // 61. 旋转链表

    public static ListNode rotateRight(ListNode head, int k) {
        //输入: 1->2->3->4->5->NULL, k = 2
        //输出: 4->5->1->2->3->NULL
        //解释:
        //向右旋转 1 步: 5->1->2->3->4->NULL
        //向右旋转 2 步: 4->5->1->2->3->NULL
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head, f;
        int num = 1;
        while (tail.next != null) {
            tail = tail.next;
            num++;
        }
        tail.next = head;
        k = k % num;
        f = head;
        for (int i = 0; i < num - k - 1; i++) {
            f = f.next;
        }
        head = f.next;
        f.next = null;

        return head;
    }

    // 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode f1 = l1, f2 = l2, r = result;
        while (f1 != null && f2 != null) {
            ListNode temp = f1.val < f2.val ? f1 : f2;
            r.next = temp;

            r = temp;
            if (f1.val < f2.val) {
                f1 = f1.next;
            } else {
                f2 = f2.next;
            }
        }
        if (f1 != null) {
            r.next = f1;
        }
        if (f2 != null) {
            r.next = f2;
        }
        return result.next;
    }

    // 两个数相加
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode f1 = l1;
        ListNode f2 = l2;
        ListNode r = result;
        int rat = 0;
        while (f1 != null || f2 != null || rat != 0) {
            int num1 = f1 == null ? 0 : f1.val;
            int num2 = f2 == null ? 0 : f2.val;
            int val = (num1 + num2 + rat) % 10;
            rat = (num1 + num2 + rat) / 10;

            ListNode temp = new ListNode(val);
            r.next = temp;

            r = temp;
            f1 = f1 == null ? null : f1.next;
            f2 = f2 == null ? null : f2.next;
        }
        return result.next;
    }

    //725. 分隔链表
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode f = root;
        int num = 0;
        while (f != null) {
            num++;
            f = f.next;
        }
        int splitLen = num / k;
        int raminder = num % k;
        f = root;
        ListNode[] result = new ListNode[k];
        int[] nums = new int[k];
        int i = 0;
        result[0] = root;
        while (f.next != null) {
            int maxNum = splitLen + (i < raminder ? 1 : 0);
            if (nums[i] >= maxNum - 1) {
                // 切断 ,放下一个数组
                ListNode temp = f.next;
                f.next = null;
                f = temp;
                i++;
                result[i] = f;
            } else {
                //
                nums[i]++;
                f = f.next;
            }
        }
        return result;
    }

    // 合并二叉树
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

    }

    // 交换二叉树
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(t);
        return root;
    }

    // 二叉树最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 汉明数
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}