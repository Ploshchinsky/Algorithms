package LeetCode;

import java.util.Arrays;

public class SearchInsertPosition {
    static int[] arr = {1, 3, 5, 9, 12, 19, 22, 27, 31, 40};

    public static void main(String[] args) {
        System.out.println(searchInsert(arr, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int mid = nums.length / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums.length == 1 && nums[mid] != target) {
            return target > nums[mid] ? +1 : 0;
        }
        int[] temp;
        if (target < nums[mid]) {
            temp = Arrays.copyOfRange(nums, 0, mid);
            return (searchInsert(temp, target));
        } else {
            temp = Arrays.copyOfRange(nums, mid, nums.length);
            return mid + (searchInsert(temp, target));
        }
    }
}
