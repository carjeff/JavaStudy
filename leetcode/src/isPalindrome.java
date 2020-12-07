import org.junit.Test;

/**
 * @author JeffCar
 * @date 12/7/2020 - 6:20 PM
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例  2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:  你能不将整数转为字符串来解决这个问题吗?

 */
public class isPalindrome {
    public boolean isPalindrome(int x){
        String str = Integer.toString(x);
        for (int i =0, j = str.length()-1; i<j;i++,j--){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }


    //不转换成String 去做
    public boolean isPalindrome2(int x){
        int old = x;
        int result = 0;
        if (x>=0){
            while (x != 0 ){
                int res = x%10;
                result = result*10 + res;
                x = x/10;
            }
            return result == old;
        }else{
            return false;
        }
    }


    @Test
    public void test(){
        System.out.println(isPalindrome2(100));
    }
}
