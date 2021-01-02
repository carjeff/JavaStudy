import org.junit.Test;

import java.util.*;

/**
 * @author JeffCar
 * @date 1/2/2021 - 7:32 PM
 *
 * 剑指offer 03
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            hashMap.put(nums[i],0);
        }
        for (int i =0; i<nums.length;i++){
            Integer a = hashMap.get(nums[i]) + 1;
            hashMap.put(nums[i],a);
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            Integer count = hashMap.get(nums[i]);
            if (count>1){
                set.add(nums[i]);
            }
        }

        int num = set.size();
        Random random = new Random();
        int i = random.nextInt(num);

        Object[] obj = set.toArray();
        int[] array = new int[obj.length];
        for (int j = 0; j<obj.length; j++){
            array[j] = (int) obj[j];
        }
        return array[i];
    }

    @Test
    public void main(){
        int[] nums = {2,3,1,0,2,5,3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
