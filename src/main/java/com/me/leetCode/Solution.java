package com.me.leetCode;

import java.util.*;

import com.me.leetCode.ListNode;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;


public class Solution {

    @Test
    public void testTwoSum() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints);
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode listNode= new ListNode(2);
        ListNode listNode11 = new ListNode(4);
        listNode.next = listNode11;
        ListNode listNode12 = new ListNode(3);
        listNode11.next = listNode12;

        ListNode listNode2 = new ListNode(5);
        ListNode listNode21 = new ListNode(6);
        listNode2.next = listNode21;
        ListNode listNode22 = new ListNode(4);
        listNode21.next = listNode22;
        System.out.println(addTwoNumbers(listNode, listNode2));
    }

    /**
     *
     *  给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     *  你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     *  示例:
     *
     *  给定 nums = [2, 7, 11, 15], target = 9
     *  因为 nums[0] + nums[1] = 2 + 7 = 9
     *  所以返回 [0, 1]
     *
     * 方法三：一遍哈希表
     * 事实证明，我们可以一次完成。
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (map.containsKey(i1))
                return new int[]{map.get(i1), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        // 初始化的节点作为前节点
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            // 为当前节点设置下一个节点
            curr.next = new ListNode(sum % 10);
            // 下一个节点设置为当前节点
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    @Test
    public void testlengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
     */
    int lengthOfLongestSubstring(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    @Test
    public void testReverse() {
        System.out.println(reverse(23));
    }

    int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void testNumJewelsInStones() {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    int numJewelsInStones(String J, String S) {
        int no = 0;
        char[] chars = J.toCharArray();
        for (char c : chars) {
            while (S.indexOf(c) != -1) {
                no += 1;
                S = S.replaceFirst(c + "", "2");
            }
        }
        return no;
    }

    @Test
    public void testIn() {
        System.out.println(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }

    int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int[] ints = new int[Math.min(nums2.length, nums1.length)];

        int i = 0;
        for (int n : nums1) {
            if (Arrays.binarySearch(nums2, n) >= 0) {
                ints[i] = n;
                i++;
            }
        }
        return ints;
    }

    @Test
    public void testToLower() {
        System.out.println(toLowerCase("HAa"));
    }

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuffer lower = new StringBuffer();
        for (char c : chars) {
            if ( 65 <= (int)c && (int)c <= 90) {
                c = (char) (c + 32);
            }
            lower.append(c);
        }
        return lower.toString();
    }

    @Test
    public void testSort() {
        sortArrayByParity(new int[]{3,1,2,4});
    }

    public int[] sortArrayByParity(int[] A) {
        int[] sort = new int[A.length];
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sort[start] = A[i];
                start += 1;
            } else {
                sort[sort.length - 1 - end] = A[i];
                end += 1;
            }
        }
        return sort;
    }

    @Test
    public void testTitleToNumber() {
        System.out.println(titleToNumber("AB"));
        System.out.println(convertToTitle(52));
    }

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int number = 0;
        if (chars.length == 1) {
            number = chars[0] - 64;
        } else {
            for (int i = 0; i < chars.length - 1; i++) {
                number += (chars[i] - 64) * Math.pow(26, chars.length - i - 1);
            }
            number += chars[chars.length - 1] - 64;
        }
        return number;
    }

    public String convertToTitle(int n) {
        String title = "";
        if (n >= 1 && n <= 26) {
            title = (char)(n + 64) + "";
        } else {
            title += (char)(n / 26 + 64) + "" + (char)(n % 26 + 64);
        }
        return title;
    }

    @Test
    public void testFilp() {
        System.out.println(flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int x = A.length;
        int[][] result = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j= 0; j < x; j++) {
                result[i][j] = A[i][x - 1 - j] ^ 1;
            }
        }
        return result;
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] sort = new int[A.length];
        int i = 0, j = 1;
        for (int n = 0; n < A.length; n++) {
            if (A[n] % 2 == 0) {
                sort[i] = A[n];
                i += 2;
            } else {
                sort[j] = A[n];
                j += 2;
            }
        }
        return sort;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        if(moves == null)
            return true;

        for ( int i =0; i < moves.length(); i ++) {
            switch(moves.charAt(i)) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }

        if(x == 0 && y == 0)
            return true;
        return false;
    }

    @Test
    public void testFindC() {
        System.out.println(findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }

    public int findCircleNum(int[][] M) {
        Set<Integer> set = new HashSet<>();
        int no = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    if (!set.contains(i) && !set.contains(j) && i != j) {
                        no ++;
                    }
                    set.add(i);
                    set.add(j);
                }
            }
        }
        return no;
    }
}
