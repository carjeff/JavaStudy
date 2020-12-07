import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverAnonymous;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.*;

/**
 * @author JeffCar
 * @date 12/6/2020 - 10:43 AM
 *
 * Leetcode 1
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class SumOfTwoNum {

    public int[] twoSum(int[] nums, int target){
        //将数组转换成list
        List<Integer> list = new ArrayList<>();
        for (int a : nums){
            list.add(a);
        }

        //num2 = target - num1
        //use list.indexOf metod to find num2
        for (int i =0; i< list.size(); i++){
            int num1 = list.get(i);
            int num2 = target - num1;
            int index = list.indexOf(num2);
            if (index != -1&&index!=i){
                int[] result = new int[2];
                result[0] = i;
                result[1] = index;
                return result;
            }

        }

        return null;
    }

    //************** 推荐
    public int[] twoSum2(int[] nums, int target){
        //采用map来做
        int[] index = new int[2]; //用来存放最后值
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i =0; i<nums.length; i++){

            //寻找接下来是否存在num2
            if (hash.containsKey(nums[i])){
                index[1] = i;
                index[0] = hash.get(nums[i]);
                return index;
            }
            //key用来存储补数num2，也就是target - num1， value 用来存放num1的下标
            hash.put(target - nums[i], i);
        }

        return null;
    }

    @Test
    public void test(){
        int[] a = new int[] {3,2,4};
        int[] twoSum = twoSum2(a, 6);
        System.out.println(twoSum[0]+","+twoSum[1]);
    }
}
