import org.junit.Test;

/**
 * @author JeffCar
 * @date 1/3/2021 - 10:43 AM
 */
public class ReplaceSpace {

    public String replaceSpace(String s){
        String result = "";
        int start = 0;
        int end = 0;
        int n = s.length();
        for (int i=0; i<n ; i++){
            if (s.charAt(i) == ' '){
                String a = s.substring(start,end);
                result = result + a +"%20";
                end = i+1;
                start = i+1;
            }else {
                end++;
            }
        }
        result = result + s.substring(start,end);
        return result;
    }

    public String replaceSpace1(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i<s.length(); i++){
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


    @Test
    public  void  test(){
        String s = "We are happy.";
        String s1 = replaceSpace1(s);
        System.out.println(s1);
    }
}
