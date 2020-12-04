package enum_test;

/**
 * @author JeffCar
 * @date 12/1/2020 - 6:24 PM
 *
 * 自定义枚举类
 */
public class Season {
    private final String seasonName;

    public Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public static final Season SPRING = new Season("春天");
    public static final Season SUMMER = new Season("春天");
    public static final Season AUTUMN = new Season("春天");
    public static final Season WINTER = new Season("春天");
}

enum SeasonEnum {
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");
    private final String seasonName;

    SeasonEnum(String seasonName) {
        this.seasonName = seasonName;
    }
}