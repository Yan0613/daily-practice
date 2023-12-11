import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSumso(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + nums[left] + nums[right] > 0) {
                right--;
            } else if (nums[i] + nums[left] + nums[right] < 0) {
                left++;
            } else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (right > left && nums[right] == nums[right - 1]) {
                    right--;
                }
                while (right > left && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
                right--;
            }
        }
        return result;
    }

}
