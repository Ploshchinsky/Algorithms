package Stack;

public class RemoveDuplicatesFromSortedArr {
    static int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    public static void main(String[] args) {
        System.out.println(removeDuplicates(input));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
