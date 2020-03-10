package com.inspingArithmetic;

import java.util.Arrays;
import java.util.Random;

/**
 * 常用排序算法
 */
public class ArithmeticSort {


    public static int[] randomNums(int n) {
        int[] nums = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(1000);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 冒泡
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // 选择
    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) index = j;
            }
            if (index != i) {
                swap(nums, i, index);
            }
        }
    }

    // 插入
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    // 快速
    public void quickSortMain(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int i = low, j = high;
        int temp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= temp) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= temp) i++;
            nums[j] = nums[i];
        }
        nums[i] = temp;
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0, start1 = low, start2 = mid + 1;
        while (start1 <= mid && start2 <= high) {
            if (nums[start1] <= nums[start2])
                temp[index++] = nums[start1++];
            else
                temp[index++] = nums[start2++];
        }
        while (start1 <= mid)
            temp[index++] = nums[start1++];
        while (start2 <= high)
            temp[index++] = nums[start2++];
        for (int i = 0; i < temp.length; i++)
            nums[low + i] = temp[i];
    }

    // 归并(递归)
    public void mergeSortRecursion(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = low + ((high - low) >> 1);
        mergeSortRecursion(nums, low, mid);
        mergeSortRecursion(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    // 归并(迭代)
    public void mergeSortIteration(int[] nums) {
        int step = 2;
        int n = nums.length;
        while (step <= nums.length) {
            for (int i = 0; i < nums.length; i += step) {
                int end = Math.min(n - 1, i + step - 1);
                merge(nums, i, (i + end) / 2, end);
            }
            step <<= 1;
        }
    }

    // 归并
    public void mergeSort(int[] nums) {
//        mergeSortRecursion(nums, 0, nums.length - 1);
        mergeSortIteration(nums);
    }

    // 计数排序(基础版)
    public void countingSort(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        int[] c = new int[max + 1];
        for (int num : nums) {
            c[num]++;
        }
        int[] b = new int[nums.length];
        int index = 0;
        for (int i = 0; i < c.length; i++) {
            while (c[i] > 0) {
                b[index++] = i;
                c[i]--;
            }
        }
        nums = b;
    }

    // 计数排序(优化版)
    public void countingSortPro(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int[] c = new int[max - min + 1];
        for (int num : nums) {
            c[num - min]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        System.out.println(Arrays.toString(c));
        int[] b = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            //减去min是为了优化存储空间，这样得到新的转换值，
            int pos = nums[i] - min;
            int sumCount = c[pos];
            System.out.println(nums[i] + " 在原数组的排序后的位置是： " + (sumCount - 1));
            //把最终生层的排序值，放在新的数组里面返回
            b[sumCount - 1] = nums[i];
            c[pos]--; //如果有重复元素，位置需要从右向左放置，所以需要把sumCount的值-1
        }
        nums = b;
    }


    public static void main(String[] args) {
        int[] nums = randomNums(11);
        ArithmeticSort sort = new ArithmeticSort();
//        sort.bubbleSort(nums);
//        sort.selectSort(nums);
//        sort.insertSort(nums);
//        sort.quickSortMain(nums);
        sort.countingSortPro(new int[]{2, 3, 2, 1, 1, 1, 3, 1, 0, 5});
        System.out.println(Arrays.toString(nums));
    }
}
