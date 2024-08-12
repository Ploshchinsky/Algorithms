package LeetCode;

//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
public class RemoveElement {
    static int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    static int val = 2;

    public static void main(String[] args) {
        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
