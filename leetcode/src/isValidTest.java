import org.junit.Test;

/**
 * @author JeffCar
 * @date 12/7/2020 - 8:35 PM
 *
 * Leetcode 20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true

 */
public class isValidTest {

    //使用栈来做匹配
    public boolean isValid(String s){
        int len = s.length();
        //如果字符个数是奇数，肯定不匹配
        if (len % 2 != 0) {
            return false;
        }


        return false;
    }

    @Test
    public void test(){

    }
}
