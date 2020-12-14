import org.junit.Test;

import java.util.Optional;

/**
 * @author JeffCar
 * @date 12/14/2020 - 4:59 PM
 */
public class OptionalTest {

    @Test
    public void test(){

        //Optional.of(value)  非空
        Girl girl =new Girl();
        Optional<Girl> girl1 = Optional.of(girl);
        //Optional.empty()

        //Optional.ofNullable(T t) t 可以null

    }

    public String getGirlName(Boy boy){
        Optional<Boy> boy1 = Optional.ofNullable(boy);

        //orElse(T t) 如果是空的，返回t
        Boy xx = boy1.orElse(new Boy(new Girl("xx")));
        Girl girl = xx.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("na"));

        return girl2.getName();
    }
}
