import org.junit.Test;

/**
 * @author JeffCar
 * @date 12/7/2020 - 7:44 PM
 *
 * LeetCode 14.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestCommonPrefixTest {
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0)
            return "";
        int minLength = strs[0].length();
        String minString = strs[0];

        //找出最短的字符串
        for (int i=0; i<strs.length; i++){
            if (strs[i].length() < minLength){
                minLength = strs[i].length();
                minString = strs[i];
            }
        }
        //将最短的字符串作为查找，从大到小查
        int i, j;
        for (i = 0; i<minLength; i++){
            String str = minString.substring(0,minLength-i);
            for (j = 0; j<strs.length;j++){
                if (!(strs[j].startsWith(str)))
                    break;
            }
            if (j == strs.length){
                return str;
            }
        }
        return "";
    }

    @Test
    public void test(){
        String[] arr = new String[]{};
        System.out.println(longestCommonPrefix(arr));
    }
}
