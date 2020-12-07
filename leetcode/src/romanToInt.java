import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JeffCar
 * @date 12/7/2020 - 6:52 PM
 *
 * Leetcode 13
 *
 * 罗马数字包含以下七种字符:   I，   V，   X，   L，C，D   和   M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做   II   ，即为两个并列的 1。12 写做   XII   ，即为   X   +   II   。 27 写做      XXVII, 即为   XX   +   V   +   II   。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做   IIII，而是   IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为   IX。这个特殊的规则只适用于以下六种情况：
 *
 * I   可以放在   V   (5) 和   X   (10) 的左边，来表示 4 和 9。
 * X   可以放在   L   (50) 和   C   (100) 的左边，来表示 40 和   90。   
 * C   可以放在   D   (500) 和   M   (1000) 的左边，来表示   400 和   900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1   到 3999 的范围内。
 *
 *    
 *
 * 示例   1:
 *
 * 输入:   "III"
 * 输出: 3
 * 示例   2:
 *
 * 输入:   "IV"
 * 输出: 4
 * 示例   3:
 *
 * 输入:   "IX"
 * 输出: 9
 * 示例   4:
 *
 * 输入:   "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例   5:
 *
 * 输入:   "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *    
 *
 * 提示：
 *
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class romanToInt {

    public int romanToInt1(String s){

        // 使用Map 会占用大量内存.
        Map<String,Integer> romanMap = new HashMap<>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);

        char[] arr = s.toCharArray();
//        System.out.println(arr);
        int num = 0;
//        if (arr.length == 2 ){
//            int num1 = romanMap.get(arr[0]+"");
//            int num2 = romanMap.get(arr[1]+"");
//            if(num1<num2){
//                num = num2 - num1;
//            }
//            return num;
//        }
        for (int i=0; i<arr.length; i++){
            String str = arr[i]+"";
            if ("I".equals(str)){
                if ((i+1)< arr.length){
                    if ("V".equals(arr[i+1]+"") || "X".equals(arr[i+1]+"")){
                        num -= 1;
                    }else {
                        num +=romanMap.get(arr[i]+"");
                    }
                }else {
                    num +=romanMap.get(arr[i]+"");
                }
            }else if ("X".equals(str)){
                if ((i+1)< arr.length){
                    if ("L".equals(arr[i+1]+"") || "C".equals(arr[i+1]+"")){
                        num -= 10;
                    }else {
                        num +=romanMap.get(arr[i]+"");
                    }
                } else {
                    num +=romanMap.get(arr[i]+"");
                }
            }else if ("C".equals(str)){
                if ((i+1)< arr.length){
                    if ("D".equals(arr[i+1]+"") || "M".equals(arr[i+1]+"")){
                        num -= 100;
                    }else {
                        num +=romanMap.get(arr[i]+"");
                    }
                }else {
                    num +=romanMap.get(arr[i]+"");
                }
            }else {
                int temp = romanMap.get(arr[i]+"");
                num += temp;
            }

        }
        return num;
    }



    public int romanToInt2(String s){
        char[] arr = s.toCharArray();
        int num =0;
        for (int i=0; i<arr.length;i++){
            char t = arr[i];
            switch (t){
                case 'I':
                    if ((i+1)<arr.length && ('X'== arr[i+1] || 'V' == arr[i+1])){
                        num -= 1;
                    }else {
                        num += 1;
                    }
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    if ((i+1)<arr.length && ('C'== arr[i+1] || 'L' == arr[i+1])){
                        num -= 10;
                    }else {
                        num += 10;
                    }
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    if ((i+1)<arr.length && ('D'== arr[i+1] || 'M' == arr[i+1])){
                        num -= 100;
                    }else {
                        num += 100;
                    }
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num +=1000;
                    break;
            }
        }
        return num;
    }
    @Test
    public void test(){
        System.out.println(romanToInt2("III"));
    }
}
